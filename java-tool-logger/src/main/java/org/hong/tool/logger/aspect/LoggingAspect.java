package org.hong.tool.logger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hong.tool.logger.annotation.Logit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Before("@annotation(logit)")
    public void before(JoinPoint point, Logit logit) throws Throwable {
        log.info("Class: {}, Method: {}", getClassName(point), getMethodName(point));
        Arrays.stream(point.getArgs()).forEach(arg -> log.info("Param: [{}]", arg));
    }

    @Around("@annotation(logit)")
    public Object around(ProceedingJoinPoint point, Logit logit) throws Throwable {
        Instant startTime = Instant.now();
        Object result = point.proceed();
        Instant endTime = Instant.now();
        Duration elapseTime = Duration.between(endTime, startTime);
        log.info("Method: {}, Processing time: {}ms", getMethodName(point), elapseTime.getNano()/10e6);
        return result;
    }

    private String getMethodName(JoinPoint point) {
        return point.getSignature().getName();
    }

    private String getClassName(JoinPoint point) {
        return point.getTarget().getClass().getName();
    }
}
