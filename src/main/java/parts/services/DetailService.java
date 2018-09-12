package parts.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import parts.dao.DetailRepository;
import parts.entities.Detail;


import java.util.List;

@Service // создали сервис класс Детали
public class DetailService {

    @Autowired // автозагрузили интерфейс JPA репозитория
    private DetailRepository detailRepository;

    public Integer findAllSize(){
        return detailRepository.findAll().size();
    }

    public List<Detail> findAll(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Detail> pageList = detailRepository.findAll(pageable);
        return  pageList.getContent();
    }

    public void delete(Integer id){
        detailRepository.deleteById(id);
    }


}
