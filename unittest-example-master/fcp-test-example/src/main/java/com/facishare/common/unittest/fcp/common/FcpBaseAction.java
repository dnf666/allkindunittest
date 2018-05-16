package com.facishare.common.unittest.fcp.common;

/**
 * Created with IntelliJ IDEA.
 * User: wujp@fxiaoke.com
 * Date: 2016/10/29
 * Time: 下午1:49
 */

import com.facishare.fcp.biz.AuthInfo;
import com.facishare.fcp.handler.FcpServiceContextManager;
import com.facishare.fcp.protocol.FcpHeader;
import com.facishare.fcp.service.DefaultFcpServiceContextManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FcpBaseAction {

  private FcpServiceContextManager contextManager = DefaultFcpServiceContextManager.getInstance();
  private static final Pattern EMPLOYEE_ID = Pattern.compile("^E\\.(.*)\\.((-|\\d)*)$");

  public AuthInfo getAuthInfo() {
    return contextManager.getContext().getAuthInfo();
  }

  public void setContextManager(FcpServiceContextManager contextManager) {
    this.contextManager = contextManager;
  }

  public long getEID(){
    return contextManager.getContext().getLongFcpHeader(FcpHeader.FcpHeaderType.ENTERPRISE_ID);
  }
  /**
   * 取企业账号
   * @return
   */
  public String getEa() {
    String userAccount = contextManager.getContext().getStringFcpHeader(FcpHeader.FcpHeaderType.USER_INFO);
    if(userAccount == null) {
      throw new IllegalArgumentException("Full employeeId is null");
    } else {
      Matcher m = EMPLOYEE_ID.matcher(userAccount);
      if(!m.find()) {
        throw new IllegalArgumentException("Unsupported full employeeId:" + userAccount);
      } else {
        return m.group(1);
      }
    }
  }
  /**
   * 取员工id
   * @return
   */
  public Integer getUserId() {
    String userAccount = contextManager.getContext().getStringFcpHeader(FcpHeader.FcpHeaderType.USER_INFO);
    if(userAccount == null) {
      throw new IllegalArgumentException("Full employeeId is null");
    } else {
      Matcher m = EMPLOYEE_ID.matcher(userAccount);
      if(!m.find()) {
        throw new IllegalArgumentException("Unsupported full employeeId:" + userAccount);
      } else {
        return Integer.parseInt(m.group(2));
      }
    }
  }
}
