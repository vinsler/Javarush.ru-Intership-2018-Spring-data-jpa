package parts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parts.entities.Detail;

import java.util.List;

@Repository // создали интерфейс JPA репозитория
public interface DetailRepository extends JpaRepository<Detail, Integer> {

    Detail findDetailByName(String name);   // поиск по имени
    List<Detail> findAll();                 // все детали

}
