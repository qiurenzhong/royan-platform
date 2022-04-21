package com.royan.framework.core.domain;

import com.royan.framework.api.model.ClientInfo;
import com.royan.framework.api.model.UserInfo;
import lombok.Data;

/**
 * @author Qiurz
 * @date 2021/7/26
 */
@Data
public class Context {

    private String userId;
    private String userName;
    private String permissionId;
    private String ipAddress;
    private String traceId;
    private String menuId;
    private String buttonId;
    private String sessionId;
    private UserInfo userInfo;
    private ClientInfo clientInfo;
    private Boolean exportFlag = false;
    private String deviceType;
    private String grayFlag;


    public UserInfo getUserInfo(){
        if (this.userInfo == null){
            this.userInfo = new UserInfo();
        }
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo){
        this.userInfo = userInfo;
        if (this.userInfo != null){
            this.userId = this.userInfo.getUserId();
        }
    }


    public ClientInfo getClientInfo(){
        if (this.clientInfo == null){
            this.clientInfo = new ClientInfo();
        }
        return this.clientInfo;
    }


    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

}
