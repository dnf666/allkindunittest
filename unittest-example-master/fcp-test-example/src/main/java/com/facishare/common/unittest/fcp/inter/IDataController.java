package com.facishare.common.unittest.fcp.inter;

import com.facishare.common.unittest.fcp.arg.FindDataArg;
import com.facishare.fcp.annotation.FcpMethod;
import com.facishare.fcp.annotation.FcpService;
import com.facishare.fcp.model.FcpServiceResult;

/**
 * Created by wujp@fxiaoke.com on 16/8/24.
 */
@FcpService("data")
public interface IDataController {

    @FcpMethod("findById") FcpServiceResult findUseBeanById(FindDataArg arg);
    @FcpMethod("findById") FcpServiceResult findUseStaticById(FindDataArg arg);
    @FcpMethod("findById") FcpServiceResult findUseImplById(FindDataArg arg);



}
