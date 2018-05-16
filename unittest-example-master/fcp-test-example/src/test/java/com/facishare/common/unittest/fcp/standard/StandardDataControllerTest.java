package com.facishare.common.unittest.fcp.standard;

import com.facishare.common.unittest.common.entity.Data;
import com.facishare.common.unittest.fcp.AbstractCommonTest;
import com.facishare.common.unittest.fcp.arg.FindDataArg;
import com.facishare.common.unittest.fcp.common.FcpUtils;
import com.facishare.common.unittest.fcp.inter.IDataController;
import com.facishare.common.unittest.fcp.standard.impl.StandardDataFcpController;
import com.facishare.common.unittest.fcp.standard.inter.IStandardDataController;
import com.facishare.fcp.model.FcpServiceResult;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class StandardDataControllerTest extends FcpBaseTest {

  @Autowired
  IStandardDataController standardDataController;

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    ((StandardDataFcpController)standardDataController).setContextManager(this.contextManager);
  }

  @Test
  public void testGetData() {

    FindDataArg data = new FindDataArg();
    FcpServiceResult result = standardDataController.findUseBeanById(data);
    Data resultData = (Data) result.getResult();
    assertEquals("fs", resultData.getEa());
    assertEquals(1L, resultData.getEId().longValue());
    assertEquals(10000, resultData.getUserId().intValue());
  }


}
