package parts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import parts.entities.Detail;


@Repository // создали интерфейс JPA репозитория
public interface DetailRepository extends JpaRepository<Detail, Integer> {



}
