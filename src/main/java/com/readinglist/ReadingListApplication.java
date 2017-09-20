package com.readinglist;

import com.readinglist.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ReadingListApplication {


	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ReadingListApplication.class, args);

		HelloService helloService = ctx.getBean(HelloService.class);
		System.out.println(helloService);

	}
}
