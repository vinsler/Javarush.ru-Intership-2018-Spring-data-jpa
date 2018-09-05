package parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import parts.entities.Detail;
import parts.services.DetailService;

@Controller
public class ControllerDetail {

    @Autowired
    private DetailService serviceClassDetail;

    @RequestMapping
    public String findByName(String name, Model model) {
        Detail detail = serviceClassDetail.findByName(name);
        model.addAttribute(detail);
        return null; // name JSP
    }

}
