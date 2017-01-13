package com.zqbx.service.impl;

import com.zqbx.dao.CityMapper;
import com.zqbx.domain.City;
import com.zqbx.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * CityServiceImpl
 * cn.springmvc.service.impl
 *
 * @author xiaoyy
 * @description
 * @create 2016-11-30 上午11:23
 * The word 'impossible' is not in my dictionary.
 */

@Service("cityService")
public class CityServiceImpl implements CityService {
    @Resource
    private CityMapper cityMapper;

    public CityServiceImpl() {
    }

    public City getCityByCode(String code) {
        return this.cityMapper.selectByPrimaryKey(code);
    }
}
