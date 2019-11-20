package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Equipment;
import com.tnd.businesschainsystem.Model.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment,Integer> {

    @Query(value = "Select * from equipment where equipmentID = ?1", nativeQuery = true)
    Equipment findByEquipmentID(String resourceID);
}
