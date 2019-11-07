package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    @Query(value = "Select * from employee where employeeID = ?1",nativeQuery = true)
    Employee findByEmployeeID(String employeeID);

    @Query(value = "Select * from employee where branch = ?1", nativeQuery = true)
    List<Employee> findByBranchId(int branchId);

}
