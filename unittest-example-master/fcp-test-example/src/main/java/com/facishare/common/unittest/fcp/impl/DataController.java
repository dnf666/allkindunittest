package com.facishare.common.unittest.fcp.impl;

import com.facishare.common.unittest.fcp.api.IDataBaseImplService;
import com.facishare.common.unittest.fcp.api.IDataBeanService;
import com.facishare.common.unittest.fcp.api.IDataStaticService;
import com.facishare.common.unittest.fcp.arg.FindDataArg;
import com.facishare.common.unittest.fcp.common.FcpUtils;
import com.facishare.common.unittest.common.entity.Data;
import com.facishare.common.unittest.fcp.inter.IDataController;
import com.facishare.fcp.model.FcpServiceResult;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by wujp@fxiaoke.com on 16/8/24.
 */
@Slf4j
@Service
public class DataController implements IDataController {

    @Resource
    IDataBeanService dataBeanService;
    @Resource
    IDataStaticService dataStaticService;
    @Resource
    IDataBaseImplService dataBaseImplService;

    @Override
    public FcpServiceResult findUseBeanById(FindDataArg arg) {
            Data result = dataBeanService.find("test");
        return new FcpUtils()
            .buildFcpServiceResult(result, 10000, "Error Message", null);
    }
    @Override
    public FcpServiceResult findUseStaticById(FindDataArg arg) {
        Data result = dataStaticService.find("test");
        return new FcpUtils()
            .buildFcpServiceResult(result, 10000, "Error Message", null);
    }

  @Override
  public FcpServiceResult findUseImplById(FindDataArg arg) {
    Data result = dataBaseImplService.find("test");
    return new FcpUtils()
        .buildFcpServiceResult(result, 10000, "Error Message", null);
  }
}
