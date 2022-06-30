import { request } from "../setupAxios";

const S_ENDPOINT = process.env.REACT_APP_S_ENDPOINT;



export function getAppSupervisors() {
    return request({
        url: S_ENDPOINT + "supervisors",
        method: "GET"
    })
}



export function sentNotification(data) {
    return request({
        url: S_ENDPOINT + "submit",
        method: "POSt",
        body: data
    })
}
