package com.jessie.databinding.study.base;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import com.jessie.databinding.study.R;
import com.jessie.databinding.study.databinding.ActivityMainBinding;
import com.jessie.databinding.study.databinding.ViewStubBinding;
import com.jessie.databinding.study.base.dto.TestNormalDto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main);
        TestNormalDto testNormalDto = new TestNormalDto("fei", "Liang" ,"sss");
        binding.setTestNormalDto(testNormalDto);
        binding.setMyStr("测试字符串变量");
        binding.setMyFloat(12.3f);
        binding.setMyDouble(12.4);
        binding.setMyInt(10);
        binding.setGoodsName("T-shirt");
        binding.setPrice(15);
        binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                ViewStubBinding binding = DataBindingUtil.bind(inflated);
                binding.setViewStubTag("这是inflate的布局");
            }
        });

        inflateViewStub(binding);
        binding.setIncludeTag("这是include的内容");

        binding.setIsNormal(false);
        binding.setHeight(400);
        binding.setTime(new Date());
    }

    public void inflateViewStub(ActivityMainBinding binding) {
        if (!binding.viewStub.isInflated()) {
            binding.viewStub.getViewStub().inflate();
        }
    }


    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(date!=null){
            return sdf.format(date);
        }else{
            return "";
        }

    }

    @BindingAdapter("custom")
    public static void setCustom(TextView textView, float height) {
        ViewGroup.LayoutParams params = textView.getLayoutParams();
        params.height = (int) height;
        textView.setLayoutParams(params);
    }
}
