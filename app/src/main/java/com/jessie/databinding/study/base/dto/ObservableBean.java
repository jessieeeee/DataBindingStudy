package com.jessie.databinding.study.base.dto;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.jessie.databinding.study.BR;

/**
 * @author JessieKate
 * @date 30/09/2017
 * @email lyj1246505807@gmail.com
 * @describe 测试Observable的bean类
 */

public class ObservableBean extends BaseObservable{
    private String test1;

    @Bindable
    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
        notifyPropertyChanged(BR.test1);
    }


}
