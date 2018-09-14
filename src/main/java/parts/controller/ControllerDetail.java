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

        Integer detailMinCount = serviceClassDetail.findFirstByRequiredOrderByCountAsc().getCount();

        //Integer detailMinCount = serviceClassDetail.findMinimum();
        model.addAttribute("minCount", detailMinCount);

        model = serviceClassDetail.prewReturn(model, detailList, page, size, "view");

//        model.addAttribute(detailList);
//        model.addAttribute("page", page);
//        model.addAttribute("size", size);
//        model.addAttribute("nameoflist", "view");
//        model.addAttribute("ctrlDetail", new Detail());
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
        model.addAttribute("ctrlDetail", new Detail());
        return "view";
    }

    @GetMapping ("/optional")
    public String findByNotRequired(Model model, @RequestParam Integer page){
        List<Detail> detailList = serviceClassDetail.findByOptional(page);
        Integer size = serviceClassDetail.findByOptionalSize();

        model = serviceClassDetail.prewReturn(model, detailList, page, size, "optional");

//        model.addAttribute(detailList);
//        model.addAttribute("page", page);
//        model.addAttribute("size", size);
//        model.addAttribute("nameoflist", "optional");
//        model.addAttribute("ctrlDetail", new Detail());
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

//        StringBuffer sb = new StringBuffer().append("redirect:/");
//        switch (nameoflist) {
//            case "view":{
//                sb.append("view?page=");
//                break;
//            }
//            case "required":{
//                sb.append("required?page=");
//                break;
//            }
//            case "optional" :{
//                sb.append("optional?page=");
//                break;
//            }
//            case "find" :{
//                return "redirect:/view?page=0";
//            }
//        }
//        if (dlist == 1 && page > 0) {
//            page -= page;
//            sb.append(page);
//            return sb.toString();
//        }
//        sb.append(page);
//        return sb.toString();
    }

    @GetMapping("/find")
    public String findByName(Model model, @RequestParam String name){
        List<Detail> detailList = new ArrayList<>();
        Detail detail = serviceClassDetail.findByName(name);
        if (detail.getName() == null) {
            return "redirect:/view?page=0";
        }
        detailList.add(detail);

        model = serviceClassDetail.prewReturn(model, detailList, 0, 1, "find");

//        model.addAttribute(detailList);
//        model.addAttribute("page", 0);
//        model.addAttribute("size", 1);
//        model.addAttribute("nameoflist", "find");
//        model.addAttribute("ctrlDetail", new Detail());
        return "view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("ctrlDetail") Detail detail) {
        serviceClassDetail.insert(detail);
        return "redirect:/view?page=0";
    }


    @GetMapping("/edit/{name}/{page}/{dlist}/{nameoflist}")
    public String edit(Model model,
                       @PathVariable("name") String name,
                       @PathVariable("page") int page,
                       @PathVariable("dlist") int dlist,
                       @PathVariable("nameoflist") String nameoflist){
        Detail detailForEdit = serviceClassDetail.findByName(name);

        System.out.println(detailForEdit.getName() + detailForEdit.getId() + detailForEdit.getCount());
        String str = serviceClassDetail.creatRedirectForEditDelete(dlist, nameoflist, page);
        model.addAttribute("detailForEdit", detailForEdit);

        return str; // "redirect:/[nameoflist]?=[page]" куда идет этот редирект на джсп или на контроллер?
    }
}
