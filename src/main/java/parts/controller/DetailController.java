package parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import parts.entities.Detail;
import parts.services.DetailService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/")
@Controller
public class DetailController {

    @Autowired
    private DetailService detailService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/view")
    public String findAll(Model model, @RequestParam Integer page) {
        List<Detail> detailList = detailService.findAll(page);
        Integer size = detailService.findAllSize();
        Integer detailCountMin = detailService.findDetailMinimum().getCount();
        model = detailService.prewReturn(model, detailList, page, size,
                "view", new Detail(), detailCountMin, new Detail());
        return "view";
    }

    @GetMapping("/required")
    public String findByRequired(Model model, @RequestParam Integer page) {
        List<Detail> detailList = detailService.findByRequired(page);
        Integer size = detailService.findByRequiredSize();
        Integer detailCountMin = detailService.findDetailMinimum().getCount();
        model = detailService.prewReturn(model, detailList, page, size,
                "required", new Detail(), detailCountMin, new Detail());
        return "view";
    }

    @GetMapping("/optional")
    public String findByNotRequired(Model model, @RequestParam Integer page) {
        List<Detail> detailList = detailService.findByOptional(page);
        Integer size = detailService.findByOptionalSize();
        Integer detailCountMin = detailService.findDetailMinimum().getCount();
        model = detailService.prewReturn(model, detailList, page, size,
                "optional", new Detail(), detailCountMin, new Detail());
        return "view";
    }

    @GetMapping("/delete/{id}/{page}/{dlist}/{nameoflist}")
    public String delete(Model model,
                         @PathVariable("id") int id,
                         @PathVariable("page") int page,
                         @PathVariable("dlist") int dlist,
                         @PathVariable("nameoflist") String nameoflist) {
        detailService.delete(id);
        return detailService.creatRedirectForEditDelete(dlist, nameoflist, page);
    }

    @GetMapping("/find")
    public String findByName(Model model, @RequestParam String name) {
        List<Detail> detailList = new ArrayList<>();
        Detail detail = detailService.findByName(name);
        if (detail.getName() == null) {
            return "redirect:/view?page=0";
        }
        detailList.add(detail);
        Integer detailCountMin = detailService.findDetailMinimum().getCount();
        model = detailService.prewReturn(model, detailList, 0, 1,
                "find", new Detail(), detailCountMin, new Detail());
        return "view";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("ctrlDetail") Detail detail) {
        Integer page = detailService.insert(detail);
        return "redirect:/view?page=" + page;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("detailEdit") Detail detail) {


        detailService.update(detail);
        return "redirect:/view?page=0";
    }

    @GetMapping("/edit")
    public String edit(Model model,
                       @RequestParam String name,
                       @RequestParam Integer page,
                       @RequestParam Integer size,
                       @RequestParam String nameoflist) {
        Integer detailCountMin = detailService.findDetailMinimum().getCount();
        Detail detailEdit = detailService.findByName(name);
        model.addAttribute("detailEdit", detailEdit);
        List<Detail> detailList = detailService.detailListReturn(nameoflist, detailEdit, page);
        model = detailService.prewReturn(model, detailList, page, size,
                nameoflist, new Detail(), detailCountMin, detailEdit);
        return "view";
    }
}
