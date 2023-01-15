package com.springorm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entity.Student;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);

		while (true) {
			System.out.println("Press 1 for add new Student");
			System.out.println("Press 2 for display Students");
			System.out.println("Press 3 for display single student");
			System.out.println("Press 4 to delete student");
			System.out.println("Press 5 to update student");
			System.out.println("Press 6 to exit...");
			int input = sc.nextInt();

			if (input == 1) {
				Student student = new Student(3, "Sunny", "Ghaziabad");
				int result = studentDao.insert(student);
				System.out.println(result + " row affected!!");
			} else if (input == 2) {
				List<Student> student = studentDao.getAllStudents();
				System.out.println(student);
			} else if (input == 3) {
				System.out.println("Enter Student Id: ");
				int id = sc.nextInt();
				Student student = studentDao.getStudent(id);
				System.out.println(student);
			} else if (input == 4) {
				int id = sc.nextInt();
				studentDao.deleteStudent(id);
			} else if (input == 5) {
				Student student = new Student(3, "Vikas", "Baharampur");
				studentDao.updateStudent(student);
			} else {
				break;
			}
		}

	}
}