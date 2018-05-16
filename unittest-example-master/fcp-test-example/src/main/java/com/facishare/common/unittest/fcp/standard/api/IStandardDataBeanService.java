package com.facishare.common.unittest.fcp.standard.api;

import com.facishare.common.unittest.common.entity.Data;

/**
 * 数据源服务对外接口
 * Created by wangyuebin on 16/7/4.
 */
public interface IStandardDataBeanService {

  /**
   * 创建数据源
   * @param id 需要创建的数据源对象
   * @return
   */
  Data find(String id, String ea,long eid, int userid);
}
