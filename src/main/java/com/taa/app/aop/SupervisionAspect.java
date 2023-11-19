package com.taa.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class SupervisionAspect {
    @Around("@annotation(supervision)")
    public Object superviser(ProceedingJoinPoint jointPoint, Supervision supervision) throws Throwable{
        long maxDuree = supervision.dureeMillis();
        long start = System.currentTimeMillis();
        try {
            return jointPoint.proceed(jointPoint.getArgs());
        } finally {
            long end = System.currentTimeMillis();
            long duree = end - start;
            if (duree > maxDuree) {
                System.out.printf("L'appel à %s à durée %dms soit %dms de plus qu'attendu%n",
                        jointPoint.toShortString(), duree, duree - maxDuree);
            }
        }
    }
}
