package com.fl.core.config;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
public class CallMonitoringAspect {
    
    @Value("${call.method.monitoring:false}")
    private Boolean enabled;
    
    @Around("within(@org.springframework.stereotype.Service *)")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        if (this.enabled) {
            StopWatch sw = new StopWatch(joinPoint.toShortString());
            
            sw.start("invoke");
            try {
                return joinPoint.proceed();
            } finally {
                sw.stop();
                log.info(sw.shortSummary());
            }
        } else {
            return joinPoint.proceed();
        }
    }
    
    // @Before("execution(* com.checker.cms.controllers.PromoController.promoList(..))")
    // public void beforePromoController(JoinPoint jp) {
    // log.info("(beforePromoController) Before executing '" + jp.getSignature().toLongString() + "'");
    // }
}
