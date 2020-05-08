package com.brightminds.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component(value = "loggingAspect")
@Aspect //When we create an Aspect, we are creating a module that we are intending to use to inject advice throughout our application.
public class LoggingAspect {

	private static final Logger LOG = LogManager.getLogger(LoggingAspect.class);
	
	@Pointcut("within(com.brightminds.controller.*)")
	public void allControllerPointCut() {
		
	}
	
	@Pointcut("within(com.brightminds.service.*)")
	public void allServicePointCut() {
		
	}
	
	//Before all controller access it will be logged.
	@Before(value="allControllerPointCut()")
	public void logBefore(JoinPoint jp) {
		LOG.info("Controller has been accessed and " + jp.getSignature().getName() + " method is going to be ran!");
	}
	
}
