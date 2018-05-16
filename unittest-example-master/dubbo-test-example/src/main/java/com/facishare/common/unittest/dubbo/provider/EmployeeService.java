package com.facishare.common.unittest.dubbo.provider;

import com.facishare.common.unittest.dubbo.api.IEmployeeService;
import com.facishare.common.unittest.dubbo.entity.Employee;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: birdwyatt
 * Date: 16/8/26
 * Time: 下午6:58
 */
public class EmployeeService implements IEmployeeService {

  @Override
  public Employee getEmployeeById(String id) {
    if("zhangsan".equals(id)){
      return new Employee(1,"zhangsan");
    }
    if("lisi".equals(id)){
      return new Employee(2,"lisi");
    }
    return null;

  }
}
