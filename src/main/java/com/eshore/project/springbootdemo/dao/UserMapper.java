package com.eshore.project.springbootdemo.dao;

import com.eshore.project.springbootdemo.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lixinxin
 * @since 2020-01-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> getUsers();
}
