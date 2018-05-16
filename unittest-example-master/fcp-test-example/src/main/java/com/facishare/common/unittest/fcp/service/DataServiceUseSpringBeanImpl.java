package com.facishare.common.unittest.fcp.service;

import com.facishare.common.unittest.fcp.api.IDataBeanService;
import com.facishare.common.unittest.fcp.common.FcpUtils;
import com.facishare.common.unittest.common.entity.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * IDataStoreService 实现类
 * Created by wangyuebin on 16/7/5.
 */
@Service
public class DataServiceUseSpringBeanImpl implements IDataBeanService {
  @Autowired
  FcpUtils fcpUtil;
  @Override
  public Data find(String id) {
    return Data.builder().Ea(fcpUtil.getEa()).EId(fcpUtil.getEId()).userId(fcpUtil.getUserId()).build();
  }
}
