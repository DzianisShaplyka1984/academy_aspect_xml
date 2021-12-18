package com.academy.aspect;

import java.util.Date;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component("work")
public class Work {

  public void beforeWork() {
    System.out.println("Invoke code before work");
  }

  public void afterJob() {
    System.out.println("Invoke code after work");
  }

  public void afterWorkException() {
    System.out.println("Invoke code after exception");
  }

  public void aroundWork(ProceedingJoinPoint point) {

    try {
      System.out.println("Start");
      var start = new Date().getTime();

      var result = (String) point.proceed();

      var end = new Date().getTime();
      System.out.println("End result " + result + " time " + (end - start));
    } catch (Throwable e) {
      System.out.println(e);
    }
  }

  public void beforeJobWithName(String name) {
    System.out.println("Invoke code before exception with name " + name);
  }
}
