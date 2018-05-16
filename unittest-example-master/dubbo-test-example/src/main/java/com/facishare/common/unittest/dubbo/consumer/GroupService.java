package com.facishare.common.unittest.dubbo.consumer;

import com.facishare.common.unittest.dubbo.api.IEmployeeService;
import com.facishare.common.unittest.dubbo.api.IGroupService;
import com.facishare.common.unittest.dubbo.entity.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: birdwyatt
 * Date: 16/8/26
 * Time: 下午6:58
 */

public class GroupService implements IGroupService {

  public void setiEmployeeService(
      IEmployeeService iEmployeeService) {
    this.iEmployeeService = iEmployeeService;
  }

  IEmployeeService iEmployeeService;
  @Override
  public List<Employee> getAllEmployees() {
    List list = new ArrayList<Employee>();
    list.add(iEmployeeService.getEmployeeById("zhangsan"));
    list.add(iEmployeeService.getEmployeeById("lisi"));
    return list;
  }
}
