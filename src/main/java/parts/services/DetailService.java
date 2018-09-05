package parts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parts.dao.DetailRepository;
import parts.entities.Detail;

@Service
public class DetailService {

    @Autowired
    private DetailRepository detailRepository;

    public Detail find(Integer id) {
        return detailRepository.getOne(id);
    }

    public Detail findByName(String name) {
        return detailRepository.findDetailByName(name);
    }

}
