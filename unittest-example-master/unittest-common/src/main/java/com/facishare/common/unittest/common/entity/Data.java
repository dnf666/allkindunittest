package com.facishare.common.unittest.common.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * fcp 请求返回结果
 * Created by wujp@fxiaoke.com on 16/8/24.
 */
@lombok.Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Data implements Serializable {

  private Integer userId;
  private String Ea;
  private Long EId;
}
