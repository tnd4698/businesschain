package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.StudentClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentClassRepository extends CrudRepository<StudentClass,Integer> {

    @Query(value = "Select * from student_class where student = ?1 and status = 1", nativeQuery = true)
    StudentClass findByStudentId(int studentId);

    @Query(value = "Select * from student_class where class = ?1 and status = 1" , nativeQuery = true)
    List<StudentClass> findByClassId(int classId);
}
