package main.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.events.Event;



@SpringBootApplication
public class EventListnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventListnerApplication.class, args);
	}
  
	  @Bean
	  ApplicationListener<ApplicationReadyEvent> readyEventListener( ) {
		  return event -> {
	            System.out.println("================================ Application started ============================");
	            System.out.println("================================ List of User Defined Bean Names ============================ ");
	              
	            String[] beanNames = event.getApplicationContext().getBeanNamesForType(Object.class);
	            
	            for (String beanName : beanNames) {
	            	
	            	 if (event.getApplicationContext().getBean(beanName).getClass().getName().startsWith("main")) {
	            		 
	            		 System.out.println("Bean Name: " + beanName);
	            	 }
	                
	            }

		  };
	  }
}
