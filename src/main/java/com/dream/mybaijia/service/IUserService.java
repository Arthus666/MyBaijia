package com.dream.mybaijia.service;

import com.dream.mybaijia.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author arthus
 * @since 2022-06-02
 */
public interface IUserService extends IService<User> {

    /**
     * 用户名查找用户
     * @param user
     * @return
     */
    User queryUserByUsername(String user);

    List<User> getUsers();

}
