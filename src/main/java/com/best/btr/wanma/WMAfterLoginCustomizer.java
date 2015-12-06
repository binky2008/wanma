package com.best.btr.wanma;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.best.btr.wanma.bas.entity.Employee;
import com.best.btr.wanma.bas.service.EmployeeService;
import com.best.btr.wanma.system.entity.Site;
import com.best.btr.wanma.system.service.SystemService;
import com.jinhe.tss.framework.Global;
import com.jinhe.tss.framework.component.param.Param;
import com.jinhe.tss.framework.sso.Environment;
import com.jinhe.tss.framework.sso.ILoginCustomizer;
import com.jinhe.tss.framework.sso.SSOConstants;
import com.jinhe.tss.framework.sso.context.Context;
import com.jinhe.tss.um.permission.PermissionService;
import com.jinhe.tss.util.EasyUtils;

public class WMAfterLoginCustomizer implements ILoginCustomizer {
	
	// 万马网点固定角色一览
	static Long ROLE_0 = 32L; // 基础角色
	static Long ROLE_1 = 57L; // 财务
	static Long ROLE_2 = 58L; // 客服
	static Long ROLE_3 = 59L; // 物流专员
	static Long ROLE_4 = 60L; // 职业经理
	static Long ROLE_5 = 61L; // 网点
	static Long ROLE_6 = 62L; // 网点承包区
	
	PermissionService permissionService = (PermissionService) Global.getBean("PermissionService");
	EmployeeService employeeService = (EmployeeService) Global.getBean("EmployeeService");
	SystemService systemService = (SystemService) Global.getBean("SystemService");

	public void execute() {
		HttpSession session = Context.getRequestContext().getSession();
		Object fromUserId = Environment.getUserInfo("fromUserId");
		Object employeeNo = Environment.getUserInfo("employeeNo"); // 网点编号User里，employeeNo记录了网点ID信息
		Long logonUserId = Environment.getUserId();
		
		List<Object[]> userRoles = new ArrayList<Object[]>();
		@SuppressWarnings("unchecked")
		List<Long> roleIds = (List<Long>) session.getAttribute(SSOConstants.USER_RIGHTS_IN_SESSION);
		if(roleIds == null) {
			roleIds = new ArrayList<Long>();
		}
		for(Long roleId : roleIds) {
			userRoles.add( new Object[] { logonUserId, roleId } );
		}
		
		if(fromUserId != null) {
			Long employeeId = EasyUtils.obj2Long(fromUserId);
			Employee employee = employeeService.getEntityById(employeeId);
			if(employee != null) {
				Param position = employee.getPosition();
				String positionName = position.getText();

				if(positionName.indexOf("财务") >= 0) {
					userRoles.add( new Object[] { logonUserId, ROLE_1 } );
					roleIds.add(ROLE_1);
				}
				if(positionName.indexOf("客服") >= 0) {
					userRoles.add( new Object[] { logonUserId, ROLE_2 } );
					roleIds.add(ROLE_2);
				}
				if(positionName.indexOf("物流专员") >= 0) {
					userRoles.add( new Object[] { logonUserId, ROLE_3 } );
					roleIds.add(ROLE_3);
				}
				if(positionName.indexOf("职业经理") >= 0) {
					userRoles.add( new Object[] { logonUserId, ROLE_4 } );
					roleIds.add(ROLE_4);
				}
				
				// 读取登陆用户的所属站点、分拨等信息，存放到seesion中
		        Site site = employee.getOwnerSite();
		        session.setAttribute("SITE_INFO", site);
		        session.setAttribute("CENTER_INFO", systemService.getCenterBySite(site));
			}
			else if(employeeNo != null) { // 网点编号登录
				Long siteId = EasyUtils.obj2Long(employeeNo);
				
				Site site = (Site) systemService.getEntity(Site.class, siteId);
				if(site != null) {
					session.setAttribute("SITE_INFO", site);
					session.setAttribute("CENTER_INFO", systemService.getCenterBySite(site));
					
					if( site.isBestSite() ) {
						userRoles.add( new Object[] { logonUserId, ROLE_5 } );
						roleIds.add(ROLE_5);
					}
					else {
						userRoles.add( new Object[] { logonUserId, ROLE_6 } );
						roleIds.add(ROLE_6);
					}
				}
				
				// TODO 二级承包区账户登录处理，如何判断？ 也是从V5同步过来
			}
		}
		
		// 保存到用户权限（拥有的角色）对应表
		userRoles.add( new Object[] { logonUserId, ROLE_0 } ); // 基础角色
        permissionService.saveUserRolesAfterLogin(userRoles, logonUserId);
        
        roleIds.add(ROLE_0);
        session.setAttribute(SSOConstants.USER_RIGHTS_IN_SESSION, roleIds);
	}

}
