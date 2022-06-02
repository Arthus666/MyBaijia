package com.dream.mybaijia.mapper;

import com.dream.mybaijia.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author arthus
 * @since 2022-06-02
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
