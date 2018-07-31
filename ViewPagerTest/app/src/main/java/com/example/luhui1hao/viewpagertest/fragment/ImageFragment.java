package com.example.luhui1hao.viewpagertest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.luhui1hao.viewpagertest.R;

public class ImageFragment extends Fragment {

    private int imgId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgId = getArguments().getInt("imgId");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_layout, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.img);
        imageView.setImageResource(imgId);
        return view;
    }
}
