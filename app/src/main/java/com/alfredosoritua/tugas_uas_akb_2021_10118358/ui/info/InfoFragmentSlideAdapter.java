package com.alfredosoritua.tugas_uas_akb_2021_10118358.ui.info;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class InfoFragmentSlideAdapter extends FragmentStatePagerAdapter {
    //12 Agustus 2021, 10118358 – Alfredo Soritua – IF9

    private List<Fragment> fragmentList;

    public InfoFragmentSlideAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {

        return fragmentList.size();
    }
}