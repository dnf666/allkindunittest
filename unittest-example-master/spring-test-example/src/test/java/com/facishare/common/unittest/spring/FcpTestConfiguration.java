package com.facishare.common.unittest.spring;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created with IntelliJ IDEA.
 * User: wujp@fxiaoke.com
 * Date: 16/8/25
 * Time: 下午9:59
 */
@Configuration
public class FcpTestConfiguration {

  @Bean
  @Primary
  public Employee4Primary employee4Primary() {
    return Mockito.mock(Employee4Primary.class);
  }

}
