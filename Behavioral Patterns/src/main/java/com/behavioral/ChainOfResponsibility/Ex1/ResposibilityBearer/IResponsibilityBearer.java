package com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer;

import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.IRequest;

/**
 * Contract of the responsibility bearer
 */
public interface IResponsibilityBearer<I extends IRequest> {

    /**
     * Perform the responsibility
     */
    void performResponsibility(I request);
}
