package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Spend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpendRepository extends CrudRepository<Spend,Integer> {

    @Query(value = "Select * from spend where (createdDate between ?1 and ?2) and branch = ?3",nativeQuery = true)
    List<Spend> findByDurationAndBranch(String fromDate, String toDate, int branchId);
}
