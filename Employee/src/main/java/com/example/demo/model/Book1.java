package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="book")
public class Book1 {
		@Id
		String authorid;
		String booktitle,authorname, employeeid;
		
		
		
		public Book1(String authorid, String booktitle, String authorname, String employeeid) {
			super();
			this.authorid = authorid;
			this.booktitle = booktitle;
			this.authorname = authorname;
			this.employeeid = employeeid;
		}



		public Book1() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		

}
