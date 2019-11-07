package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
}
