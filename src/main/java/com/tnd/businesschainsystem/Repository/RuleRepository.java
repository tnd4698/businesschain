package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Rule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuleRepository extends CrudRepository<Rule,Integer> {

    @Query(value="Select * from rule where branch = ?1 and type = ?2", nativeQuery = true)
    List<Rule> findByBranchIdAndType(int branchId, int type);

    @Query(value = "Select * from rule where branch = ?1", nativeQuery = true)
    List<Rule> findByBranchId(int branchId);
}
