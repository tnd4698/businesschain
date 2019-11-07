package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Timework;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeworkRepository extends CrudRepository<Timework,Integer> {

    @Query(value = "Select * from timework where date between ?1 and ?2 group by date order by date ASC", nativeQuery = true)
    List<Timework> findTimeworkList(String startDate, String endDate);
}
