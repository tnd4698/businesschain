package com.tnd.businesschainsystem.Service;

import com.tnd.businesschainsystem.Bean.ResponseDTO;
import com.tnd.businesschainsystem.Model.Payroll;
import com.tnd.businesschainsystem.Model.PayrollDTO;
import com.tnd.businesschainsystem.Model.Spend;
import com.tnd.businesschainsystem.Model.StatisticsDTO;

import java.util.List;

public interface BudgetManagementService {

    ResponseDTO addSpend(Spend spend, String username);

    List<PayrollDTO> getPayrolls(int month, int year, String branch, String role);

    ResponseDTO addPayrolls(List<Payroll> payrolls, String username);

    List<StatisticsDTO> getReportSales(String fromDate, String toDate, String branch);

    List<StatisticsDTO> getReportTeaching(String fromDate, String toDate, String branch);

    List<StatisticsDTO> getReportSalary(int fromMonth, int fromYear, int toMonth, int toYear, String branch);

    List<StatisticsDTO> getReportProfit(int fromMonth, int fromYear, int toMonth, int toYear, String branch);
}
