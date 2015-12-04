package com.best.btr.wanma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jinhe.dm.DMConstants;
import com.jinhe.dm.data.sqlquery.SQLExcutor;
import com.jinhe.tss.framework.sso.IPWDOperator;
import com.jinhe.tss.framework.sso.IdentityGetter;
import com.jinhe.tss.um.sso.UMIdentityGetter;
import com.jinhe.tss.util.EasyUtils;
import com.jinhe.tss.util.InfoEncoder;
 
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
    
    // 直接同步过来的密码 dac087c9549d22b73f7598e93c558e04
    private Long loginInV5(String loginName, String password) {
    	String script = "select id from um_user t where loginName = ? and passwor = ?";

        Map<Integer, Object> params = new HashMap<Integer, Object>();
        params.put(1, loginName);
        params.put(2, InfoEncoder.string2MD5(password).toLowerCase());

        List<Map<String, Object>> result = SQLExcutor.query(DMConstants.LOCAL_CONN_POOL, script, params);

        if (result.isEmpty()) {
            return null;
        }

        return EasyUtils.obj2Long(result.get(0).get("id"));
    }
    
//    public static void main(String[] args) {
//    	System.out.println(InfoEncoder.string2MD5("800best").toLowerCase());
//    }
}
