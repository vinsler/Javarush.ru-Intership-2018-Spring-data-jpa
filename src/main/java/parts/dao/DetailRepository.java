package parts.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import parts.entities.Detail;

import java.util.List;


@Repository // создали интерфейс JPA репозитория
public interface DetailRepository extends JpaRepository<Detail, Integer> {

    Detail findByName(String name);
    List<Detail> findByRequired(Pageable pageable, boolean required);
    List<Detail> findByRequired(boolean required);

    @Query (value = "Select min(d.count) from detail d", nativeQuery = true)
    Integer findMinimum();




}
