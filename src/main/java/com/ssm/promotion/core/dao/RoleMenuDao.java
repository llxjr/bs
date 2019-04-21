package com.ssm.promotion.core.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.promotion.core.entity.RoleMenu;

@Repository
public interface RoleMenuDao {
	
	List<RoleMenu> findMenuByRoleId(Integer roleId);
	
	int insertBatch(List list);
	
	int deleteByRoleId(Integer roleId);
}
