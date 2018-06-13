package com.appleyk.protocol.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.appleyk.protocol.model.SObjectModel.Students;
import com.appleyk.protocol.model.SObjectModel.Students.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentModelTest {

	
	public static void main(String[] args) throws Exception{
		
		/**
		 *  消息体的构建器，消息体的build方法可以产生对象
		 */
		Students.Builder sBuilders = Students.newBuilder();
		
		Student.Builder sBuilder = Student.newBuilder();	
		sBuilder.setId(1001L);
		sBuilder.setName("张三");
		//添加兴趣爱好
		sBuilder.addHobbies("游戏");
		sBuilder.addHobbies("睡觉");
		sBuilder.addHobbies("篮球");
		
		//添加成绩键值对
		sBuilder.putGrades("数学", 95.5);
		sBuilder.putGrades("语文", 88.5);
		sBuilder.putGrades("英语", 99.0);
		
		
		Student.Builder sBuilder2 = Student.newBuilder();	
		sBuilder2.setId(1002L);
		sBuilder2.setName("李玟");
		//添加兴趣爱好
		sBuilder2.addHobbies("逛街");
		sBuilder2.addHobbies("看书");
		
		//添加成绩键值对
		sBuilder2.putGrades("数学", 85.5);
		sBuilder2.putGrades("语文", 92.0);
		sBuilder2.putGrades("英语", 95.5);
		
		//学生列表构建  == 添加两个学生builder【消息体】
		sBuilders.addStudents(sBuilder);
		sBuilders.addStudents(sBuilder2);
		
		//builder 转 对象
		Students students = sBuilders.build();
		System.out.println("输出对象信息："+students);
		byte[] data = students.toByteArray();
		System.out.println("protobuff字节数："+data.length);
				
		//对象 再次转化成Java实体类
		pbfModelToJavaEntity(students.getStudentsList());
		
	}	
	
	
	public static void pbfModelToJavaEntity(List<Student> students) throws Exception{
		
		List<com.appleyk.protocol.entity.Student> stuList = new ArrayList<>();
		com.appleyk.protocol.entity.Student stu;
		for (Student student : students) {
			stu = new com.appleyk.protocol.entity.Student();
			stu.setName(student.getName());
			stu.setId(student.getId());
			
			//取兴趣爱好
			for(int i =0;i<student.getHobbiesCount();i++){
				stu.addHobby(student.getHobbies(i));
			}
			
			//取各科成绩
			Map<String, Double> gradesMap = student.getGradesMap();
			stu.setGrades(gradesMap);
			stuList.add(stu);
		}
		ObjectMapper mapper = new ObjectMapper();
		String json  = mapper.writeValueAsString(stuList);
		System.out.println("json字节数："+json.getBytes().length);
	}
}
