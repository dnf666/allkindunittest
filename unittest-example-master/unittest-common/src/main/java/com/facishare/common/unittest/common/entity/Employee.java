package com.facishare.common.unittest.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Employee {
	private Integer age;
	private String name;
	@Override
	public String toString(){
		return "Employee name is "+name+",age is"+age;
		
	}

}
