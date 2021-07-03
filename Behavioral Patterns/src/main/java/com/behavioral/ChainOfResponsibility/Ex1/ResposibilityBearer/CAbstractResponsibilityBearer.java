package com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer;

import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.IRequest;
import com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer.Varient1.CResponsibilityBearerVariant1;
import com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer.Varient2.CResponsibilityBearerVariant2;

import java.util.Optional;
import java.util.concurrent.*;

public abstract class CAbstractResponsibilityBearer<T extends IRequest> implements IResponsibilityBearer<IRequest> {

    private final BlockingQueue<Runnable> taskQueue;
    private final long queueSize;
    private final ExecutorService executor;
    private final Optional<IResponsibilityBearer> nextResponsibilityBearer;

    public CAbstractResponsibilityBearer(int corePoolSize, int maxPoolSize, int queueSize, long keepAlive, IResponsibilityBearer<IRequest> nextResponsibilityBearer)
    {
        this.queueSize = queueSize;
        this.nextResponsibilityBearer = Optional.ofNullable(nextResponsibilityBearer);
        taskQueue = new LinkedBlockingQueue<>(queueSize);
        executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAlive, TimeUnit.MILLISECONDS, taskQueue);
    }

    public final void performResponsibility(IRequest request) {
        if(!isValidRequest(request) || isQueueFull())
        {
            passRequestToNextBearer(request);
        }
        executor.execute(() -> {
            request.execute();
        });
    }

    public void submitTask(Runnable runnable) {
    }

    public boolean isQueueFull() {
        return queueSize < 0 || taskQueue.size() == queueSize;
    }

    private void passRequestToNextBearer(IRequest request)
    {
        nextResponsibilityBearer.ifPresent(a -> {

            if(a instanceof CResponsibilityBearerVariant2) {
                System.out.println("Sending the task to Responsibility Bearer Variant 2");
            } else if(a instanceof CResponsibilityBearerVariant1) {
                System.out.println("Sending the task to Responsibility Bearer Variant 1");
            } else {
                System.out.println("Sending the task to Generic Responsibility Bearer");
            }
            a.performResponsibility(request);
        });
    }

    public abstract boolean isValidRequest(IRequest request);
}
