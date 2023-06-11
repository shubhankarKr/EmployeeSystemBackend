package app.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	public static Logger logger=LogManager.getLogger(LoggingAspect.class);
	
	@Before("execution(* app.service.*.*(..))")
	public void logBeforeAdvice(JoinPoint joinPoint) {
		logger.info("called method "+joinPoint.getSignature().getName()+"()");
	}
	
	@AfterThrowing(pointcut = "execution(* app.service.*.*(..))", throwing = "exception")
	public void methodError(JoinPoint joinPoint,Exception exception) {
		logger.error("Exception on method "+ joinPoint.getSignature().getName()+"() message= " +exception.getMessage());
	}
	
	@AfterReturning(pointcut = "execution(* app.service.*.*(..))",returning = "result")
	public void logAfterAdvice(JoinPoint joinPoint,String result) {
		logger.info("called method successful "+joinPoint.getSignature().getName()+"()");
		logger.info("value "+result.toString());
	}
}
