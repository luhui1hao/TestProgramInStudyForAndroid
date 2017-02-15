package com.example.luhui1hao.testlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luhui on 2017/2/11.
 */

public class FruitAdapyer extends BaseAdapter {
    private List<Fruit> fruits;
    private Context mContext;

    public FruitAdapyer(Context mContext, List<Fruit> fruits){
        this.mContext = mContext;
        this.fruits = fruits;
    }
    @Override
    public int getCount() {
        return fruits.size();
    }

    @Override
    public Object getItem(int position) {
        return fruits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if(convertView == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.fruit_layout, parent, false);
            holder = new ViewHolder();
            holder.nameTv = (TextView) view.findViewById(R.id.name);
            holder.colorTv = (TextView) view.findViewById(R.id.color);
            view.setTag(holder);
        }else{
            view = convertView;
            holder = (ViewHolder) view.getTag();
            Log.d("luhui", "position = " + position + "convertViewId = " + holder.id);
        }

        holder.nameTv.setText(fruits.get(position).getName());
        holder.colorTv.setText(fruits.get(position).getColor());
        holder.id = fruits.get(position).getId();

        return view;
    }

    class ViewHolder{
        TextView nameTv;
        TextView colorTv;
        int id;
    }
}
