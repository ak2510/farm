package com.magadh.farm.common.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

   /* @Pointcut("execution(* com.magadh.farm..*.*(..))")
    public void applicationPackagedPointcut() {}*/
}
