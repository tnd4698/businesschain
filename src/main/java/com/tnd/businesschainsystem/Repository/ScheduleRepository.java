package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule,Integer> {

    @Query(value = "Select * from schedule where class = ?1",nativeQuery = true)
    List<Schedule> findByClassId(int classId);
}
