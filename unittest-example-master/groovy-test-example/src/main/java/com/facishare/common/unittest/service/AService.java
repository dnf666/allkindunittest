package com.facishare.common.unittest.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * User: birdwyatt
 * Date: 16/8/24
 * Time: 下午12:06
 */
@Service
@Slf4j
public class AService {
  public boolean run(){
    return AServiceUtil.returnTrue();
  }
}
