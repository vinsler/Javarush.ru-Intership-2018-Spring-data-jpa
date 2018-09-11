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


@Controller // создали контроллер деталей

public class ControllerDetail {

    @Autowired // автозагрузили класс сервиса деталей
    private DetailService serviceClassDetail;


    @RequestMapping(value = "/parts", method = RequestMethod.GET) // имя/шаблон для web
    public String Detail(String name, Model model) {
        List <Detail> detail = serviceClassDetail.findAll();
        model.addAttribute(detail);
        return "parts"; // {имя без расширения *.jsp} = {parts + .jsp} = {parts.jsp}
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String findByName(String name, Model model) {
        Detail detail = serviceClassDetail.findByName(name);
        model.addAttribute(detail);
        return "view";
    }
}
