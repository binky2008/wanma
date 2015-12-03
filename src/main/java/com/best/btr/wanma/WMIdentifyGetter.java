package com.best.btr.wanma;

import com.jinhe.tss.framework.sso.IPWDOperator;
import com.jinhe.tss.framework.sso.IdentityGetter;
import com.jinhe.tss.um.sso.UMIdentityGetter;
 
public class WMIdentifyGetter extends UMIdentityGetter implements IdentityGetter {
    
    /**
     * 判断用户输入的密码是否和第三方系统（V5）密码的一致，如果是，则将用户当前的密码也设置为该密码。
     * 
     * @param operator
     * @param password
     * @return
     */
    public boolean indentify(IPWDOperator operator, String password) {
        log.debug("用户登陆时密码在主用户组中验证不通过，转向WMS进行再次验证。");
        
        String loginName = operator.getLoginName();
        Long userId = loginInV5(loginName, password);
 
        if(userId != null) {
            log.debug("用户【" + loginName + "】的密码在V5中验证通过。");
            return true; // 如果连接成功则返回True
        } 
        else {
            log.warn("用户【" + loginName + "】的密码在V5中验证不通过。");
            return false;
        } 
    }
    
    private Long loginInV5(String loginName, String password) {
    	return null;
    }
}
