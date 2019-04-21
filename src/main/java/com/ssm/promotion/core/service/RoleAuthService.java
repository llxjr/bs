package com.ssm.promotion.core.service;

import java.util.List;

import com.ssm.promotion.core.dto.RoleAuthParentMenuDTO;

public interface RoleAuthService {
	/**
	 * 获取授权菜单
	 * @return
	 */
	List<RoleAuthParentMenuDTO> findAuthMenus(Integer roleId);
	
	/**
	 * 更新授权菜单
	 */
	public boolean setAuthMenus(Integer roleId, List params);
}
