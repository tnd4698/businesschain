package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Branch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends CrudRepository<Branch,Integer> {
}
