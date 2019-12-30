import { httpGet } from "../index";

const BASE_URL = '/api/auth';

export function getRole() {
    return httpGet(BASE_URL + "/role");
}

export function getUser() {
    return httpGet(BASE_URL + "/user");
}
