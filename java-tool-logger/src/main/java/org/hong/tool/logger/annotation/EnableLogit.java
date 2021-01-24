package org.hong.tool.logger.annotation;

import org.hong.tool.logger.config.LogitConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LogitConfiguration.class)
@EnableAspectJAutoProxy
public @interface EnableLogit {
}
