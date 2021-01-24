package com.spring.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	
	
	Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("within(com.spring.Repository.*)")
	public void applicationPackagePointcut() {
			
		
	}
	
	
	@Around("applicationPackagePointcut()")
	 public Object logAroundAllMethods(ProceedingJoinPoint pjp) throws Throwable 
	    {
	        System.out.println("****LoggingAspect.logAroundAllMethods() - Before "+ pjp.getSignature().getName() +" call");
	        long start = System.currentTimeMillis();
	        logger.info("Method " + pjp.getSignature().getName() + " execution started at:" + new Date());
	         
	        Object result =  pjp.proceed();
	        
	        long end=System.currentTimeMillis();
	         System.out.println("processing time   "+(end-start));
	        System.out.println("****LoggingAspect.logAroundAllMethods() - After "+ pjp.getSignature().getName() +" call");
	        return result;
	    }
	
	
	
	
	

}
