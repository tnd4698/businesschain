import { httpPost } from "../index";

const BASE_URL = '/api/bill';

export function addBill(listBill) {
    return httpPost(BASE_URL, listBill);
}