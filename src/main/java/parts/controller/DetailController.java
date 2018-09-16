package parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import parts.entities.Detail;
import parts.services.DetailEditModel;
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
                "view", new DetailEditModel(), detailCountMin, new DetailEditModel());
        return "view";
    }

    @GetMapping("/required")
    public String findByRequired(Model model, @RequestParam Integer page) {
        List<Detail> detailList = detailService.findByRequired(page);
        Integer size = detailService.findByRequiredSize();
        Integer detailCountMin = detailService.findDetailMinimum().getCount();
        model = detailService.prewReturn(model, detailList, page, size,
                "required", new DetailEditModel(), detailCountMin, new DetailEditModel());
        return "view";
    }

    @GetMapping("/optional")
    public String findByNotRequired(Model model, @RequestParam Integer page) {
        List<Detail> detailList = detailService.findByOptional(page);
        Integer size = detailService.findByOptionalSize();
        Integer detailCountMin = detailService.findDetailMinimum().getCount();
        model = detailService.prewReturn(model, detailList, page, size,
                "optional", new DetailEditModel(), detailCountMin, new DetailEditModel());
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
                "find", new DetailEditModel(), detailCountMin, new DetailEditModel());
        return "view";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("detailAddModel") DetailEditModel detailEditModel) {
        Integer page = detailService.insert(detailEditModel);
        return "redirect:/view?page=" + page;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("detailEditModel") DetailEditModel detailEditModel) {


        detailService.update(detailEditModel);
        return "redirect:/view?page=0";
    }

    @GetMapping("/edit")
    public String edit(Model model,
                       @RequestParam String name,
                       @RequestParam Integer page,
                       @RequestParam Integer size,
                       @RequestParam String nameoflist) {
        Integer detailCountMin = detailService.findDetailMinimum().getCount();
        DetailEditModel detailEditModel = detailService.findByNameForDetailEdit(name);

        model.addAttribute("detailEdit", detailEditModel);
        List<Detail> detailList = detailService.detailListReturn(nameoflist, detailEditModel, page);

        model = detailService.prewReturn(model, detailList, page, size,
                nameoflist, new DetailEditModel(), detailCountMin, detailEditModel);

        return "view";
    }
}
