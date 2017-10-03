package com.jessie.databinding.study.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jessie.databinding.study.R;

/**
 * @author JessieKate
 * @date 27/09/2017
 * @email lyj1246505807@gmail.com
 * @describe 测试recyclerview的动态绑定
 */

public class RecyclerviewActivity  extends AppCompatActivity {
    private RecyclerView recyclerView;

    private ListAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerView= (RecyclerView) this.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ListAdapter();

        recyclerView.setAdapter(adapter);
    }
}
