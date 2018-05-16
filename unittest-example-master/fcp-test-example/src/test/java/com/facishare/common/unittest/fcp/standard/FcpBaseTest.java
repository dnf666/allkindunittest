package com.facishare.common.unittest.fcp.standard;

/**
 * Created with IntelliJ IDEA.
 * User: birdwyatt
 * Date: 2016/10/29
 * Time: 下午1:43
 */

import com.facishare.fcp.biz.AuthInfo;
import com.facishare.fcp.handler.FcpServiceContext;
import com.facishare.fcp.handler.FcpServiceContextManager;
import com.facishare.fcp.protocol.FcpHeader;
import com.facishare.fcp.protocol.FcpRequest;
import com.facishare.fcp.protocol.FcpResponse;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

  /**
   * Created by liyiguang on 16/9/8.
   */

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(locations = "classpath:testApplicationContext.xml")
  public abstract class FcpBaseTest {

    protected FcpServiceContextManager contextManager;

    @Before
    public void setUp() throws Exception {
      contextManager = Mockito.mock(FcpServiceContextManager.class);
      when(contextManager.getContext()).thenReturn(new FcpServiceContext() {
        @Override
        public FcpRequest getFcpRequest() {
          return null;
        }

        @Override
        public FcpResponse getFcpResponse() {
          return null;
        }

        @Override
        public <V> V getAttribute(Object key) {
          return null;
        }

        @Override
        public void setAttribute(Object key, Object value) {

        }

        @Override
        public String getStringFcpHeader(FcpHeader.FcpHeaderType type, String defaultValue) {
          return null;
        }

        @Override
        public String getStringFcpHeader(FcpHeader.FcpHeaderType type) {
          if(type == FcpHeader.FcpHeaderType.USER_INFO){
            return "E.fs.10000";
          }
          return null;
        }

        @Override
        public long getLongFcpHeader(FcpHeader.FcpHeaderType type, long defaultValue) {
          return 0;
        }

        @Override
        public long getLongFcpHeader(FcpHeader.FcpHeaderType type) {
          if(type == FcpHeader.FcpHeaderType.ENTERPRISE_ID){
            return 1L;
          }

          return 0;
        }

        @Override
        public void performanceLogStep(String tagName) {

        }

        @Override
        public void performanceLog() {

        }

        @Override
        public AuthInfo getAuthInfo() {
          AuthInfo authInfo = new AuthInfo();
          authInfo.setEmployeeFullId("E.fs.10000");
          return authInfo;
        }
      });
    }
  }
