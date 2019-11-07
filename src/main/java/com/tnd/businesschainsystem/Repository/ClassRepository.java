package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Classs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends CrudRepository<Classs,Integer> {

    @Query(value = "Select * from class where classID = ?1",nativeQuery = true)
    Classs findByClassID(String classID);
}
