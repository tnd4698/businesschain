package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Shift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends CrudRepository<Shift,Integer> {
}
