package com.facishare.common.unittest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Employee4ConfigFileService {
	@Autowired
	Employee4ConfigFile employee4ConfigFile;
	public String getName(){
		return employee4ConfigFile.getName();
	}
}
