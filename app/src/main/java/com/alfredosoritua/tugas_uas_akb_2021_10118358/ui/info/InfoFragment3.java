package com.alfredosoritua.tugas_uas_akb_2021_10118358.ui.info;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.alfredosoritua.tugas_uas_akb_2021_10118358.HomeActivity;
import com.alfredosoritua.tugas_uas_akb_2021_10118358.R;
import com.bumptech.glide.Glide;

public class InfoFragment3 extends Fragment {
    Button btnGetStarted;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info3, container, false);
        ImageView ivInfo3 = root.findViewById(R.id.ivInfo3);
        Glide.with(getContext())
                .load(R.drawable.happy)
                .into(ivInfo3);
        btnGetStarted = root.findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), HomeActivity.class));
        });
        return root;
    }
}