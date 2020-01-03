package com.tnd.businesschainsystem.Service;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Model.DTO.EmployeeDTO;
import com.tnd.businesschainsystem.Model.DTO.TimeworkDTO;
import com.tnd.businesschainsystem.Model.TimeworkList;

import java.util.List;

public interface EmployeeManagementService {

    List<EmployeeDTO> getEmployees(String branch, String role, String status);

    EmployeeDTO getEmployee(String employeeID);

    ResponseDTO add(EmployeeDTO employee, String username);

    ResponseDTO update(EmployeeDTO employee, String employeeID, String username);

    List<TimeworkList> getTimeworkLists(String startDate, String endDate, String branch);

    List<TimeworkDTO> getNewTimeworks(String date, int branchId);

    ResponseDTO addTimeworks(List<TimeworkDTO> timeworks);

    ResponseDTO updateTimeworks(List<TimeworkDTO> timeworks);

    List<TimeworkDTO> getTimeworks(String date, String branch);
}
