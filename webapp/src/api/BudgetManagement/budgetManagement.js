import { httpGet, httpPost, httpPut } from "../index";

const BASE_URL = '/api/budget';

export function addSpend(spend) {
    return httpPost(BASE_URL + "/spend", spend);
}

export function getPayrolls(month = 12, year = 2019, branch = 'null', role = 'null') {
    return httpGet(BASE_URL + `/payroll?month=${month}&year=${year}&branch=${branch}&role=${role}`);
}

export function addPayrolls(payrolls) {
    return httpPost(BASE_URL + "/payroll", payrolls);
}

export function getReportSales(fromDate = '2019/11/01', toDate = '2019/11/30', branch = 'null') {
    return httpGet(BASE_URL + `/report/sales?fromDate=${fromDate}&toDate=${toDate}&branch=${branch}`);
}

export function getReportTeaching(fromDate = '2019/11/01', toDate = '2019/11/30', branch = 'null') {
    return httpGet(BASE_URL + `/report/teaching?fromDate=${fromDate}&toDate=${toDate}&branch=${branch}`);
}

export function getReportSalary(fromMonth = 11, fromYear = 2019, toMonth = 12, toYear = 2019, branch = 'null') {
    return httpGet(BASE_URL + `/report/salary?fromMonth=${fromMonth}&fromYear=${fromYear}&toMonth=${toMonth}&toYear=${toYear}&branch=${branch}`);
}

export function getReportProfit(fromMonth = 11, fromYear = 2019, toMonth = 12, toYear = 2019, branch = 'null') {
    return httpGet(BASE_URL + `/report/profit?fromMonth=${fromMonth}&fromYear=${fromYear}&toMonth=${toMonth}&toYear=${toYear}&branch=${branch}`);
}