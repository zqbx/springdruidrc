package com.zqbx.dao;

import com.zqbx.domain.City;

public interface CityMapper {
    int deleteByPrimaryKey(String code);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}