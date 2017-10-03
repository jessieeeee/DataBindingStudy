package com.jessie.databinding.study.base.dto;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

import com.jessie.databinding.study.BR;

/**
 * @author JessieKate
 * @date 30/09/2017
 * @email lyj1246505807@gmail.com
 * @describe 实现Observable接口的bean类
 */

public class ObservableImpBean implements Observable {

    private PropertyChangeRegistry registry =new PropertyChangeRegistry();
    private String test1;

    @Bindable
    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
        registry.notifyChange(this, BR.test1);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        registry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        registry.remove(callback);
    }
}
