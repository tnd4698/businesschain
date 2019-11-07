package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Import;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportRepository extends CrudRepository<Import,Integer> {
}
