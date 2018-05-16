package com.facishare.common.unittest.spring;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class MockBeanByPrimaryTest extends AbstractCommonTest {

  @Autowired
  Employee4Primary employee4Primary;

  @Test
  public void testEmployee() {
    Mockito.when(employee4Primary.getName())
        .thenReturn("fs");
    String name =employee4Primary.getName();
    assertEquals("fs", name);
  }


}
