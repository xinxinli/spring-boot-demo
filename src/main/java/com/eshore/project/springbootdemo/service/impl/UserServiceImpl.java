package com.eshore.project.springbootdemo.service.impl;

import com.eshore.project.springbootdemo.entity.User;
import com.eshore.project.springbootdemo.dao.UserMapper;
import com.eshore.project.springbootdemo.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lixinxin
 * @since 2020-01-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
