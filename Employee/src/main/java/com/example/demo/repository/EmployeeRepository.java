package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,String>{

	List <Employee> findBydepartment(String name);
	List <Employee> findByageGreaterThan(int age);
	List <Employee> findByageBetween(int begin,int end);
	List <Employee> findByphonenoStartingWith(String mobno);
	List <Employee> findByphonenoEndingWith(String mobno);
	List <Employee> findByCity(String city);
	
	@Query("SELECT e FROM Employee e WHERE e.department = :department")
    List<Employee> findBytheDepartment(@Param("department") String department);
	
	@Query("select e from Employee e order by e.name asc")
	List<Employee> findallsortedbyname();
	
	@Query("select e from Employee e")
	List<Employee>findallemployee();
	
	//@Query("select e.city, e.name, b.authorid, b.authorname from emplyee e, book b where e.employeeid= b.employeeid")
	@Query("select new com.example.demo.model.Book1(e.city, e.name, b.authorid, b.authorname) " +
	           "from Employee e join Book1 b on e.Employeeid = b.employeeid")
	Optional<Employee> findbythebookandemployeetabledata();
}


//@Query("SELECT e FROM Employee e WHERE e.department ='IT'")
//List<Employee> findbytheDepartment(@Param("d") String department);