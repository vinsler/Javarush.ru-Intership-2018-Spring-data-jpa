package parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/view")
    public String findAll(Model model, @RequestParam Integer page) {
        List<Detail> detailList = serviceClassDetail.findAll(page);
        Integer size = serviceClassDetail.findAllSize();
        model.addAttribute(detailList);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        return "view";
    }

    @GetMapping("/delete/{id}/{page}/{dlist}")
    public String delete(Model model, @PathVariable("id") int id, @PathVariable("page") int page,
                         @PathVariable("dlist") int dlist) {
        serviceClassDetail.delete(id);
        if (dlist == 1 && page > 0) {
            page -= page;
            return "redirect:/view?page=" + page;
        }
        return "redirect:/view?page=" + page;
    }

    @GetMapping("/add") // имя/шаблон для web
    public void add() {

    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, Integer id) {
        return "remove";
    }

    @GetMapping("/find") // имя/шаблон для web
    public String findByName(Model model, String name) {
        return "add"; // {имя без расширения *.jsp} = {parts + .jsp} = {add.jsp}
    }
}
