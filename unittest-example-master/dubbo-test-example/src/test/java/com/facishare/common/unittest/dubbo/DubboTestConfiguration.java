package com.facishare.common.unittest.dubbo;

import com.facishare.common.unittest.dubbo.api.IEmployeeService;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created with IntelliJ IDEA.
 * User: wujp@fxiaoke.com
 * Date: 16/8/25
 * Time: 下午9:59
 * 针对Dubbo服务来讲, Primary的方式无法实现, dubbo的实现不要参考这种方式
 */
@Configuration
public class DubboTestConfiguration {

  @Bean(name="employeeServiceProvider")
  @Primary
  public IEmployeeService employee4Primary() {
    return Mockito.mock(IEmployeeService.class);
  }

}
