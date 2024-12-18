package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Book1;
import com.example.demo.model.Employee;

public interface BookRepo extends JpaRepository<Book1,String> {

	
}
