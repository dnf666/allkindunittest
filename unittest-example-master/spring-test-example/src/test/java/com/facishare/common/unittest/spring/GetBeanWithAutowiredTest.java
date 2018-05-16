package com.facishare.common.unittest.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GetBeanWithAutowiredTest extends AbstractCommonTest {

  @Autowired
  Employee employee;

  @Test
  public void testEmployee() {
    assertEquals("zhangsan", employee.getName());
  }

}
