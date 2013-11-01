/**
 * Copyright (c) 2009-2015 http://demi-panda.com
 *
 * Licensed 
 */
package com.ace.erp.service.sys;

import com.ace.erp.BaseTest;
import com.ace.erp.annotation.BaseComponent;
import com.ace.erp.shiro.persistence.PermissionMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created with ace.
 * User: denghp
 * Date: 11/1/13
 * Time: 10:53 PM
 */
public class PermissionServiceTest<M extends Serializable> extends BaseTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void getCountTest() {
        System.out.println(permissionService.count());
    }
}
