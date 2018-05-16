package com.facishare.common.unittest.fcp.standard.impl;

import com.facishare.common.unittest.common.entity.Data;
import com.facishare.common.unittest.fcp.arg.FindDataArg;
import com.facishare.common.unittest.fcp.common.FcpBaseAction;
import com.facishare.common.unittest.fcp.common.FcpUtils;
import com.facishare.common.unittest.fcp.standard.api.IStandardDataBeanService;
import com.facishare.common.unittest.fcp.standard.inter.IStandardDataController;
import com.facishare.fcp.model.FcpServiceResult;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by wujp@fxiaoke.com on 16/8/24.
 */
@Slf4j
@Service
public class StandardDataFcpController extends FcpBaseAction implements IStandardDataController {

    @Resource
    IStandardDataBeanService standardDataBeanService;

    @Override
    public FcpServiceResult findUseBeanById(FindDataArg arg) {
            Data result = standardDataBeanService.find("test", getEa(),getEID(),getUserId());
        return new FcpUtils()
            .buildFcpServiceResult(result, 10000, "Error Message", null);
    }
}
