package com.facishare.common.unittest.fcp;

import com.facishare.common.unittest.fcp.common.FcpUtils;
import com.facishare.common.unittest.fcp.service.DataServiceUseBaseImpl;

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
  public FcpUtils fcpUtils() {
    return Mockito.mock(FcpUtils.class);
  }

  @Bean
  @Primary
  public DataServiceUseBaseImpl dataServiceUseBaseImpl() {
    return Mockito.spy(DataServiceUseBaseImpl.class);
  }

}
