package com.academy;

import com.academy.service.TaskService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXml {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    var taskService = context.getBean(TaskService.class);

    taskService.performJob();
    taskService.performJob("MY test");
    taskService.performJob("New test", "Hello");

    System.out.println("--------------------------------------");

    try {
      taskService.performExceptionJob();
    } catch (Exception e) {
      System.out.println(e);
    }

    System.out.println("--------------------------------------");

    taskService.performJobAround();

    System.out.println("--------------------------------------");

    taskService.performJobWithName("Hello world");
  }
}
