package com.alfredosoritua.tugas_uas_akb_2021_10118358;

//12 Agustus 2021, 10118358 – Alfredo Soritua – IF9

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.alfredosoritua.tugas_uas_akb_2021_10118358.R;
import com.alfredosoritua.tugas_uas_akb_2021_10118358.ui.menu.HomeFragment;
import com.alfredosoritua.tugas_uas_akb_2021_10118358.ui.menu.MapsFragment;
import com.alfredosoritua.tugas_uas_akb_2021_10118358.ui.menu.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        getFragmentPage(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case
                            R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case
                            R.id.maps:
                        fragment = new MapsFragment();
                        break;
                    case
                            R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });
    }

    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container_home, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}