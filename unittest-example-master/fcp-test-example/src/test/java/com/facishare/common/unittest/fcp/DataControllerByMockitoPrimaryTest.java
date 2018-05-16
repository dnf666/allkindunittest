package com.facishare.common.unittest.fcp;

import com.facishare.common.unittest.common.entity.Data;
import com.facishare.common.unittest.fcp.arg.FindDataArg;
import com.facishare.common.unittest.fcp.common.FcpUtils;
import com.facishare.common.unittest.fcp.inter.IDataController;
import com.facishare.fcp.model.FcpServiceResult;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class DataControllerByMockitoPrimaryTest extends AbstractCommonTest {

  @Autowired
  FcpUtils fcpUtils;
  @Autowired
  IDataController dataController;

  @Test
  public void testGetData() {
    Mockito.when(fcpUtils.getEa())
        .thenReturn("fs");
    Mockito.when(fcpUtils.getEId())
        .thenReturn(1L);
    Mockito.when(fcpUtils.getUserId())
        .thenReturn(10000);

    FindDataArg data = new FindDataArg();
    FcpServiceResult result = dataController.findUseBeanById(data);
    Data resultData = (Data) result.getResult();
    assertEquals("fs", resultData.getEa());
    assertEquals(1L, resultData.getEId().longValue());
    assertEquals(10000, resultData.getUserId().intValue());
  }


}
