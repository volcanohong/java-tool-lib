package org.hong.tool.logger.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.hong.tool.logger")
@EnableAspectJAutoProxy
public class LogitConfiguration {
    LogitConfiguration() {
        System.out.println("----- LogitConfiguration -----");
    }
}
