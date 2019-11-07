package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Tuition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuitionRepository extends CrudRepository<Tuition,Integer> {
}
