package com.facishare.common.unittest.fcp.service;

import com.facishare.appserver.utils.FcpUtils;
import com.facishare.fcp.biz.AuthInfo;

/**
 * Created by wujp@fxiaoke.com on 2016/8/25.
 */
public class BaseImpl {

    /**
     * 去员工账号
     * @return
     */
    public String getUserAccount(){
        return FcpUtils.getUserAccount();
    }

    /**
     * 取企业账号
     * @return
     */
    public String getEa(){
        return FcpUtils.getEa();
    }

    /**
     * 取企业Id
     * @return
     */
    public Long getEId(){
        return FcpUtils.getEId();
    }

    /**
     * 取员工id
     * @return
     */
    public Integer getUserId(){
        return FcpUtils.getUserId();
    }

    /**
     * 取客户端信息
     * @return
     */
    public String getClientVersion(){
        return FcpUtils.getClientVersion();
    }

    /**
     * 取用户整体信息
     * @return
     */
    public AuthInfo getAuthInfo(){
        return FcpUtils.getAuthInfo();
    }
}
