package com.jessie.databinding.study.base;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jessie.databinding.study.R;
import com.jessie.databinding.study.databinding.BeanItemBinding;
import com.jessie.databinding.study.base.dto.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JessieKate
 * @date 29/09/2017
 * @email lyj1246505807@gmail.com
 * @describe 测试bindingdata动态绑定adapter
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {
    private static final int BEANS_COUNT = 10;

    @NonNull
    private List<Bean> beans;

    public ListAdapter() {
        beans = new ArrayList<>(10);
        for (int i = 0; i < BEANS_COUNT; i ++) {
            Bean bean = new Bean("测试数据"+i,i);
            beans.add(bean);
        }
    }

    public static class ListHolder extends RecyclerView.ViewHolder {
        private BeanItemBinding binding;

        public ListHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public void bind(@NonNull Bean bean) {
            binding.setBean(bean);
        }
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.bean_item, viewGroup, false);
        return new ListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.bind(beans.get(position));
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }
}
