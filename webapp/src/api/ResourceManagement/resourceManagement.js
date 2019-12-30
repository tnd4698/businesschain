import { httpGet, httpPost, httpPut } from "../index";

const BASE_URL = '/api/resource';

export function getResources(branch = 'null', type = 'null', status = '1') {
    return httpGet(BASE_URL + `?branch=${branch}&type=${type}&status=${status}`);
}

export function addResource(resourceDTO) {
    return httpPost(BASE_URL, resourceDTO);
}

export function updateResource(resourceID,resourceDTO) {
    return httpPut(BASE_URL+`/${resourceID}`, resourceDTO);
}

export function addShipways(shipways) {
    return httpPost(BASE_URL+"/shipway", shipways);
}

export function addImport(imports) {
    return httpPost(BASE_URL+"/import", imports);
}