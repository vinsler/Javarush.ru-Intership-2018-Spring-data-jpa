package parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import parts.entities.Detail;
import parts.services.DetailService;

import java.util.List;

@RequestMapping ("/")
@Controller // создали контроллер деталей

public class ControllerDetail {

    @Autowired // автозагрузили класс сервиса деталей
    private DetailService serviceClassDetail;

    @GetMapping("/") // начальная страница при загрузке
    public String index(){
        return "index";
    }


    @GetMapping("/parts") // имя/шаблон для web
    public String Detail() {
        return "parts"; // {имя без расширения *.jsp} = {parts + .jsp} = {parts.jsp}
    }

    @GetMapping("/view")
    public String findAll(Model model) {
        List<Detail> detailList = serviceClassDetail.findAll();
        model.addAttribute(detailList);
        return "view";
    }
}
