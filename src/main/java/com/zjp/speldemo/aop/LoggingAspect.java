package com.zjp.speldemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName: LoggingAspect
 * Package: com.zjp.speldemo.aop
 * Description:
 *
 * @author zjp
 * @version 1.0
 * @data: 2024/11/5 9:15
 */
@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.zjp.speldemo.service.*.*(..)) && args(name) && @annotation(com.zjp.speldemo.annotation.Loggable)")
    public void logMethodEntry(@Value("#{name}") String name) {
        log.info("Entering method with name: {}", name);
    }
}
