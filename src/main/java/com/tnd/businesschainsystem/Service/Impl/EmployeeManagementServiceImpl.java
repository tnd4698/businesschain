package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Message.Constants;
import com.tnd.businesschainsystem.Model.*;
import com.tnd.businesschainsystem.Repository.*;
import com.tnd.businesschainsystem.Service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TimeworkRepository timeworkRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<EmployeeDTO> getEmployees(String branch, String role, String status) {

        List<EmployeeDTO> list = new ArrayList<>();

        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        for(int i=0;i<employees.size();i++) {

            if(!status.equals("null"))
                if(employees.get(i).getStatus()!= Integer.parseInt(status))
                    continue;

            Branch t_branch = branchRepository.findById(employees.get(i).getBranch()).get();
            if(!branch.equals("null"))
                if(t_branch.getId()!=Integer.parseInt(branch))
                    continue;

            List<EmployeeRole> employeeRoles = employeeRoleRepository.findByEmployeeId(employees.get(i).getId());
            Role t_role = null;
            if(employeeRoles.size()>0){

                t_role = roleRepository.findById(employeeRoles.get(0).getRole()).get();

                if(!role.equals("null"))
                    if(!t_role.getRole().equals(role))
                        continue;
            }

            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.doMappingEmployee(employees.get(i), t_role, t_branch);
            list.add(employeeDTO);
        }
        return list;
    }

    @Override
    public EmployeeDTO getEmployee(String employeeID) {

        Employee employee = employeeRepository.findByEmployeeID(employeeID);

        if(employee == null)
            return null;
        Branch branch = branchRepository.findById(employee.getBranch()).get();
        Role role = null;
        List<EmployeeRole> employeeRoles = employeeRoleRepository.findByEmployeeId(employee.getId());
        if(employeeRoles.size()>0){
            role = roleRepository.findById(employeeRoles.get(0).getRole()).get();
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.doMappingEmployee(employee, role, branch);

        return employeeDTO;
    }



    @Override
    public ResponseDTO add(EmployeeDTO employee, String username) {

        try {
            Account acc = accountRepository.findByUsername(username);
            employee.setCreatedBy(acc.getEmployee());
            employee.setCreatedDate(new Date());
            Employee empl = new Employee();
            empl.generateID(((List<Employee>)employeeRepository.findAll()).size() + 1);
            empl.doMappingEmployeeDTO(employee);
            employeeRepository.save(empl);

            EmployeeRole employeeRole = new EmployeeRole();
            employeeRole.setEmployee(empl.getId());
            employeeRole.setRole(employee.getRoleId());
            employeeRoleRepository.save(employeeRole);

            Role role = roleRepository.findById(employeeRole.getRole()).get();
            if(!role.getRole().equals("STAFF") && !role.getRole().equals("TEACHER")) {
                Account account = new Account();
                account.setEmployee(empl.getId());
                account.setUsername(empl.getEmployeeID());
                account.setPassword(passwordEncoder.encode("12345678"));
                account.setStatus(1);
                accountRepository.save(account);
            }
            return new ResponseDTO().success(Constants.DONE_ADDEMPLOYEE);
        }
        catch(Exception e) {
            return new ResponseDTO().success(Constants.FAIL_ADDEMPLOYEE);
        }
    }

    @Override
    public ResponseDTO update(EmployeeDTO employee, String employeeID, String username) {

        try{

            Account acc = accountRepository.findByUsername(username);
            Employee empl = employeeRepository.findByEmployeeID(employeeID);
            employee.setUpdatedBy(acc.getEmployee());
            employee.setUpdatedDate(new Date());
            empl.doMappingEmployeeDTO(employee);
            employeeRepository.save(empl);

            EmployeeRole employeeRole = employeeRoleRepository.findByEmployeeId(empl.getId()).get(0);
            employeeRole.setEmployee(empl.getId());
            employeeRole.setRole(employee.getRoleId());
            employeeRoleRepository.save(employeeRole);


            Account account = accountRepository.findByEmployeeId(empl.getId());
            Role role = roleRepository.findById(employeeRole.getRole()).get();
            if(!role.getRole().equals("STAFF") && empl.getStatus()==1){
                if(account != null)
                    account.setStatus(1);
                else {
                    account = new Account();
                    account.setEmployee(empl.getId());
                    account.setUsername(empl.getEmployeeID());
                    account.setPassword(passwordEncoder.encode("12345678"));
                    account.setStatus(1);
                }
            }
            else {
                if(account != null)
                    account.setStatus(0);
            }
            if(account!=null)
            accountRepository.save(account);

            return new ResponseDTO().success(Constants.DONE_UPDATEEMPLOYEE);
        }catch (Exception e) {
            return new ResponseDTO().success(Constants.FAIL_UPDATEEMPLOYEE);
        }
    }

    @Override
    public List<TimeworkList> getTimeworkLists(String startDate, String endDate, String branch) {

        List<TimeworkList> list = new ArrayList<>();

        List<Timework> timeworks = timeworkRepository.findTimeworkList(startDate,endDate);
        for(int i=0;i<timeworks.size();i++) {

            Employee employee = employeeRepository.findById(timeworks.get(i).getEmployee()).get();
            Branch br = branchRepository.findById(employee.getBranch()).get();
            if(!branch.equals("null") && br.getId()!=Integer.parseInt(branch))
                continue;
            TimeworkList timeworkList = new TimeworkList();
            timeworkList.setDate(timeworks.get(i).getDate());
            timeworkList.setBranchId(br.getId());
            timeworkList.setBranchName(br.getName());
            list.add(timeworkList);
        }
        return list;
    }

    @Override
    public List<TimeworkDTO> getNewTimeworks(String date, int branchId) {

        List<TimeworkDTO> list = new ArrayList<>();
        List<Timework> timeworks = timeworkRepository.findTimeworkByDuration(date,date);


        List<Employee> employees = employeeRepository.findByBranchId(branchId);
        for(Employee employee : employees) {

            TimeworkDTO timeworkDTO = new TimeworkDTO();
            timeworkDTO.setDate(date);
            timeworkDTO.setEmployeeName(employee.getName());
            timeworkDTO.setStatus(1);
            timeworkDTO.setEmployeeID(employee.getEmployeeID());
            timeworkDTO.setEmployeeId(employee.getId());
            timeworkDTO.setBranchId(branchId);
            list.add(timeworkDTO);
        }
        return list;
    }

    @Override
    public ResponseDTO addTimeworks(List<TimeworkDTO> timeworks) {

        try{

            for(TimeworkDTO timework : timeworks) {
                Timework t = new Timework();
                t.doMappingTimeworkDTO(timework);
                timeworkRepository.save(t);
            }
            return new ResponseDTO().success(Constants.DONE_ADDTIMEWORK);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_ADDTIMEWORK);
        }
    }

    @Override
    public ResponseDTO updateTimeworks(List<TimeworkDTO> timeworks) {

        try{
            List<Timework> list = new ArrayList<>();
            for(TimeworkDTO timework : timeworks) {
                if (!timeworkRepository.existsById(timework.getId()))
                    return new ResponseDTO().fail(Constants.FAIL_UPDATETIMEWORK);
                Timework t = new Timework();
                t.doMappingTimeworkDTO(timework);
                list.add(t);
            }
            timeworkRepository.saveAll(list);
            return new ResponseDTO().success(Constants.DONE_UPDATETIMEWORK);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_UPDATETIMEWORK);
        }
    }

    @Override
    public List<TimeworkDTO> getTimeworks(String date, String branch) {

        List<TimeworkDTO> list = new ArrayList<>();
        List<Timework> timeworks;
        if(!date.equals("null"))
            timeworks = timeworkRepository.findTimeworkByDuration(date,date);
        else
            timeworks = (List<Timework>) timeworkRepository.findAll();
        for(int i = 0;i<timeworks.size();i++) {
            Employee employee = employeeRepository.findById(timeworks.get(i).getEmployee()).get();
            if(!branch.equals("null") && employee.getBranch() != Integer.parseInt(branch))
                continue;
            TimeworkDTO timeworkDTO = new TimeworkDTO();
            timeworkDTO.doMappingTimework(timeworks.get(i),employee);
            list.add(timeworkDTO);
        }

        return list;
    }


}
