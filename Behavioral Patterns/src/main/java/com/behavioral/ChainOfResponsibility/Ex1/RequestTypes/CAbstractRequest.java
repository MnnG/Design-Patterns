package com.behavioral.ChainOfResponsibility.Ex1.RequestTypes;

/**
 * The Abstract class for 3 steps request execution classes
 *
 * 3 steps would be -
 * 1 = Complete steps before actually executing the request
 * 2 = Execute the request
 * 3 = Complete steps after request is executed
 *
 * Todo - we can also add request time tracking here as well
 */
public abstract class CAbstractRequest implements IRequest {

    private String requestStatus;

    public CAbstractRequest() {
        this.requestStatus = "Created";
    }

    public final void execute() {

        setRequestStatus("Started");
        //
        // Complete steps before executing the request
        //
        preRequestExecuted();

        setRequestStatus("In Progress");
        //
        // Complete the steps to actually execute the request
        //
        executeRequest();

        setRequestStatus("Completed");
        //
        // Complete the steps post request is actually executed
        //
        postRequestExecuted();
    }

    public abstract void preRequestExecuted();

    public abstract void executeRequest();

    public abstract void postRequestExecuted();

    private void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}
