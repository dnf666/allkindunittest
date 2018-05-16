package com.facishare.common.unittest.fcp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testApplicationContext.xml"})
@Slf4j
abstract public class AbstractCommonTest {
  @BeforeClass
  public static void beforeClass() {
      log.info("before class");
  }


  @AfterClass
  public static void afterClass() {
    log.info("after class");
  }

}
