package com.tnd.businesschainsystem.Service.Impl;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Message.Constants;
import com.tnd.businesschainsystem.Model.*;
import com.tnd.businesschainsystem.Model.DTO.PayrollDTO;
import com.tnd.businesschainsystem.Model.DTO.StatisticsDTO;
import com.tnd.businesschainsystem.Model.DTO.TimeworkDTO;
import com.tnd.businesschainsystem.Repository.*;
import com.tnd.businesschainsystem.Service.BudgetManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BudgetManagementServiceImpl implements BudgetManagementService {

    @Autowired
    private SpendRepository spendRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    private TimeworkRepository timeworkRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private TuitionRepository tuitionRepository;

    @Autowired
    private ShipwayRepository shipwayRepository;

    @Override
    public ResponseDTO addSpend(Spend spend, String username) {

        try {

            Account acc = accountRepository.findByUsername(username);
            spend.generateId();
            spend.setCreatedDate(new Date());
            spend.setCreatedBy(acc.getEmployee());
            spendRepository.save(spend);
            return new ResponseDTO().success(Constants.DONE_ADDSPEND);
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_ADDSPEND);
        }
    }

    @Override
    public List<PayrollDTO> getPayrolls(int month, int year, String branch, String role) {

        if(payrollRepository.findByMonthAndYear(month,year).size() > 0) {
            List<Payroll> payrolls = payrollRepository.findByMonthAndYear(month, year);
            payrolls = payrolls.stream()
                    .filter(payroll -> {
                        if (!branch.equals("null")) {
                            Employee employee = employeeRepository.findById(payroll.getEmployee()).get();
                            if (employee.getBranch() != Integer.parseInt(branch))
                                return false;
                        }
                        if (!role.equals("null")) {
                            List<EmployeeRole> employeeRoles = employeeRoleRepository.findByEmployeeId(payroll.getEmployee());
                            boolean rs = false;
                            for (int i = 0; i < employeeRoles.size(); i++)
                                if (employeeRoles.get(i).getRole() == Integer.parseInt(role))
                                    rs = true;
                            return rs;
                        }
                        return true;
                    })
                    .collect(Collectors.toList());
            List<PayrollDTO> list = new ArrayList<>();
            for(int i =0;i<payrolls.size();i++) {
                Employee employee = employeeRepository.findById(payrolls.get(i).getEmployee()).get();
                PayrollDTO payrollDTO = new PayrollDTO();
                payrollDTO.doMappingPayroll(payrolls.get(i),employee);
                list.add(payrollDTO);
            }

            return list;
        }
        else {
            List<Employee> employees = (List<Employee>) employeeRepository.findAll();
            List<Payroll> payrolls = employees.stream().map(employee -> {
                Payroll payroll = new Payroll();
                payroll.setMonth(month);
                payroll.setYear(year);
                payroll.setSalary(employee.getSalary());
                payroll.setEmployee(employee.getId());
                payroll.setCreatedDate(new Date());

                Calendar c = Calendar.getInstance();
                c.set(Calendar.YEAR,year);
                c.set(Calendar.MONTH,month);
                c.set(Calendar.DATE,1);
                int lastDate = c.getActualMaximum(Calendar.DATE);
                String startDate = String.format("%d/-02d-01",year,month);
                String endDate =String.format("%d-%02d-%d",year,month,lastDate);
                List<Timework> timeworks = timeworkRepository.findTimeworkByDuration(startDate,endDate);

                int countAbsent = 0;
                for(Timework timework : timeworks) {
                    if(timework.getStatus() == TimeworkDTO.ABSENT && timework.getEmployee() == employee.getId())
                        countAbsent++;
                }
                payroll.setAbsent(countAbsent);

                return payroll;
            }).collect(Collectors.toList());

            List<PayrollDTO> list = new ArrayList<>();
            for(int i =0;i<payrolls.size();i++) {
                Employee employee = employeeRepository.findById(payrolls.get(i).getEmployee()).get();
                PayrollDTO payrollDTO = new PayrollDTO();
                payrollDTO.doMappingPayroll(payrolls.get(i),employee);
                list.add(payrollDTO);
            }

            return list;
        }
    }

    @Override
    public ResponseDTO addPayrolls(List<Payroll> payrolls, String username) {

        try {
            if(payrollRepository.findByMonthAndYear(payrolls.get(0).getMonth(),payrolls.get(0).getYear()).size() == 0) {
                Account acc = accountRepository.findByUsername(username);
                payrolls.stream().forEach(payroll -> {
                    payroll.generateId();
                    payroll.setCreatedDate(new Date());
                    payroll.setCreatedBy(acc.getEmployee());
                });
                payrollRepository.saveAll(payrolls);
                return new ResponseDTO().success(Constants.DONE_ADDPAYROLL);
            }
            else {
                return new ResponseDTO().fail(Constants.FAIL_ADDPAYROLLEXIST);
            }
        } catch (Exception e) {
            return new ResponseDTO().fail(Constants.FAIL_ADDPAYROLL);
        }
    }

    @Override
    public List<StatisticsDTO> getReportSales(String fromDate, String toDate, String branch) {

        List<Branch> branches = (List<Branch>) branchRepository.findAll();
        List<StatisticsDTO> list = new ArrayList<>();
        for(Branch br : branches) {

            if(!branch.equals("null") && br.getId()!=Integer.parseInt(branch))
                continue;

            long value = 0;
            List<Bill> bills = billRepository.findByDurationAndBranch(fromDate, toDate, br.getId());
            for(int i=0;i<bills.size();i++)
                value += bills.get(i).getTotal();


            StatisticsDTO statisticsDTO = new StatisticsDTO();
            statisticsDTO.setBranchId(br.getId());
            statisticsDTO.setBranchName(br.getName());
            statisticsDTO.setFromDate(fromDate);
            statisticsDTO.setToDate(toDate);
            statisticsDTO.setValue(value);
            list.add(statisticsDTO);
        }
        return list;
    }

    @Override
    public List<StatisticsDTO> getReportTeaching(String fromDate, String toDate, String branch) {

        List<Branch> branches = (List<Branch>) branchRepository.findAll();
        List<StatisticsDTO> list = new ArrayList<>();
        for(Branch br : branches) {

            if(!branch.equals("null") && br.getId()!=Integer.parseInt(branch))
                continue;

            long value = 0;
            List<Tuition> tuitions = tuitionRepository.findByDurationAndBranch(fromDate, toDate, br.getId());
            for(int i=0;i<tuitions.size();i++)
                value += tuitions.get(i).getTotalMoney();


            StatisticsDTO statisticsDTO = new StatisticsDTO();
            statisticsDTO.setBranchId(br.getId());
            statisticsDTO.setBranchName(br.getName());
            statisticsDTO.setFromDate(fromDate);
            statisticsDTO.setToDate(toDate);
            statisticsDTO.setValue(value);
            list.add(statisticsDTO);
        }
        return list;
    }

    @Override
    public List<StatisticsDTO> getReportSalary(int fromMonth, int fromYear, int toMonth, int toYear, String branch) {

        List<Branch> branches = (List<Branch>) branchRepository.findAll();
        List<StatisticsDTO> list = new ArrayList<>();
        for(Branch br : branches) {

            if(!branch.equals("null") && br.getId()!=Integer.parseInt(branch))
                continue;

            long value = 0;
            List<Payroll> payrolls = payrollRepository.findByDuration(fromMonth,fromYear, toMonth, toYear);
            for(int i=0;i<payrolls.size();i++) {

                Employee employee = employeeRepository.findById(payrolls.get(i).getEmployee()).get();
                if(employee.getBranch() == br.getId())
                    value += payrolls.get(i).getTotalMoney();
            }

            StatisticsDTO statisticsDTO = new StatisticsDTO();

            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR,toYear);
            c.set(Calendar.MONTH,toMonth);
            c.set(Calendar.DATE,1);
            int lastDate = c.getActualMaximum(Calendar.DATE);
            statisticsDTO.setToDate(String.format("%d-%02d-%d",toYear,toMonth,lastDate));

            statisticsDTO.setBranchId(br.getId());
            statisticsDTO.setBranchName(br.getName());
            statisticsDTO.setFromDate(String.format("%d-%02d-01",fromYear,fromMonth));
            statisticsDTO.setValue(value);
            list.add(statisticsDTO);
        }
        return list;
    }

    @Override
    public List<StatisticsDTO> getReportProfit(int fromMonth, int fromYear, int toMonth, int toYear, String branch) {

        List<Branch> branches = (List<Branch>) branchRepository.findAll();
        List<StatisticsDTO> list = new ArrayList<>();
        for(Branch br : branches) {

            if(!branch.equals("null") && br.getId()!=Integer.parseInt(branch))
                continue;

            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR,toYear);
            c.set(Calendar.MONTH,toMonth);
            c.set(Calendar.DATE,1);
            int lastDate = c.getActualMaximum(Calendar.DATE);

            long value = 0;
            List<Payroll> payrolls = payrollRepository.findByDuration(fromMonth,fromYear, toMonth, toYear);
            for(int i=0;i<payrolls.size();i++) {
                Employee employee = employeeRepository.findById(payrolls.get(i).getEmployee()).get();
                if(employee.getBranch() == br.getId())
                    value -= payrolls.get(i).getTotalMoney();
            }

            List<Tuition> tuitions = tuitionRepository.findByDurationAndBranch(
                    String.format("%d-%02d-01",fromYear,fromMonth),
                    String.format("%d-%02d-%d",toYear,toMonth,lastDate),
                    br.getId());
            for(int i=0;i<tuitions.size();i++)
                value += tuitions.get(i).getTotalMoney();

            List<Bill> bills = billRepository.findByDurationAndBranch(
                    String.format("%d-%02d-01",fromYear,fromMonth),
                    String.format("%d-%02d-%d",toYear,toMonth,lastDate),
                    br.getId());
            for(int i=0;i<bills.size();i++)
                value += bills.get(i).getTotal();

            List<Spend> spends = spendRepository.findByDurationAndBranch(
                    String.format("%d-%02d-01",fromYear,fromMonth),
                    String.format("%d-%02d-%d",toYear,toMonth,lastDate),
                    br.getId());
            for(int i=0;i<spends.size();i++)
                value -= spends.get(i).getTotalMoney();

            List<Shipway> shipwayAdds = shipwayRepository.findByDurationAndToBranch(
                    String.format("%d-%02d-01",fromYear,fromMonth),
                    String.format("%d-%02d-%d",toYear,toMonth,lastDate),
                    br.getId());
            for(int i=0;i<shipwayAdds.size();i++)
                value -= shipwayAdds.get(i).getTotalMoney();

            List<Shipway> shipwayGets = shipwayRepository.findByDurationAndFromBranch(
                    String.format("%d-%02d-01",fromYear,fromMonth),
                    String.format("%d-%02d-%d",toYear,toMonth,lastDate),
                    br.getId());
            for(int i=0;i<shipwayGets.size();i++)
                value += shipwayGets.get(i).getTotalMoney();

            StatisticsDTO statisticsDTO = new StatisticsDTO();
            statisticsDTO.setToDate(String.format("%d-%02d-%d",toYear,toMonth,lastDate));
            statisticsDTO.setBranchId(br.getId());
            statisticsDTO.setBranchName(br.getName());
            statisticsDTO.setFromDate(String.format("%d-%02d-01",fromYear,fromMonth));
            statisticsDTO.setValue(value);
            list.add(statisticsDTO);
        }
        return list;
    }


}
