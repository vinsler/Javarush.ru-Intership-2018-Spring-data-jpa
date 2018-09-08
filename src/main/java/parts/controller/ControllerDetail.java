package parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import parts.entities.Detail;
import parts.services.DetailService;

import java.util.List;

@Controller
public class ControllerDetail {

    @Autowired
    private DetailService serviceClassDetail; // запускает сервис

    @RequestMapping("/parts") // имя для сервлета
    public String Detail(String name, Model model) {
        List <Detail> detail = serviceClassDetail.findAll();
        model.addAttribute(detail);
        return "parts"; // {имя без расширения *.jsp} = {parts + .jsp} = {parts.jsp}
    }

    @RequestMapping("/view")
    public String findByName(String name, Model model) {
        Detail detail = serviceClassDetail.findByName(name);
        model.addAttribute(detail);
        return "view";
    }
}
