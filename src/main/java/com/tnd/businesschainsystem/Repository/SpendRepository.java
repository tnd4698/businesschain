package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Spend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpendRepository extends CrudRepository<Spend,Integer> {
}
