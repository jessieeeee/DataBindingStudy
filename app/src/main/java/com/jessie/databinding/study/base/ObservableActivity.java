package com.jessie.databinding.study.base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.jessie.databinding.study.R;
import com.jessie.databinding.study.databinding.ActivityObervableBinding;
import com.jessie.databinding.study.base.dto.ObservableBean;
import com.jessie.databinding.study.base.dto.ObservableImpBean;
import com.jessie.databinding.study.base.dto.ObservableObject;

import static android.content.ContentValues.TAG;

/**
 * @author JessieKate
 * @date 30/09/2017
 * @email lyj1246505807@gmail.com
 * @describe 测试Observable的activity
 */

public class ObservableActivity extends Activity {
    private ObservableBean observableBean;
    private ObservableImpBean observableImpBean;
    private ObservableObject observableObject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        observableBean=new ObservableBean();
        observableBean.setTest1("测试数据1");

        ActivityObervableBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_obervable);
        binding.setObservableBean(observableBean);
        EditText editObservable=findViewById(R.id.editObservable);
        editObservable.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d(TAG, "afterTextChanged: "+observableBean.getTest1());
            }
        });



        observableImpBean=new ObservableImpBean();
        observableImpBean.setTest1("测试数据2");

        binding.setObservableImpBean(observableImpBean);
        EditText editObservable1=findViewById(R.id.editObservable1);
        editObservable1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d(TAG, "afterTextChanged: "+observableImpBean.getTest1());
            }
        });

        observableObject=new ObservableObject();

//        Bean bean=new Bean("测试响应式对象",1);
//        observableObject.beanField.set(bean);
        observableObject.test1.set("测试响应式对象");
        observableObject.myInt.set(2);
        binding.setObservableObject(observableObject);

        EditText editObservable2=findViewById(R.id.editObservable2);
        editObservable2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
//                Log.d(TAG, "afterTextChanged: "+observableObject.beanField.get().getName());
                Log.d(TAG, "afterTextChanged: "+observableObject.test1.get());

            }
        });
    }
}
