package edu.mum.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SearchingAspect {
	
	
	 @Pointcut("execution(* edu.mum.service.impl..*(..))")
	    public void apllicationMethod() {}
	 
	 @Pointcut("execution(* edu.mum.service.impl..save(..))")    
	    public void outOfCrudMethod() {}

	   @Pointcut("@annotation(edu.mum.aspect.annotation.Searching)")
	    public void searching() {}
	

		  @Before("searching() && apllicationMethod()")             
		  public void logResource(JoinPoint joinPoint) {
		  Logger log = Logger.getLogger("");
		    log.info("   **********     TARGET CLASS : " + joinPoint.getSignature().getName() + "    **********");
		    System.out.println();
				    System.out.println( "   **********     TARGET CLASS : " + 
	    			joinPoint.getSignature().getDeclaringTypeName() + "." +
	    			joinPoint.getSignature().getName() + " args  " +
	    				    			"    **********");
	  }

}
