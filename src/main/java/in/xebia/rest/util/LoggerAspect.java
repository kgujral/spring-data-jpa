package in.xebia.rest.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    /**
     * This method will be automatically invoked before any method lying in the package
     * com.giftdiggers.web is called and appropriate logging will be done.
     * @param joinPoint
     */
    @Before("execution(* in.xebia.rest..*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        if(logger.isDebugEnabled()) {
            // constructing a string of the method signature, method and parameters
            StringBuilder traceString = new StringBuilder(joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName() + "(");
            Object[] args = joinPoint.getArgs();
            for(int i = 0; i < args.length; i++) {
                if(args[i] != null) {
                    traceString.append(args[i]);
                } else {
                    traceString.append("null");
                }
                if(i < (args.length -1)) {
                    traceString.append(", ");
                }
            }
            traceString.append(")");
            logger.debug(traceString.toString());
        }
    }
}