
package com.springorm.dao;

import java.util.List;

import com.springorm.entity.Student;

public interface StudentDao {
	public int insert(Student student);
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();
	public void deleteStudent(int studentId);
	public void updateStudent(Student student);
}
