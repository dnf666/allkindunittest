package com.facishare.common.unittest.fcp.service;

import com.facishare.appserver.utils.FcpUtils;
import com.facishare.common.unittest.common.entity.Data;
import com.facishare.common.unittest.fcp.api.IDataStaticService;

import org.springframework.stereotype.Service;

/**
 * IDataStoreService 实现类
 * Created by wangyuebin on 16/7/5.
 */
@Service
public class DataServiceUseStaticImpl implements IDataStaticService {

  @Override
  public Data find(String id) {
    return Data.builder().Ea(FcpUtils.getEa()).EId(FcpUtils.getEId()).userId(FcpUtils.getUserId()).build();
  }
}
