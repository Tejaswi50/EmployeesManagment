package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagmentApplication implements CommandLineRunner{

Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EmployeeController controller;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info(" ",controller.createemployee(new Employee("tejaswi","rangaraju","trteju84@gmail.com")));
	logger.info("",controller.updateemployee(1l, new Employee("rangaraju","govindaraju","raju@gmail.com")));
	}	

}
