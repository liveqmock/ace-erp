package com.ace.erp.shiro.persistence;

import com.ace.erp.common.mybatis.BaseMapper;
import com.ace.erp.entity.sys.Role;
import com.ace.erp.entity.sys.RoleResourcePermission;

import java.util.List;
import java.util.Map;

/**
 * Project_Name: smart-erp
 * File: RoleMapper
 * User: denghp
 * Date: 10/15/13
 * Time: 10:13 AM
 * Description:
 */
public interface RoleMapper extends BaseMapper<Role,Integer> {


    /**
     * 根据 roleId获取相关的ResourcePermission
     * @param roleId
     * @return List<RoleResourcePermission>
     */
    public List<RoleResourcePermission> getResourcePermissions(Long roleId);

    /**
     * 根据角色ID获取角色列表
     * @param params
     * @return
     */
    public List<Role> getListRolesByRoleIds(Map<String, Object> params);


    /**
     * 获取所有的角色
     * @return
     */
    public List<Role> getAllRoles();


}
