package com.facishare.common.unittest.dubbo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;

@lombok.Data
@AllArgsConstructor
@Builder
public class Employee implements Serializable{
	private Integer age;
	private String name;

	@Override
	public String toString(){
		return "Employee name is "+name+",age is"+age;
		
	}

	public static void main(String[] args) {
		Employee employee = Employee.builder().age(123).name("123").build();
		System.out.println(employee);
	}

}
