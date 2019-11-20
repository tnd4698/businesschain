package com.tnd.businesschainsystem.Service;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Model.EmployeeDTO;
import com.tnd.businesschainsystem.Model.Timework;
import com.tnd.businesschainsystem.Model.TimeworkDTO;
import com.tnd.businesschainsystem.Model.TimeworkList;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface EmployeeManagementService {

    List<EmployeeDTO> getEmployees(String branch, String role, String status);

    EmployeeDTO getEmployee(String employeeID);

    ResponseDTO add(EmployeeDTO employee, String username);

    ResponseDTO update(EmployeeDTO employee, String employeeID, String username);

    List<TimeworkList> getTimeworkLists(String startDate, String endDate, String branch);

    List<TimeworkDTO> getNewTimeworks(String date, int branchId);

    ResponseDTO addTimeworks(List<Timework> timeworks);

    ResponseDTO updateTimeworks(List<Timework> timeworks);

    List<TimeworkDTO> getTimeworks(String date, String branch);
}
