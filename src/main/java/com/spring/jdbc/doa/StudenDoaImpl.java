package com.spring.jdbc.doa;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entites.Student;

public class StudenDoaImpl implements StudentDao {

	private JdbcTemplate template;

	public int insert(Student student) {
		// insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int result = this.template.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	public int change(Student student) {
		// updating query
		String query = "update student set name=? , city=? where id=?";
		int result = this.template.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	public int delete(int studentId) {
		// Delete query
		String query = "delete from student where id=?";
		int result = this.template.update(query, studentId);
		return result;
	}

	public Student getStudent(int studentId) {
		// Selecting single student data
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student result = this.template.queryForObject(query, rowMapper, studentId);
		return result;
	}

	public List<Student> getAllStudents() {
		// Selecting multiple student data
		String query = "select * from student";
		List<Student> result = this.template.query(query, new RowMapperImpl());
		return result;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

}
