package com.tnd.businesschainsystem.Service;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Model.ClassDTO;
import com.tnd.businesschainsystem.Model.Shift;

import java.util.List;

public interface ClassManagementService {

    List<ClassDTO> getClasses(String branch, String status);

    ResponseDTO addClass(ClassDTO classDTO);

    ResponseDTO updateClass(String classID, ClassDTO classDTO);

    List<Shift> getShifts();
}