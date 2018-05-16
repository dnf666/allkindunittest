package com.facishare.common.unittest.fcp.common;

import com.facishare.fcp.model.BaseFcpServiceResult;
import com.facishare.fcp.model.FcpServiceResult;

import org.springframework.stereotype.Service;

/**
 * Created by wujp@fxiaoke.com on 16/8/25.
 * This class is use for Spring
 */
@Service
public class FcpUtils {

  public FcpServiceResult buildFcpServiceResult(Object fcpResult, int status, String message,
                                                Throwable throwable) {
    BaseFcpServiceResult baseFcpServiceResult = new BaseFcpServiceResult();
    baseFcpServiceResult.setResult(fcpResult);
    baseFcpServiceResult.setErrorCode(status);
    baseFcpServiceResult.setErrorMessage(message);
    baseFcpServiceResult.setThrowable(throwable);
    baseFcpServiceResult.setTraceError(false);
    return baseFcpServiceResult;
  }

  public String getEa() {
    return com.facishare.appserver.utils.FcpUtils.getEa();
  }

  public Long getEId() {
    return com.facishare.appserver.utils.FcpUtils.getEId();
  }

  public Integer getUserId() {
    return com.facishare.appserver.utils.FcpUtils.getUserId();
  }

}
