package com.alfredosoritua.tugas_uas_akb_2021_10118358;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.alfredosoritua.tugas_uas_akb_2021_10118358.ui.info.InfoFragment;

//12 Agustus 2021, 10118358 – Alfredo Soritua – IF9

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //12 Agustus 2021, 10118358 – Alfredo Soritua – IF9
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getFragmentPage(new InfoFragment());
    }

    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}