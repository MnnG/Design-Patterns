package com.behavioral.ChainOfResponsibility.Ex1;

import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.IRequest;
import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.Variant2.CRequestVariant2;
import com.behavioral.ChainOfResponsibility.Ex1.RequestTypes.Varient1.CRequestVariant1;
import com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer.CGenericResponsibilityBearer;
import com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer.Varient1.CResponsibilityBearerVariant1;
import com.behavioral.ChainOfResponsibility.Ex1.ResposibilityBearer.Varient2.CResponsibilityBearerVariant2;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {

        //
        // Request bearer for all types of requests
        //
        CGenericResponsibilityBearer genericVariant = new CGenericResponsibilityBearer(1, 1, 10, 1000, null);

        //
        // Request bearer for request type 1
        //
        CResponsibilityBearerVariant1 bearerVariant1 = new CResponsibilityBearerVariant1(1, 1, 10, 1000, genericVariant);

        //
        // Request bearer for request type 2
        //
        CResponsibilityBearerVariant2 bearerVariant2 = new CResponsibilityBearerVariant2(1, 1, 10, 1000, bearerVariant1);

        Runnable runnable = () -> {
            double number = Math.random();
            int remainder = (int) (number % 4);
            IRequest request;
            if(number % 2 == 0) {
                request = new CRequestVariant2(remainder);
            } else {
                request = new CRequestVariant1(remainder);
            }
            bearerVariant2.performResponsibility(request);
        };

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(runnable, 0, 1000, TimeUnit.MILLISECONDS);
    }
}
