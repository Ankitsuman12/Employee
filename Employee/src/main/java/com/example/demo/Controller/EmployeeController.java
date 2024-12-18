package com.example.demo.Controller;
import com.example.demo.model.Book1;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping()
	List<Employee> getdata() {
		System.out.println("getdatafindAll-> ");
		return employeeRepository.findAll();
	}
	
	@GetMapping("/join")
	ResponseEntity<Optional <Employee>> getjoindata()
	{
		Optional<Employee> emp = employeeRepository.findbythebookandemployeetabledata();
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	

	@PostMapping()
	ResponseEntity<Employee> savedata(@RequestBody Employee emp) {
		// Employee em="";
		String ids = "";
		List<Employee> employee = employeeRepository.findAll();
		System.out.println("i am inside postMapping");

		for (Employee emps : employee) {

			ids = emps.getEmployeeid();
			if (ids.equals(emp.getEmployeeid())) {
				System.out.println("Employee id already exist!");
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}

		}
		Employee em = employeeRepository.save(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(em);
		//return ResponseEntity<>(em,HttpStatus.CREATED);

	}

	@GetMapping("/getdepartment/{department}")
	List<Employee> getdatabydepartment(@PathVariable("department") String departmentt) {

		return employeeRepository.findBydepartment(departmentt);
	}

	@GetMapping("/greaterthan/{age}")
	List<Employee> getdatabyage(@PathVariable("age") int age) {

		return employeeRepository.findByageGreaterThan(age);
	}

	@GetMapping("/getemployeeagebetween/{begin}/{end}")
	List<Employee> getdatabyage(@PathVariable("begin") int begin, @PathVariable("end") int end) {

		return employeeRepository.findByageBetween(begin, end);
	}

	@GetMapping("/getemployephonenostartwith/{startwith}")
	List<Employee> getdatabymobsw(@PathVariable("startwith") String startwith) {

		return employeeRepository.findByphonenoStartingWith(startwith);
	}

	@GetMapping("/getemployeephonenoendwith/{endwith}")
	List<Employee> getdatabymobeww(@PathVariable("endwith") String endwith) {
		System.out.println("end ->");
		return employeeRepository.findByphonenoEndingWith(endwith);
	}

	@GetMapping("/getemployeebycity/{city}")
	List<Employee> getdatabycity(@PathVariable("city") String city) {
		System.out.println("end ->");
		return employeeRepository.findByCity(city);
	}

	@GetMapping("/custommethod/{department}")
	public List<Employee> Customquerymethod(@PathVariable("department") String department) {
		return employeeRepository.findBytheDepartment(department);
		
	}
	
	@GetMapping(value="/orderbyname")
	public List <Employee> orderbyname()
	{
		return employeeRepository.findallsortedbyname();
	}
	
	@GetMapping(value="/allemployee")
	public List <Employee> allemployee()
	{
		return employeeRepository.findallemployee();
	}
	
}
