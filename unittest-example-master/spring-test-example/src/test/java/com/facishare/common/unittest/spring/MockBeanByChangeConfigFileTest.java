package com.facishare.common.unittest.spring;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class MockBeanByChangeConfigFileTest extends AbstractCommonTest {

  @Autowired
  Employee4ConfigFileService employee4ConfigFileService;
  @Autowired
  Employee4ConfigFile employee4ConfigFile;

  @Test
  public void testEmployee() {
    Mockito.when(employee4ConfigFile.getName())
        .thenReturn("fs");
    String name =employee4ConfigFileService.getName();
    assertEquals("fs", name);
  }


}
