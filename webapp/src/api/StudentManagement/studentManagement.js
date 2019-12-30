import { httpGet, httpPost, httpPut } from "../index";

const BASE_URL = '/api/student';

export function getStudents(branch = 'null', tuition = 'null', status = '1') {
    return httpGet(BASE_URL + `?branch=${branch}&tuition=${tuition}&status=${status}`);
}

export function addStudent(studentDTO) {
    return httpPost(BASE_URL, studentDTO);
}

export function updateStudent(studentID,studentDTO) {
    return httpPut(BASE_URL+`/${studentID}`, studentDTO);
}
