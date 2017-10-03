package com.jessie.databinding.study.mvpvm.dto;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * @author JessieKate
 * @date 01/10/2017
 * @email lyj1246505807@gmail.com
 * @describe 用户登录dto
 */

public class User extends BaseObservable {
    public ObservableField<String> username=new ObservableField<>();
    public ObservableField<String> password=new ObservableField<>();
    public ObservableInt usernamePass=new ObservableInt();
    public ObservableInt passwordPass=new ObservableInt();
}
