package com.facishare.common.unittest.fcp;

import com.facishare.appserver.utils.FcpUtils;
import com.facishare.common.unittest.fcp.arg.FindDataArg;
import com.facishare.common.unittest.common.entity.Data;
import com.facishare.common.unittest.fcp.inter.IDataController;
import com.facishare.fcp.model.FcpServiceResult;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import mockit.Expectations;

public class DataControllerByJMockitTest extends AbstractCommonTest {

  @Autowired
  IDataController dataController;

  @Test
  public void testGetData() {
    new Expectations(FcpUtils.class) {
      {
        FcpUtils.getEa();
        result = "fs";
        FcpUtils.getEId();
        result = 1L;
        FcpUtils.getUserId();
        result = 10000;
      }
    };

    FindDataArg data = new FindDataArg();
    FcpServiceResult result = dataController.findUseStaticById(data);
    Data resultData = (Data) result.getResult();
    assertEquals("fs", resultData.getEa());
    assertEquals(1L, resultData.getEId().longValue());
    assertEquals(10000, resultData.getUserId().intValue());
  }

}
