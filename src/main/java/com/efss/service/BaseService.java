package com.efss.service;


import com.efss.entity.user.Principal;

public class BaseService {

	/**
	 * 数据范围过滤
	 * @param areaAlias 区域表别名
	 * @param userAlias 用户表别名
	 * 
	 */
	// 进行权限过滤，多个角色权限范围之间为或者关系。
	public static String dataScopeFilter(Principal user, String areaAlias, String userAlias) {
		StringBuilder sqlString = new StringBuilder();
		// 超级管理员，跳过数据权限过滤 
		if (!"13811765771".equals(user.getPhone())){
			//不是超级管理员
			//如果给用户的权限是公司
			if(Principal.DATA_SCOPE_OFFICE.equals(user.getDateScope())){
				sqlString.append(userAlias +".officeid = '" + user.getOfficeid() + "'");				
			}else if(Principal.DATA_SCOPE_PROVINCES.equals(user.getDateScope())){//省份
				sqlString.append(areaAlias+".parent_ids LIKE '" + user.getProvincesid() + ",%'");
			}else if(Principal.DATA_SCOPE_DEPARTMENT.equals(user.getDateScope())){//部门
				sqlString.append(areaAlias+".parent_ids LIKE '" + user.getDepartmentid() + ",%'");
			}else if(Principal.DATA_SCOPE_REGION.equals(user.getDateScope())){//区域
				sqlString.append(areaAlias+".parent_ids LIKE '" + user.getRegionid() + ",%'");
			}else if(Principal.DATA_SCOPE_STOREFRONT.equals(user.getDateScope())){//店面
				sqlString.append(areaAlias+".parent_ids LIKE '" + user.getStorefrontid() + ",%'");
			}else if(Principal.DATA_SCOPE_POSITION.equals(user.getDateScope())){//职位
				sqlString.append(areaAlias+".parent_ids LIKE '" + user.getPosioionid() + ",%'");
			}else if(Principal.DATA_SCOPE_ONESELF.equals(user.getDateScope())){//仅本人
				sqlString.append(userAlias +".userid = '" + user.getId() + "'");
			}
			
		}
		return sqlString.toString();
	}
}
