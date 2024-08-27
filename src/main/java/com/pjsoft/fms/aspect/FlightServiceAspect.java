package com.pjsoft.fms.aspect;

import com.pjsoft.fms.model.Flight;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class FlightServiceAspect {

    //    Before Advice: An advice that executes before a join point, is called before advice.
    //    We use @Before annotation to mark an advice as Before advice.
    @Before(value = "execution(* com.pjsoft.fms.service.FlightService.*(..)) and args(flight)")
    public void beforeAdvice(JoinPoint joinPoint, Flight flight) {
        System.out.println("Before method: Going to hit save method with flight carrier name: "+ flight.getCarrierName());
    }

    @Before(value = "execution(* com.pjsoft.fms.service.FlightService.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before method: Loading all flight details.");
    }

    @Before(value = "execution(* com.pjsoft.fms.service.FlightService.*(..)) and args(flightId)")
    public void beforeAdvice(JoinPoint joinPoint, Long flightId) {
        System.out.println("Before method: Just loading the flight with Id : "+ flightId);
    }

    //    After Advice:An advice that executes after a join point, is called after advice.
    @After(value = "execution(* com.pjsoft.fms.service.FlightService.*(..)) and args(flight)")
    public void afterAdvice(JoinPoint joinPoint, Flight flight) {
        System.out.println("After method: Successfully created a flight detail");
    }

    @After(value = "execution(* com.pjsoft.fms.service.FlightService.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After method: executed findFlightById");
    }

    //    Around Advice:An advice that executes before and after of a join point, is called around advice.
//    @Around(value = "logDisplayingBalance()")
//    public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("The aroundAdvice() before invokation of the method " + jp.getSignature().getName() + " method");
//    }

    //    After Throwing Advice:An advice that executes when a join point throws an exception.
    @AfterThrowing(value = "execution(* com.pjsoft.fms.service.FlightService.*(..))", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        System.out.println("After Throwing exception in method:" + joinPoint.getSignature());
    }

    //    After Returning Advice:An advice that executes when a method executes successfully.
    @AfterReturning(value = "execution(* com.pjsoft.fms.service.FlightService.*(..))", returning = "flight")
    public void afterReturningAdvice(JoinPoint joinPoint, Flight flight) {
        System.out.println("After Returing method: Flight details has been displayed sucessfully");
    }

}
