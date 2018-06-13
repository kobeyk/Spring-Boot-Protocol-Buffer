package com.appleyk.protocol.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生类
 * @author yukun24@126.com
 * @blob   http://blog.csdn.net/appleyk
 * @date   2018年6月13日-下午3:00:33
 */
public class Student {

	/**
	 *  ID == 唯一标识
	 */
	private Long id;
	
	/**
	 *  姓名
	 */
	private String name;
	
	/**
	 *  兴趣爱好
	 */
	private List<String> hobbies;
	
	/**
	 * 各科成绩
	 */
	private Map<String, Double> grades;
	
	public Student(){
		hobbies = new ArrayList<>();
		grades = new HashMap<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public Map<String, Double> getGrades() {
		return grades;
	}

	public void setGrades(Map<String, Double> grades) {
		this.grades = grades;
	}
	
	public void addHobby(String hobby){
		hobbies.add(hobby);
	}
}
