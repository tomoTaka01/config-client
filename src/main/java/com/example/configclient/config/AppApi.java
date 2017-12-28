package com.example.configclient.config;

import javax.validation.constraints.Max;

//@Configuration
//@ConfigurationProperties("app-api")
//@Validated
public class AppApi {
    @Max(5)
    private int retryCount;
    private String apiName;

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }
}
