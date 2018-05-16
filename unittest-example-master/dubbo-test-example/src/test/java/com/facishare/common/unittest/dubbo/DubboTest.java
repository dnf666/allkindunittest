package com.facishare.common.unittest.dubbo;

import com.facishare.common.unittest.dubbo.api.IGroupService;
import com.facishare.common.unittest.dubbo.entity.Employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: birdwyatt
 * Date: 16/8/26
 * Time: 下午7:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
@Slf4j
public class DubboTest {

  @Autowired
  IGroupService groupService;

  @Test
  public void run() {
    List<Employee> list = groupService.getAllEmployees();
    assertNotNull(list);
    assertEquals(2,list.size());
    assertEquals("zhangsan",list.get(0).getName());
    assertEquals("lisi",list.get(1).getName());
  }

}
