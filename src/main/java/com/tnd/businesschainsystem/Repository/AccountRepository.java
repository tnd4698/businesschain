package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    @Query(value="Select * from account where username = ?1", nativeQuery = true)
    Account findByUsername(String username);

    @Query(value = "Select * from account where employee = ?1", nativeQuery = true)
    Account findByEmployeeId(int employeeId);
}
