package com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer.Varient1;

import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.IRequest;
import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.Varient1.CRequestVariant1;
import com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer.CAbstractResponsibilityBearer;
import com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer.IResponsibilityBearer;

public class CResponsibilityBearerVariant1 extends CAbstractResponsibilityBearer<CRequestVariant1> {

    public CResponsibilityBearerVariant1(int corePoolSize, int maxPoolSize, int queueSize, long keepAlive, IResponsibilityBearer<IRequest> nextResponsibilityBearer) {
        super(corePoolSize, maxPoolSize, queueSize, keepAlive,nextResponsibilityBearer);
    }

    public boolean isValidRequest(IRequest request) {
        return request instanceof CRequestVariant1;
    }
}
