package com.ssm.promotion.core.service;

import java.util.List;
import java.util.Map;

import com.ssm.promotion.core.entity.User;


public interface UserService {

    /**
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * @param map
     * @return
     */
    public List<User> findUser(Map<String, Object> map);

    /**
     * @param map
     * @return
     */
    public Long getTotalUser(Map<String, Object> map);

    /**
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * @param id
     * @return
     */
    public int deleteUser(Integer id);
    
    /**
     * 根据用户名获取用户（仅在登录时用到）
     * @param userName
     * @return
     */
    public User getUserByName(String userName);
    
    /**
     * 根据id获取用户
     * @param uuid
     * @return
     */
    public User getUserById(Integer id);
    
    /**
     * 根据唯一ID获取用户
     * @param uuid
     * @return
     */
    User getUserByUUID(String uuid);
}
