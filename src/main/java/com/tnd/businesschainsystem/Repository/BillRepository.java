package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill,Integer> {

    @Query(value = "Select * from bill where ( createdDate between ?1 and ?2 ) and branch = ?3",nativeQuery = true)
    List<Bill> findByDurationAndBranch(String fromDate, String toDate, int branchId);

    @Query(value = "Select * from bill where createdDate between ?1 and ?2",nativeQuery = true)
    List<Bill> findByDuration(String fromDate, String toDate);
}
