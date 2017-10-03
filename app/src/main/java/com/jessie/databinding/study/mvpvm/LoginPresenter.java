package com.jessie.databinding.study.mvpvm;

import android.text.TextUtils;

import com.jessie.databinding.study.mvpvm.dto.User;

/**
 * @author JessieKate
 * @date 09/09/2017
 * @email lyj1246505807@gmail.com
 * @describe P层实现
 */

public class LoginPresenter {

    private ILoginModel iLoginModel;
    private ILoginView iLoginView;
    private User user;
    public LoginPresenter(ILoginView iLoginView){
        iLoginModel = new LoginModel();
        //初始化响应式对象
        user=new User();
        this.iLoginView=iLoginView;
    }

    public User getUser(){
        return user;
    }
    public void checkPassword(){
        //用户名输入框已输入
        if(!TextUtils.isEmpty(user.password.get())){
            if (iLoginModel.checkPassword(user.password.get())) {
                user.passwordPass.set(1);
            }else{
                user.passwordPass.set(2);
            }
//            iLoginView.refresh();
        }else{
            user.passwordPass.set(0);
        }
    }

    public void checkUserName(){
        //密码输入框已输入
        if(!TextUtils.isEmpty(user.username.get())){
            if(iLoginModel.checkUserName(user.username.get())){
                user.usernamePass.set(1);
            }else{
                user.usernamePass.set(2);
            }

        }else{
            user.usernamePass.set(0);
        }

    }

    public void login(){
        if(iLoginModel.login(user.username.get(),user.password.get())){
            iLoginView.onLoginResult(true);
        }else{
            iLoginView.onLoginResult(false);
        }
    }
}
