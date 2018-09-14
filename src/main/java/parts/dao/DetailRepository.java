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

    @Override // insert into Detail
    <S extends Detail> S saveAndFlush(S s);

    // find min count where required=true
    @Query (value = "Select min(d.count) from (SELECT * FROM detail where required = true) d", nativeQuery = true)
    Integer findMinimum();


    // edit





}
