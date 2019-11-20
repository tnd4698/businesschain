package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Material;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends CrudRepository<Material,Integer> {

    @Query(value = "Select * from material where materialID = ?1",nativeQuery = true)
    Material findByMaterialID(String resourceID);
}
