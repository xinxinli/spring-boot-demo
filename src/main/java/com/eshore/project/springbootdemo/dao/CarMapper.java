package com.eshore.project.springbootdemo.dao;

import com.eshore.project.springbootdemo.entity.Car;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lixinxin
 * @since 2020-01-03
 */
@Mapper
public interface CarMapper extends BaseMapper<Car> {

}
