package com.facishare.common.unittest.fcp;

import com.facishare.common.unittest.common.entity.Data;
import com.facishare.common.unittest.fcp.api.IDataBaseImplService;
import com.facishare.common.unittest.fcp.arg.FindDataArg;
import com.facishare.common.unittest.fcp.common.FcpUtils;
import com.facishare.common.unittest.fcp.inter.IDataController;
import com.facishare.common.unittest.fcp.service.DataServiceUseBaseImpl;
import com.facishare.fcp.model.FcpServiceResult;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class DataControllerByMockitoBaseImplTest extends AbstractCommonTest {

  @Autowired
  DataServiceUseBaseImpl dataServiceUseBaseImpl;
  @Autowired
  IDataController dataController;

  @Test
  public void testGetData() {
    Mockito.doReturn("fs").when(dataServiceUseBaseImpl).getEa();
    Mockito.doReturn(1L).when(dataServiceUseBaseImpl).getEId();
    Mockito.doReturn(10000).when(dataServiceUseBaseImpl).getUserId();

    FindDataArg data = new FindDataArg();
    FcpServiceResult result = dataController.findUseImplById(data);
    Data resultData = (Data) result.getResult();
    assertEquals("fs", resultData.getEa());
    assertEquals(1L, resultData.getEId().longValue());
    assertEquals(10000, resultData.getUserId().intValue());
  }


}
