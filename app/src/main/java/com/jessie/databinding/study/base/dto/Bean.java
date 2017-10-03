package com.jessie.databinding.study.base.dto;

/**
 * @author JessieKate
 * @date 29/09/2017
 * @email lyj1246505807@gmail.com
 * @describe 测试的bean类
 */

public class Bean {
    private String name;
    private int position;

    public Bean(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
