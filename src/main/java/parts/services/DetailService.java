package parts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import parts.dao.DetailRepository;
import parts.entities.Detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    public Integer findAllSize() {
        return detailRepository.findAll().size();
    }

    public List<Detail> findAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Detail> pageList = detailRepository.findAll(pageable);
        return pageList.getContent();
    }

    public List<Detail> findByRequired(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return detailRepository.findByRequired(pageable, true);
    }

    public Integer findByRequiredSize() {
        return detailRepository.findByRequired(true).size();
    }

    public List<Detail> findByOptional(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return detailRepository.findByRequired(pageable, false);
    }

    public Integer findByOptionalSize() {
        return detailRepository.findByRequired(false).size();
    }

    public Detail findDetailMinimum() {
        return detailRepository.findFirstByRequiredOrderByCountAsc(true);
    }

    public void delete(Integer id) {
        detailRepository.deleteById(id);
    }

    public Detail findByName(String name) {
        Detail detail = detailRepository.findByName(name);
        if (detail == null) {
            return new Detail();
        }
        return detail;
    }

    public DetailEditModel findByNameForDetailEdit(String name) {
        Detail detail = detailRepository.findByName(name);
        if (detail == null) {
            return new DetailEditModel();
        }
        DetailEditModel detailEditModel = new DetailEditModel();
        detailEditModel.setId(detail.getId());
        detailEditModel.setName(detail.getName());
        detailEditModel.setRequired(detail.isRequired());
        detailEditModel.setCount(String.valueOf(detail.getCount()));
        return detailEditModel;
    }


    public Integer insert(DetailEditModel detailEditModel) {
        if (detailEditModel.getName() == null || detailEditModel.getName().equals("")) {
            return 0;
        }
        if (detailRepository.findByName(detailEditModel.getName()) != null) {
            return 0;
        }
        Detail detail = new Detail();
        detail.setId(detailEditModel.getId());
        detail.setName(detailEditModel.getName());
        detail.setRequired(detailEditModel.isRequired());
        try {
            detail.setCount(Integer.parseInt(detailEditModel.getCount().trim()));
            if (detail.getCount() <= 0) {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
        detailRepository.saveAndFlush(detail);
        return detailRepository.findAll().size() / 10;
    }

    public void update(DetailEditModel detailEditModel) {
        Detail detail = new Detail();
        detail.setId(detailEditModel.getId());
        detail.setName(detailEditModel.getName());
        detail.setRequired(detailEditModel.isRequired());
        try {
            detail.setCount(Integer.parseInt(detailEditModel.getCount()));
        } catch (Exception e) {
            return;
        }
        Optional<Detail> detailOptional = detailRepository.findById(detail.getId());
        Detail detailGet = detailOptional.orElseThrow(() -> new RuntimeException("detail not find."));
        detailGet.setName(detail.getName());
        detailGet.setCount(detail.getCount());
        detailGet.setRequired(detail.isRequired());
        detailRepository.saveAndFlush(detailGet);
    }

    public Model prewReturn(Model model, List<Detail> detailList, Integer page, Integer size,
                            String viewer, DetailEditModel detailAddModel, Integer detailCountMin, DetailEditModel detailEditModel) {
        model.addAttribute(detailList);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("nameoflist", viewer);
        model.addAttribute("detailAddModel", detailAddModel);
        model.addAttribute("minCount", detailCountMin);
        model.addAttribute("detailEditModel", detailEditModel);
        return model;
    }

    public String creatRedirectForEditDelete(int dlist, String nameoflist, int page) {
        StringBuffer sb = new StringBuffer().append("redirect:/");
        switch (nameoflist) {
            case "view": {
                sb.append("view?page=");
                break;
            }
            case "required": {
                sb.append("required?page=");
                break;
            }
            case "optional": {
                sb.append("optional?page=");
                break;
            }
            case "find": {
                return "redirect:/view?page=0";
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

    public List<Detail> detailListReturn(String nameoflist, DetailEditModel detailEditModel, Integer page) {
        List<Detail> detailList = null;
        Pageable pageable = PageRequest.of(page, 10);

        switch (nameoflist) {
            case "view": {
                detailList = detailRepository.findAll(pageable).getContent();
                break;
            }
            case "required": {
                detailList = detailRepository.findByRequired(pageable, true);
                break;
            }
            case "optional": {
                detailList = detailRepository.findByRequired(pageable, false);
                break;
            }
            case "find": {
                detailList = new ArrayList<>();
                detailList.add(detailRepository.findByName(detailEditModel.getName()));
                break;
            }
        }
        return detailList;
    }
}
