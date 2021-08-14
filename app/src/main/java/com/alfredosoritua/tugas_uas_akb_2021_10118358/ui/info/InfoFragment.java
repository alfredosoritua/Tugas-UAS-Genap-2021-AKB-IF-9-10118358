package com.alfredosoritua.tugas_uas_akb_2021_10118358.ui.info;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alfredosoritua.tugas_uas_akb_2021_10118358.MainActivity;
import com.alfredosoritua.tugas_uas_akb_2021_10118358.R;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {
    //12 Agustus 2021, 10118358 – Alfredo Soritua – IF9
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        viewPager = root.findViewById(R.id.view_pager_info);
        return root;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        mainActivity = (MainActivity) getActivity();

        List<Fragment> list = new ArrayList<>();
        list.add(new InfoFragment1());
        list.add(new InfoFragment2());
        list.add(new InfoFragment3());

        pagerAdapter = new InfoFragmentSlideAdapter(requireActivity().getSupportFragmentManager(), list);

        viewPager.setAdapter(pagerAdapter);
    }
}