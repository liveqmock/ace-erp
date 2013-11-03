package com.ace.erp.shiro.persistence;

import com.ace.erp.common.mybatis.BaseMapper;
import com.ace.erp.entity.sys.Resource;

import java.util.List;
import java.util.Map;

/**
 * Project_Name: smart-erp
 * File: ResourceMapper
 * (C) Copyright tuan800 Corporation 2013 All Rights Reserved.
 * User: denghp
 * Date: 10/16/13
 * Time: 2:32 PM
 * Description:
 */
public interface ResourceMapper extends BaseMapper<Resource, Integer> {


    public List<Resource> getAllWithSort(Map<String,Object> params);

}
