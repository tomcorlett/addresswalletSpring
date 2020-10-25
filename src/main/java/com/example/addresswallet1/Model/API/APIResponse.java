package com.example.addresswallet1.Model.API;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;

public class APIResponse {
    private HttpStatus httpStatus;
    private String errorDescription;

    public APIResponse() {}

    public APIResponse(HttpStatus httpStatus, String errorDescription) {
        this.httpStatus = httpStatus;
        this.errorDescription = errorDescription;
    }

    public HttpStatus getHttpResponseCode() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    //TODO: return jsonobject.toString - use simple json.
    public String getErrorDescriptionAsJson() {
        return "";
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
