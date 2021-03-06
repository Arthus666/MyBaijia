package com.dream.mybaijia.service;

import com.dream.mybaijia.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author arthus
 * @since 2022-06-02
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 通过用户名查询管理员
     * @param username
     * @return
     */
    Admin queryAdminByUsername(String username);

}
