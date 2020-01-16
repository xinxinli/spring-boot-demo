package com.eshore.project.springbootdemo.service.impl;

import com.eshore.project.springbootdemo.entity.Car;
import com.eshore.project.springbootdemo.dao.CarMapper;
import com.eshore.project.springbootdemo.service.ICarService;
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
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

}
