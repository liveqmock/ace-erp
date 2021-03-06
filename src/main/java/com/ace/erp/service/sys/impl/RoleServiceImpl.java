/**
 * Copyright (c) 2009-2015 http://demi-panda.com
 *
 * Licensed 
 */
package com.ace.erp.service.sys.impl;

import com.ace.erp.annotation.BaseComponent;
import com.ace.erp.entity.sys.Role;
import com.ace.erp.entity.sys.RoleResourcePermission;
import com.ace.erp.exception.AceException;
import com.ace.erp.persistence.sys.RoleMapper;
import com.ace.erp.persistence.sys.RoleResourcePermissionMapper;
import com.ace.erp.service.sys.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with ace.
 * User: denghp
 * Date: 11/25/13
 * Time: 10:36 PM
 */
public class RoleServiceImpl extends AbstractService<Role, Integer> implements RoleService {

    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    @BaseComponent
    private RoleMapper roleMapper;

    @Autowired
    private RoleResourcePermissionMapper rrpMapper;

    public List<RoleResourcePermission> getRoleResourcePermissions(Integer roleId) {
        List<Role> roles = roleMapper.getRoleResourcePermissions(roleId);
        if (roles != null && roles.size() > 0) {
            return roles.get(0).getResourcePermissions();
        }
        return null;
    }

    public Map<Integer, RoleResourcePermission> getRoleResourceMaps(Integer roleId) {
        List<Role> roles = roleMapper.getRoleResourcePermissions(roleId);
        Map<Integer, RoleResourcePermission> rrpMaps = new HashMap<Integer, RoleResourcePermission>();
        if (roles != null && roles.size() > 0) {
            List<RoleResourcePermission> rrpList = roles.get(0).getResourcePermissions();
            for (RoleResourcePermission rrp : rrpList) {
                rrpMaps.put(rrp.getResourceId(), rrp);
            }
        }
        return rrpMaps;
    }

    public List<Role> findShowRoles(String roleIds) {
        if (StringUtils.isBlank(roleIds)) {
            logger.info("roleIds is empty!");
            return null;
        }
        String[] roles = roleIds.split(",");
        List<Integer> integerList = new ArrayList<Integer>();
        for (String roleId : roles) {
            integerList.add(Integer.valueOf(roleId));
        }

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleIds", integerList);
        return roleMapper.getListRolesByRoleIds(params);
    }

    public List<Role> getAllRoles(boolean isAdmin) {
        if (isAdmin) {
            return roleMapper.getAllRoles();
        }
        return roleMapper.getCommonRoles();
    }


    public void updateWithResourcePermission(Integer[] resourceIds, Role role) throws AceException {
        if (role == null || role.getId() == null || resourceIds == null
                && resourceIds.length <= 0) {
            logger.warn("updateWithResourcePermission failed, this params invalid");
            return;
        }

        try {
            //更新角色信息
            roleMapper.update(role);
            //删除当前role对应的所有资源信息
            rrpMapper.deleteRRPByRoleId(role.getId());
            for (Integer resourceId : resourceIds) {
                if (resourceId != null) {
                    RoleResourcePermission rrp = new RoleResourcePermission(role.getId(), resourceId, "1");
                    rrpMapper.save(rrp);
                }
            }
        } catch (Exception ex) {
            logger.error("updateWithResourcePermission error , {}", ex);
            throw AceException.create(AceException.Code.SYSTEM_ERROR, "UpdateWithResourcePermission failed!");
        }

    }

    /**
     * 根据当前角色获取对应的所有资源
     *
     * @param roleId
     * @return
     */
    public Map<String, RoleResourcePermission> getMapRRPSByRoleId(int roleId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleId", roleId);
        //params.put("resourceIds",resourceIds);
        List<RoleResourcePermission> rrpList = rrpMapper.getRRPListByRId(roleId);
        Map<String, RoleResourcePermission> rrpMaps = new HashMap<String, RoleResourcePermission>();
        for (RoleResourcePermission rrp : rrpList) {
            rrpMaps.put(rrp.getRoleId() + "_" + rrp.getResourceId(), rrp);
        }
        return rrpMaps;
    }


}
