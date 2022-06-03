package com.dream.mybaijia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dream.mybaijia.entity.Admin;
import com.dream.mybaijia.mapper.AdminMapper;
import com.dream.mybaijia.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author arthus
 * @since 2022-06-02
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin queryAdminByUsername(String username) {

        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);

        Admin admin = adminMapper.selectOne(queryWrapper);

        return admin;
    }
}
