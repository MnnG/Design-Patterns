package com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer.Varient2;

import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.IRequest;
import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.Variant2.CRequestVariant2;
import com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer.CAbstractResponsibilityBearer;
import com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer.IResponsibilityBearer;

public class CResponsibilityBearerVariant2 extends CAbstractResponsibilityBearer<CRequestVariant2> {

    public CResponsibilityBearerVariant2(int corePoolSize, int maxPoolSize, int queueSize, long keepAlive, IResponsibilityBearer<IRequest> nextResponsibilityBearer) {
        super(corePoolSize, maxPoolSize, queueSize, keepAlive,nextResponsibilityBearer);
    }

    public boolean isValidRequest(IRequest request) {
        return request instanceof CRequestVariant2;
    }
}
