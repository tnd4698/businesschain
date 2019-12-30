import { httpGet, httpPost, httpPut } from "../index";

const BASE_URL = '/api/employee';

export function getEmployees(branch = 'null', role = 'null', status = '1') {
    return httpGet(BASE_URL + `?branch=${branch}&role=${role}&status=${status}`);
}

export function getEmployee(employeeID) {
    return httpGet(BASE_URL + `/${employeeID}`);
}

export function addEmployee(employeeDTO) {
    return httpPost(BASE_URL, employeeDTO);
}

export function updateEmployee(employeeID, employeeDTO) {
    return httpPut(BASE_URL + `/${employeeID}`, employeeDTO);
}

export function getTimeworks(date = 'null',branch='null') {
    return httpGet(BASE_URL + `/timeworks?date=${date}&branch=${branch}`);
}

export function getTimeworkLists(startDate,endDate,branch) {
    return httpGet(BASE_URL + `/timeworks/list?startDate=${startDate}&endDate=${endDate}&branch=${branch}`);
}

export function getNewTimeworks(date,branch) {
    return httpGet(BASE_URL + `/timeworks/new?date=${date}&branch=${branch}`);
}

export function addTimeworks(timeworks) {
    return httpPost(BASE_URL + "/timeworks",timeworks);
}

export function updateTimeworks(timeworks) {
    return httpPut(BASE_URL + "/timeworks",timeworks);
}