package com.facishare.common.unittest.groovy.junit

import com.facishare.appserver.utils.FcpUtils
import com.facishare.common.unittest.common.entity.Data
import com.facishare.common.unittest.fcp.arg.FindDataArg
import com.facishare.common.unittest.fcp.inter.IDataController
import com.facishare.fcp.model.FcpServiceResult
import mockit.Mock
import mockit.MockUp
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: wujp@fxiaoke.com
 * Date: 16/8/25
 * Time: 上午10:55
 */
class JUnitFcpJMockitTest extends JUnitTestCommon{

    @Autowired
    IDataController dataController;

    @Test
    public void testGetData() {
        new MockUp<FcpUtils>() {

            @Mock
            public String getEa() {
                return "fs";
            }
            @Mock
            public Long getEId() {
                return 1L;
            }

            @Mock
            public Integer getUserId() {
                return 10000;
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
