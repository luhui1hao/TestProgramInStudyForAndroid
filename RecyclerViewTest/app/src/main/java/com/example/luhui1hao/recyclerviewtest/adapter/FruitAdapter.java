package com.example.luhui1hao.recyclerviewtest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luhui1hao.recyclerviewtest.R;
import com.example.luhui1hao.recyclerviewtest.bean.Fruit;

import java.util.List;

/**
 * Created by luhui on 2017/2/16.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> fruits;

    //提供一个适当的构造器（依赖于数据集的类型）
    public FruitAdapter(List<Fruit> fruits){
        this.fruits = fruits;
    }

    //为每个数据项对应的View提供一个引用
    //复杂的数据项。每一项可能需要超过一个View
    //在一个view holder中你需要为每一个数据项提供所有View的存取
    static class ViewHolder extends RecyclerView.ViewHolder{
        int id;
        TextView nameTv;
        TextView colorTv;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.name);
            colorTv = (TextView) itemView.findViewById(R.id.color);
        }
    }

    //在这里面创建View（由布局管理器调用）
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //替换一个View的内容（由一个布局管理器创建）
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);
        holder.nameTv.setText(fruit.getName());
        holder.colorTv.setText(fruit.getColor());
        holder.id = fruit.getId();
    }

    //返回数据集的长度（由布局管理器调用）
    @Override
    public int getItemCount() {
        return fruits.size();
    }
}
