package com.jessie.databinding.study.base.dto;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * @author JessieKate
 * @date 30/09/2017
 * @email lyj1246505807@gmail.com
 * @describe 响应式对象bean类
 */

public class ObservableObject {
    public final ObservableInt myInt = new ObservableInt();
    public final ObservableField<String> test1 = new ObservableField<>();
}
