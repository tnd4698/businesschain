import { httpGet, httpPost, httpPut } from "../index";

const BASE_URL = '/api/class';

export function getClasses(branch = 'null', status = '1') {
    return httpGet(BASE_URL + `?branch=${branch}&status=${status}`);
}

export function addClass(classDTO) {
    return httpPost(BASE_URL, classDTO);
}

export function updateClass(classID, classDTO) {
    return httpPut(BASE_URL + `/${classID}`, classDTO);
}

export function getShifts() {
    return httpGet(BASE_URL + '/shifts');
}
