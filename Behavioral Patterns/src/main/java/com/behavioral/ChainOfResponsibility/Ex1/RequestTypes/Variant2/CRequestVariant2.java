package com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.Variant2;

import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.CAbstractRequest;

/**
 * The request variant type 2 class
 */
public class CRequestVariant2 extends CAbstractRequest {

    private final int timeToCompleteRequest;

    public CRequestVariant2(int time) {
        super();
        this.timeToCompleteRequest = time;
    }

    public void preRequestExecuted() {
        System.out.println("Request variant2 - Pre request executed");
    }

    public void executeRequest() {
        System.out.println("Request variant2 - Executing request");
        try {
            Thread.sleep(timeToCompleteRequest);
        } catch (InterruptedException e) {
            // do nothing
        }
    }

    public void postRequestExecuted() {
        System.out.println("Request Variant2 - Post request executed");
    }
}
