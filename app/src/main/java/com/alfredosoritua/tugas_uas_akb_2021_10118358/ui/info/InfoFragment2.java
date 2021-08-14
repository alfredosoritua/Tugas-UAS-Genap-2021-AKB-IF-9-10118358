package com.alfredosoritua.tugas_uas_akb_2021_10118358.ui.info;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alfredosoritua.tugas_uas_akb_2021_10118358.R;
import com.bumptech.glide.Glide;

public class InfoFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info2, container, false);
        ImageView ivInfo2 = root.findViewById(R.id.ivInfo2);
        Glide.with(getContext())
                .load(R.drawable.info)
                .into(ivInfo2);
        return root;
    }
}