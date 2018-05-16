package com.facishare.common.unittest.fcp.standard.service;

import com.facishare.common.unittest.common.entity.Data;
import com.facishare.common.unittest.fcp.common.FcpUtils;
import com.facishare.common.unittest.fcp.standard.api.IStandardDataBeanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * IDataStoreService 实现类
 * Created by wangyuebin on 16/7/5.
 */
@Service
public class StandardDataServiceBeanImpl implements IStandardDataBeanService {
  @Autowired
  FcpUtils fcpUtil;
  @Override
  public Data find(String id, String ea,long eid, int userid) {
    return Data.builder().Ea(ea).EId(eid).userId(userid).build();
  }
}
