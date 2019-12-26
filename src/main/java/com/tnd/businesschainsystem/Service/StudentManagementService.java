package com.tnd.businesschainsystem.Service;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Model.StudentDTO;

import java.util.List;

public interface StudentManagementService {

    List<StudentDTO> getStudents(String branch, String tuition, String status);

    ResponseDTO add(String username,StudentDTO studentDTO);

    ResponseDTO update(String studentID, StudentDTO studentDTO);
}
