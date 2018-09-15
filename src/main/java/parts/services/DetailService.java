package parts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import parts.dao.DetailRepository;
import parts.entities.Detail;

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

    public void insert(Detail detail) {
        detailRepository.saveAndFlush(detail);
    }

    public void update(Detail detail) {
        Optional<Detail> detailOptional = detailRepository.findById(detail.getId());
        Detail detailGet = detailOptional.orElseThrow(() -> new RuntimeException("detail not find."));
        detailGet.setName(detail.getName());
        detailGet.setCount(detail.getCount());
        detailGet.setRequired(detail.isRequired());
        detailRepository.saveAndFlush(detailGet);
    }

    public Model prewReturn(Model model, List<Detail> detailList, Integer page, Integer size,
                            String viewer, Detail detail, Integer detailCountMin, Detail detailEdit) {
        model.addAttribute(detailList);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("nameoflist", viewer);
        model.addAttribute("ctrlDetail", detail);
        model.addAttribute("minCount", detailCountMin);
        model.addAttribute("detailEdit", detailEdit);
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

    public List<Detail> detailListReturn(String nameoflist, Detail detail, Integer page) {
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
                detailList.add(detail);
                break;
            }
        }
        return detailList;
    }
}
