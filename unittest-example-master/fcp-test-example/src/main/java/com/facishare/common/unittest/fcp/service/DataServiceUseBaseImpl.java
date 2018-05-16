package com.facishare.common.unittest.fcp.service;

import com.facishare.common.unittest.common.entity.Data;
import com.facishare.common.unittest.fcp.api.IDataBaseImplService;

import org.springframework.stereotype.Service;

/**
 * IDataStoreService 实现类
 * Created by wangyuebin on 16/7/5.
 */
@Service
public class DataServiceUseBaseImpl extends BaseImpl implements IDataBaseImplService {

  @Override
  public Data find(String id) {
    return Data.builder().Ea(getEa()).EId(getEId()).userId(getUserId()).build();
  }
}
