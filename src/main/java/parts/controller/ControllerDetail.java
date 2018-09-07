package parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import parts.entities.Detail;
import parts.services.DetailService;

@Controller
@RequestMapping("/")
public class ControllerDetail {

    @Autowired
    private DetailService serviceClassDetail;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String findByName(String name, Model model) {
        Detail detail = serviceClassDetail.findByName(name);
        model.addAttribute(detail);
        return null; // name JSP
    }

}
