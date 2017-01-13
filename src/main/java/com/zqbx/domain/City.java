package com.zqbx.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/13.
 */
public class City implements Serializable{
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
