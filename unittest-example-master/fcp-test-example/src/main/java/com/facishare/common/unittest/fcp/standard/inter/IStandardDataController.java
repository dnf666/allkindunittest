package com.facishare.common.unittest.fcp.standard.inter;

import com.facishare.common.unittest.fcp.arg.FindDataArg;
import com.facishare.fcp.annotation.FcpMethod;
import com.facishare.fcp.annotation.FcpService;
import com.facishare.fcp.model.FcpServiceResult;

/**
 * Created by wujp@fxiaoke.com on 16/8/24.
 */
@FcpService("data_s")
public interface IStandardDataController {

    @FcpMethod("findById") FcpServiceResult findUseBeanById(FindDataArg arg);



}
