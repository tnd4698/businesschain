import { httpGet } from "../index";

const BASE_URL = '/api/admin';

export function getRoles() {
    return httpGet(BASE_URL + "/role");
}