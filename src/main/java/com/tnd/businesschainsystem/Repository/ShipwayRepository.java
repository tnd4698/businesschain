package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Shipway;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipwayRepository extends CrudRepository<Shipway,Integer> {
}
