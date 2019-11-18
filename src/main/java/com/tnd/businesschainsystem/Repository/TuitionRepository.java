package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Tuition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TuitionRepository extends CrudRepository<Tuition,Integer> {

    @Query(value = "Select * from tuition where (createdDate between ?1 and ?2) and branch = ?3",nativeQuery = true)
    List<Tuition> findByDurationAndBranch(String fromDate, String toDate, int branchId);
}
