package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Message.Constants;
import com.tnd.businesschainsystem.Model.*;
import com.tnd.businesschainsystem.Repository.*;
import com.tnd.businesschainsystem.Service.StudentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentManagementServiceImpl implements StudentManagementService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private StudentClassRepository studentClassRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<StudentDTO> getStudents(String branch, String tuition, String status) {

        List<StudentDTO> list = new ArrayList<>();
        List<Student> students = (List<Student>) studentRepository.findAll();
        for(Student student : students) {

            if(!status.equals("null") && student.getStatus()!=Integer.parseInt(status))
                continue;

            Branch br = branchRepository.findById(student.getBranch()).get();
            if (!branch.equals("null") && br.getId() != Integer.parseInt(branch))
                continue;

            StudentClass studentClass = studentClassRepository.findByStudentId(student.getId());
            if(studentClass != null) {

                if (!tuition.equals("null") && studentClass.getStatusTuition() != Integer.parseInt(tuition))
                    continue;
                Classs classs = classRepository.findById(studentClass.getClasss()).get();
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.doMappingStudent(student, studentClass, classs, br);
                list.add(studentDTO);
            }
            else {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.doMappingStudent(student, null, null, br);
                studentDTO.setStatusTuition(-1);
                list.add(studentDTO);
            }
        }
        return list;
    }

    @Override
    public ResponseDTO add(String username, StudentDTO studentDTO) {

        try {
            Account acc = accountRepository.findByUsername(username);
            studentDTO.setBranchId(employeeRepository.findById(acc.getEmployee()).get().getBranch());
            Student student = new Student();
            student.generateID(((List<Student>)studentRepository.findAll()).size() + 1);
            student.doMappingStudentDTO(studentDTO);
            student.setStatus(0);
            studentRepository.save(student);

            return new ResponseDTO().success(Constants.DONE_ADDSTUDENT);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_ADDSTUDENT);
        }
    }

    @Override
    public ResponseDTO update(String studentID, StudentDTO studentDTO) {

        try{

            Student student = studentRepository.findByStudentID(studentID);
            student.doMappingStudentDTO(studentDTO);
            studentRepository.save(student);

            return new ResponseDTO().success(Constants.DONE_UPDATESTUDENT);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_UPDATESTUDENT);
        }
    }
}
