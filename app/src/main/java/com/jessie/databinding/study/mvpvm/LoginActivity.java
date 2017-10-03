package com.jessie.databinding.study.mvpvm;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.jessie.databinding.study.R;
import com.jessie.databinding.study.databinding.ActivityLoginBinding;
import com.jessie.databinding.study.mvpvm.dto.User;

/**
 * @author JessieKate
 * @date 01/10/2017
 * @email lyj1246505807@gmail.com
 * @describe 登录界面
 */

public class LoginActivity extends AppCompatActivity implements ILoginView{

    private static final String TAG = "LoginActivity";
    private LoginPresenter loginPresenter;
    EditText et_username,et_password;
    TextInputLayout usernameInput;
    TextInputLayout passwordInput;
    User user;
    ActivityLoginBinding activityLoginBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login);

        loginPresenter=new LoginPresenter(this);
        user=loginPresenter.getUser();
        //初始化binding
        activityLoginBinding.setUser(user);
        et_username= (EditText) findViewById(R.id.et_username);
        et_password= (EditText) findViewById(R.id.et_password);
        usernameInput = (TextInputLayout) findViewById(R.id.usernameInput);
        passwordInput = (TextInputLayout) findViewById(R.id.passwordInput);
        et_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                loginPresenter.checkUserName();
            }
        });

        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d(TAG, "afterTextChanged: "+user.password.get());
                loginPresenter.checkPassword();
            }
        });
    }


    //登录按钮点击回调
    public void onLoginClick(View view) {
        hideKeyboard();

        loginPresenter.login();
    }

    public void hideKeyboard(){
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @BindingAdapter("onUsernameChange")
    public static void setOnUsernameChange(TextInputLayout usernameInput, int result) {
        if(result==0 || result==1){
            usernameInput.setErrorEnabled(false);
        }
        else{
            usernameInput.setError("用户名无效!");
        }
    }


    @BindingAdapter("onPasswordChange")
    public static void setOnPasswordChange(TextInputLayout passwordInput, int result) {
        if(result==0 || result==1){
            passwordInput.setErrorEnabled(false);
        }else{
            passwordInput.setError("密码无效!");

        }
    }

    @Override
    public void onLoginResult(boolean result) {
        if(result){
            Toast.makeText(this,"登录成功！",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"登录失败！",Toast.LENGTH_SHORT).show();
        }
    }

}
