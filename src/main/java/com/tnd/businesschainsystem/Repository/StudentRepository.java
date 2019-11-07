package com.tnd.businesschainsystem.Repository;

import com.tnd.businesschainsystem.Model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

    @Query(value = "Select * from student where studentID = ?1", nativeQuery = true)
    Student findByStudentID(String studentID);
}
