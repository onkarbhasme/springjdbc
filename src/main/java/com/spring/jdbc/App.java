package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.doa.StudenDoaImpl;
import com.spring.jdbc.entites.Student;

public class App {
	public static void main(String[] args) {
		// spring jdbc => JdbcTemplate
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcCofig.class);
		StudenDoaImpl studenDoaImpl = context.getBean("studentDoa", StudenDoaImpl.class);

		// Insert
//		Student s = new Student();
//		s.setId(115);
//		s.setName("OB");
//		s.setCity("Pune");
//
//		int result = studenDoaImpl.insert(s);
//		System.out.println("Number of record inserted : " + result);

		// Update
//		Student s = new Student();
//		s.setId(114);
//		s.setName("Rohit");
//		s.setCity("Mumbai");
//
//		int result = studenDoaImpl.change(s);
//		System.out.println("Number of record Updated : " + result);
//		
		// Delete
//		int result = studenDoaImpl.delete(114);
//		System.out.println("Number of record Deleted : " + result);

		// Select single data
//		Student student = studenDoaImpl.getStudent(111);
//		System.out.println(student);

		// Select multiple data
		List<Student> result = studenDoaImpl.getAllStudents();
		for (Student s : result) {
			System.out.println(s);
		}

	}
}
