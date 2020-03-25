package com.example.springboottest.util;

public class HttpResult {
    private ResultStatus resultStatus;
    private String jsonData;
    enum ResultStatus{
        SUCCESS,ERROR;
    }

    private HttpResult( ResultStatus resultStatus,String jsonData){
        this.resultStatus = resultStatus;
        this.jsonData = jsonData;
    }


    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public static HttpResult getSuccess (String jsonData){
        return new HttpResult(ResultStatus.SUCCESS,jsonData);
    }

    public static HttpResult getError(String jsonData){
        return new HttpResult(ResultStatus.ERROR,jsonData);
    }
}

