package com.facishare.common.unittest.spring;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Service
@lombok.Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Employee4Primary {
	private Integer age =20;
	private String name  ="zhangsan";
	@Override
	public String toString(){
		return "Employee name is "+name+",age is"+age;
		
	}

}
