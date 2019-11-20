package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Shipway;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipwayRepository extends CrudRepository<Shipway,Integer> {

    @Query(value = "Select * from shipway where ( createdDate between ?1 and ?2 ) and toBranch = ?3", nativeQuery = true)
    List<Shipway> findByDurationAndToBranch(String fromDate, String toDate, int toBranch);

    @Query(value = "Select * from shipway where ( createdDate between ?1 and ?2 ) and fromBranch = ?3", nativeQuery = true)
    List<Shipway> findByDurationAndFromBranch(String format, String format1, int fromBranch);
}
