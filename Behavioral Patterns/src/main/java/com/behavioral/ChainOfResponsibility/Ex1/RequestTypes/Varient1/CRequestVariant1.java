package com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.Varient1;

import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.CAbstractRequest;

public class CRequestVariant1 extends CAbstractRequest {

    private final int timeToCompleteRequest;

    public CRequestVariant1(int time) {
        super();
        this.timeToCompleteRequest = time;
    }

    public void preRequestExecuted() {
        System.out.println("Request variant1 - Pre request executed");
    }

    public void executeRequest() {
        System.out.println("Request variant1 - Executing request");
        try {
            Thread.sleep(timeToCompleteRequest);
        } catch (InterruptedException e) {
            // do nothing
        }
    }

    public void postRequestExecuted() {
        System.out.println("Request Variant1 - Post request executed");
    }
}
