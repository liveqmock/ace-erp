package com.ace.erp.shiro.persistence;

import com.ace.erp.entity.sys.User;

import java.util.List;

/**
 * Created with smart-erp.
 * User: denghp
 * Date: 10/15/13
 * Time: 12:28 AM
 * Description:
 */
public interface UserMapper {

    int saveUser(User user);

    User getUserByName(String userName);

    User getUserByEmail(String email);

    int update(User user);

    User getByMobilePhoneNumber(String mobilePhoneNumber);

    User getUserById(Integer userId);

    int delete(Integer userId);

    List<User> getAllUsers();

    int getAllCount();
}