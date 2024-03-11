package com.myLearning.springBoot.mailer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.myLearning.springBoot.mailer.service.PurchaseOrderServiceImpl;

@SpringBootApplication
public class SpringBootMailerApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context =  SpringApplication.run(SpringBootMailerApplication.class, args);
				
		PurchaseOrderServiceImpl service = context.getBean(PurchaseOrderServiceImpl.class);
		String status = service.purchase(new String [] {"Java","Microservices","LLD","HLD"}, new Double[] {1299.00,1100.00,450.0,600.0}, new String[] {"your_mail1@gmail.com","your_mail2@gmail.com"});
		
		System.out.println(status);
		
		context.close();
	}

}
