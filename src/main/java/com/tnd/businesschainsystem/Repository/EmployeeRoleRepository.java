package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.EmployeeRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRoleRepository extends CrudRepository<EmployeeRole,Integer> {

    @Query(value="Select * from employee_role where employee = ?1", nativeQuery = true)
    List<EmployeeRole> findByEmployeeId(int employee);
}
