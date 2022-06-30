import axios from "axios";

//This is interceptors that used the handle the prerequest and preresponse validation
export function setupAxios(axios) {
    axios.interceptors.request.use(
        (config) => {
            return config;
        },
        (err) => Promise.reject(err)
    );

    axios.interceptors.response.use((response) => {
        return response.data;
    }, (error) => {
        return error.response.data;
    })
}


export const request = (options) => {

    const config = {
        headers: !options["contentType"] ? { "Content-Type": "application/json" } : { "Content-Type": options["contentType"] },
        url: options["url"],
        method: options["method"],
    };

    if (options["body"]) {
        config["data"] = options["body"];
    }
    if (options["params"]) {
        config["params"] = options["params"];
    }

    if (navigator.onLine) {
        return axios.request(config);
    }
}