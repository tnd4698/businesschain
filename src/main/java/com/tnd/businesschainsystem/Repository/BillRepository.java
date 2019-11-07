package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill,Integer> {
}
