package com.appleyk.protocol.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.appleyk.protocol.model.SObjectModel.Students;
import com.appleyk.protocol.model.SObjectModel.Students.Student;
import com.appleyk.protocol.result.ResponseMessage;
import com.appleyk.protocol.result.ResponseResult;

@RestController
@RequestMapping("/appleyk/student")
public class StudentController {

	
	@PostMapping("/save")
	public ResponseResult SaveStudent(MultipartFile data) throws Exception{
		
		byte[] object = data.getBytes();
		Students students = Students.newBuilder().build().parseFrom(object);
		List<Student> studentsList = students.getStudentsList();
		for (Student student : studentsList) {
			System.out.println("in: "+student.getId());
			System.out.println("name: "+student.getName());
			//取兴趣爱好
			for(int i =0;i<student.getHobbiesCount();i++){
				System.out.println("兴趣爱好："+student.getHobbies(i).toString());
			}
			//取各科成绩
			Map<String, Double> gradesMap = student.getGradesMap();
			System.out.println("各科成绩："+gradesMap.toString());
			System.out.println("name: "+student.getName());
			System.out.println("========================");
		}
		return new ResponseResult(ResponseMessage.OK);
	}
}
