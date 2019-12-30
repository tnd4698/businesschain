package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Payroll;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayrollRepository extends CrudRepository<Payroll,Integer> {

    @Query(value = "Select * from payroll where month = ?1 and year = ?2", nativeQuery = true)
    List<Payroll> findByMonthAndYear(int month, int year);

    @Query(value = "Select * from payroll where ((month between ?1 and ?3) or (month between ?3 and ?1)) and (year between ?2 and ?4)", nativeQuery = true)
    List<Payroll> findByDuration(int fromMonth, int fromYear, int toMonth, int toYear);
}
