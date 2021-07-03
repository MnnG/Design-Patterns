package com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer;

import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.IRequest;

public class CGenericResponsibilityBearer extends CAbstractResponsibilityBearer<IRequest> {

    public CGenericResponsibilityBearer(int corePoolSize, int maxPoolSize, int queueSize, long keepAlive, IResponsibilityBearer<IRequest> nextResponsibilityBearer) {
        super(corePoolSize, maxPoolSize, queueSize, keepAlive,nextResponsibilityBearer);
    }

    public boolean isValidRequest(IRequest request) {
        return true;
    }
}
