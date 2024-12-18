package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
//import com.example.demo.model.Book1;
@Data
@Entity
@Table(name="Employee")
public class Employee {

	@Id
	String Employeeid;
	int age;
	double salary;
	String phoneno,department,city,name;
	
	
	public Employee(String employeeid, int age, double salary, String phoneno, String department, String city,
			String name) {
		super();
		Employeeid = employeeid;
		this.age = age;
		this.salary = salary;
		this.phoneno = phoneno;
		this.department = department;
		this.city = city;
		this.name = name;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	
}
