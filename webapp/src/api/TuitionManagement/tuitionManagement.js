import { httpPost } from "../index";

const BASE_URL = '/api/tuition';

export function addTuition(tuitionDTO) {
    return httpPost(BASE_URL, tuitionDTO);
}
