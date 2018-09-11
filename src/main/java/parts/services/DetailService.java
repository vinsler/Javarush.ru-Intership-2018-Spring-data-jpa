package parts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parts.dao.DetailRepository;
import parts.entities.Detail;

import java.util.List;

@Service // создали сервис класс Детали
public class DetailService {

    @Autowired // автозагрузили интерфейс JPA репозитория
    private DetailRepository detailRepository;

    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    public Detail findByName(String name) {
        return detailRepository.findDetailByName(name);
    }

}
