package parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import parts.entities.Detail;
import parts.services.DetailService;

import java.util.ArrayList;
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

    @GetMapping("/view")
    public String findAll(Model model, @RequestParam Integer page) {
        List<Detail> detailList = serviceClassDetail.findAll(page);
        Integer size = serviceClassDetail.findAllSize();

        Integer detailMinCount = serviceClassDetail.findMinimum();
        model.addAttribute("minCount", detailMinCount);

        model.addAttribute(detailList);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("nameoflist", "view");
        return "view";
    }

    @GetMapping ("/required")
    public String findByRequired(Model model, @RequestParam Integer page){
        List<Detail> detailList = serviceClassDetail.findByRequired(page);
        Integer size = serviceClassDetail.findByRequiredSize();
        model.addAttribute(detailList);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("nameoflist", "required");
        return "view";
    }

    @GetMapping ("/optional")
    public String findByNotRequired(Model model, @RequestParam Integer page){
        List<Detail> detailList = serviceClassDetail.findByOptional(page);
        Integer size = serviceClassDetail.findByOptionalSize();
        model.addAttribute(detailList);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("nameoflist", "optional");
        return "view";
    }

    @GetMapping("/delete/{id}/{page}/{dlist}/{nameoflist}")
    public String delete(Model model, @PathVariable("id") int id, @PathVariable("page") int page,
                         @PathVariable("dlist") int dlist, @PathVariable("nameoflist") String nameoflist) {
        serviceClassDetail.delete(id);
        StringBuffer sb = new StringBuffer().append("redirect:/");
        switch (nameoflist) {
            case "view":{
                sb.append("view?page=");
                break;
            }
            case "required":{
                sb.append("required?page=");
                break;
            }
            case "optional" :{
                sb.append("optional?page=");
                break;
            }
            case "find" :{
                sb.append("find?page=");
                break;
            }
        }
        if (dlist == 1 && page > 0) {
            page -= page;
            sb.append(page);
            return sb.toString();
        }
        sb.append(page);
        return sb.toString();
    }

    @GetMapping("/findByName/{name}")
    public String findByName(Model model, @PathVariable("name") String name){
        List<Detail> detailList = new ArrayList<>();
        detailList.add(serviceClassDetail.findByName(name));

        model.addAttribute(detailList);
        model.addAttribute("page", 0);
        model.addAttribute("size", 1);
        model.addAttribute("nameoflist", "find");
        return "view";
    }


    @GetMapping("/add") // имя/шаблон для web
    public void add() {
    }


    @GetMapping("/edit/{id}")
    public String edit(Model model, Integer id) {
        return "remove";
    }
}
