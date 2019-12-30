import { httpGet, httpPost, httpPut } from "../index";

const BASE_URL = '/api/branch';

export function getMenuItems(branchId) {
    return httpGet(BASE_URL + `/${branchId}/menu-items`);
}

export function getBranches(status = '1') {
    return httpGet(BASE_URL+`?status=${status}`);
}

export function getBranch(branchId) {
    return httpGet(BASE_URL + `/${branchId}`);
}

export function addBranch(branchDTO) {
    return httpPost(BASE_URL, branchDTO);
}

export function updateBranch(branchId, branchDTO) {
    return httpPut(BASE_URL + `/${branchId}`, branchDTO);
}