package org.hong.tool.logger.annotation;

import org.hong.tool.logger.enumeration.LoggerType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Logit {
    LoggerType value() default LoggerType.INFO;
}
