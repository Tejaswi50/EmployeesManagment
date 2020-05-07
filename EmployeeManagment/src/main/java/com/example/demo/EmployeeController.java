package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	//1.Finding all employee details
	@GetMapping("/allemployeesdetails")
	public List<Employee> getAllEmployees()
	{
		return repository.findAll();
		//return new Employee("tejaswi","rangaraju","trteju84@gmail.com");
	}
	//2.finding employee details by id
	@GetMapping("/allemployeesdetails/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable(value="id") Long empid)
	{
		return repository.findById(empid);
	}
	//3.Create new Employee
	@PostMapping("/createemployee")
	public Employee createemployee(@Valid@RequestBody Employee employee)
	{
		return repository.save(employee);
		
	}
	//4.Update Employee
	@PutMapping("/updateemployee/{id}")
	
public ResponseEntity<Employee> updateemployee(@PathVariable(value= "id") Long empid,
		@Valid @RequestBody Employee employeedetails) throws ResourceNotFoundException {
	Employee employee = repository.findById(empid)
	.orElseThrow(() -> new ResourceNotFoundException());
	 employee.setEmailid( employeedetails.getEmailid());
	
	 employee.setFirstname(employeedetails.getFirstname());
	employee.setLastname( employeedetails.getLastname());
	final Employee updatedemployee = repository.save(employee);
	return ResponseEntity.ok(updatedemployee);
	
}
	//5.Delete Employee
	
	@DeleteMapping("/deleteemployee/{id}")
	
	public void deleteemployee(@PathVariable(value="id") Long id)throws ResourceNotFoundException
{
	Employee employee = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException());
		repository.delete(employee);
		
		
}
	

}
