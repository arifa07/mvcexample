package com.capgemini.mvcexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.mvcexample.entity.Student;
import com.capgemini.mvcexample.service.StudentService;

@Controller
public class StudentController {
		@Autowired
		private StudentService service;
		//Retrieve
		@GetMapping("/student/{studentId}")
		public ModelAndView getStudentById(@PathVariable("studentId") Integer studentId) {
			Map<String,Student> model = new HashMap<String, Student>();
			model.put("studentData", service.getStudentById(studentId));
			
			return new ModelAndView("viewstudent",model);
		}
		//Retrieve
		@GetMapping("/students")
		public ModelAndView getStudents(){
			Map<String,List<Student>> model = new HashMap<String, List<Student>>();
			model.put("students", service.getStudents());
			return new ModelAndView("viewstudents",model);
			
		}
		
		/**
		//Create
		@PostMapping("/addstudent")
		public Student addStudent(@RequestBody Student student){
			return service.addStudent(student);
		}
		//Delete
		@DeleteMapping("/deletestudent/{id}")
		public void deleteStudent(@PathVariable("id") Integer studentId){
			service.deleteStudent(studentId);
		}
		//Update
		@PutMapping("/updatestudent/{id}")
		public Student updateStudent(@RequestBody Student student, @PathVariable("id") Integer studentId){
			Student studentData = service.updateStudent(student, studentId);
			return studentData;
		}**/
}
