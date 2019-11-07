package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.MaterialBranch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialBranchRepository extends CrudRepository<MaterialBranch,Integer> {

    @Query(value = "Select * from material_branch where material = ?1",nativeQuery = true)
    List<MaterialBranch> findByMaterialId(int materialId);

    @Query(value = "Select * from material_branch where material = ?1 and branch = ?2", nativeQuery = true)
    MaterialBranch findByMaterialIdAndBranchId(int id, int branchId);
}
