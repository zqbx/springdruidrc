package com.zqbx.service;

import com.zqbx.domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:spring-context.xml"))
public class TestCity{
    private static  final Logger logger = LoggerFactory.getLogger(TestCity.class);
    @Resource
    private CityService cityService;

    @Test
    public void getCity() throws Exception {
        City c = cityService.getCityByCode("01");
        System.out.println(c.getName());
        logger.info("TestCity.getCity()");
    }
}
