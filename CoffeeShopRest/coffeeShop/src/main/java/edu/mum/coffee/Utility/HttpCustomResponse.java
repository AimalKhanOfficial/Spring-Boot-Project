package edu.mum.coffee.Utility;

import org.springframework.stereotype.Component;

@Component
public class HttpCustomResponse {
    private String responseDescription;
    private int responseCode;

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
