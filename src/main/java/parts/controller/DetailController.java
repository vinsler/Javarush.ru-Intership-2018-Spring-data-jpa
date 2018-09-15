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
    private DetailService serviceClassDetail;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/view")
    public String findAll(Model model, @RequestParam Integer page) {
        List<Detail> detailList = serviceClassDetail.findAll(page);
        Integer size = serviceClassDetail.findAllSize();
        Integer detailCountMin = serviceClassDetail.findDetailMinimum().getCount();
        model = serviceClassDetail.prewReturn(model, detailList, page, size,
                "view", new Detail(), detailCountMin, new Detail());
        return "view";
    }

    @GetMapping("/required")
    public String findByRequired(Model model, @RequestParam Integer page) {
        List<Detail> detailList = serviceClassDetail.findByRequired(page);
        Integer size = serviceClassDetail.findByRequiredSize();
        Integer detailCountMin = serviceClassDetail.findDetailMinimum().getCount();
        model = serviceClassDetail.prewReturn(model, detailList, page, size,
                "required", new Detail(), detailCountMin, new Detail());
        return "view";
    }

    @GetMapping("/optional")
    public String findByNotRequired(Model model, @RequestParam Integer page) {
        List<Detail> detailList = serviceClassDetail.findByOptional(page);
        Integer size = serviceClassDetail.findByOptionalSize();
        Integer detailCountMin = serviceClassDetail.findDetailMinimum().getCount();
        model = serviceClassDetail.prewReturn(model, detailList, page, size,
                "optional", new Detail(), detailCountMin, new Detail());
        return "view";
    }

    @GetMapping("/delete/{id}/{page}/{dlist}/{nameoflist}")
    public String delete(Model model,
                         @PathVariable("id") int id,
                         @PathVariable("page") int page,
                         @PathVariable("dlist") int dlist,
                         @PathVariable("nameoflist") String nameoflist) {
        serviceClassDetail.delete(id);
        return serviceClassDetail.creatRedirectForEditDelete(dlist, nameoflist, page);
    }

    @GetMapping("/find")
    public String findByName(Model model, @RequestParam String name) {
        List<Detail> detailList = new ArrayList<>();
        Detail detail = serviceClassDetail.findByName(name);
        if (detail.getName() == null) {
            return "redirect:/view?page=0";
        }
        detailList.add(detail);
        Integer detailCountMin = serviceClassDetail.findDetailMinimum().getCount();
        model = serviceClassDetail.prewReturn(model, detailList, 0, 1,
                "optional", new Detail(), detailCountMin, new Detail());
        return "view";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("ctrlDetail") Detail detail) {
        serviceClassDetail.insert(detail);
        return "redirect:/view?page=0";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("detailEdit") Detail detail) {
        serviceClassDetail.update(detail);
        return "redirect:/view?page=0";
    }

    @GetMapping("/edit")
    public String edit(Model model,
                       @RequestParam String name,
                       @RequestParam Integer page,
                       @RequestParam Integer size,
                       @RequestParam String nameoflist) {
        Integer detailCountMin = serviceClassDetail.findDetailMinimum().getCount();
        Detail detailEdit = serviceClassDetail.findByName(name);
        model.addAttribute("detailEdit", detailEdit);
        List<Detail> detailList = serviceClassDetail.detailListReturn(nameoflist, detailEdit, page);
        model = serviceClassDetail.prewReturn(model, detailList, page, size,
                nameoflist, new Detail(), detailCountMin, detailEdit);
        return "view";
    }
}
