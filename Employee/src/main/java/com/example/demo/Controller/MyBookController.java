package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book1;
import com.example.demo.model.Employee;
import com.example.demo.repository.BookRepo;


@RestController()
@RequestMapping("/books")
public class MyBookController {

	@Autowired
	BookRepo br;
	
	@GetMapping()
	ResponseEntity<List <Book1>> get()
	{
		List<Book1> book = br.findAll();
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	
	
	@PostMapping()
	ResponseEntity<Book1> savadata(@RequestBody Book1 book)
	{
		Book1 books= br.save(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(books);
	}
}
