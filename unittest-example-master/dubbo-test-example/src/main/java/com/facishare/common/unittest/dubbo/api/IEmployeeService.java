package com.facishare.common.unittest.dubbo.api;

import com.facishare.common.unittest.dubbo.entity.Employee;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: birdwyatt
 * Date: 16/8/26
 * Time: 下午6:57
 */
public interface IEmployeeService {
  public Employee getEmployeeById(String id);

}
