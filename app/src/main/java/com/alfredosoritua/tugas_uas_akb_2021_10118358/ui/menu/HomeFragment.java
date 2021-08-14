package com.alfredosoritua.tugas_uas_akb_2021_10118358.ui.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alfredosoritua.tugas_uas_akb_2021_10118358.R;
import com.alfredosoritua.tugas_uas_akb_2021_10118358.TinyDB;
import com.alfredosoritua.tugas_uas_akb_2021_10118358.model.Wisata;
import com.alfredosoritua.tugas_uas_akb_2021_10118358.model.WisataAdapter;
import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private DatabaseReference reference;
    ArrayList<Wisata> wisataList;
    WisataAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mManager;
    TextView tvDetailWisata, tvDetailNamaTempat, tvDetailKategori, tvDetailAlamat, tvDetailNoTelp, tvDetailDeskripsi;
    Button btnPilih, btnReset;
    ImageView ivGambarTempatWisata;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        TinyDB tinyDB = new TinyDB(getContext());
        tvDetailNamaTempat = viewGroup.findViewById(R.id.tvDetailNamaTempat);
        tvDetailKategori = viewGroup.findViewById(R.id.tvDetailKategori);
        tvDetailAlamat = viewGroup.findViewById(R.id.tvDetailAlamat);
        tvDetailNoTelp = viewGroup.findViewById(R.id.tvDetailNoTelp);
        tvDetailDeskripsi = viewGroup.findViewById(R.id.tvDetailDeskripsi);
        tvDetailWisata = viewGroup.findViewById(R.id.tvDetailWisata);
        btnPilih = viewGroup.findViewById(R.id.btnPilih);
        btnReset = viewGroup.findViewById(R.id.btnReset);
        ivGambarTempatWisata = viewGroup.findViewById(R.id.ivGambarTempatWisata);
        btnPilih.setOnClickListener(view -> {
            tvDetailWisata.setText("Detail Wisata");
            tvDetailNamaTempat.setText(tinyDB.getString("nama_tempat"));
            tvDetailKategori.setText(tinyDB.getString("kategori"));
            tvDetailAlamat.setText("Alamat : \n" + tinyDB.getString("alamat_tempat"));
            tvDetailNoTelp.setText("No Telp : \n" + tinyDB.getString("no_telp"));
            tvDetailDeskripsi.setText("Deskripsi : \n" + tinyDB.getString("deskripsi"));
            Glide.with(getContext())
                    .load(tinyDB.getString("gambar"))
                    .into(ivGambarTempatWisata);
        });

        btnReset.setOnClickListener(view -> {
            tvDetailWisata.setText("");
            tvDetailNamaTempat.setText("");
            tvDetailKategori.setText("");
            tvDetailAlamat.setText("");
            tvDetailNoTelp.setText("");
            tvDetailDeskripsi.setText("");
            ivGambarTempatWisata.setImageResource(0);
            tinyDB.clear();
        });
        mRecyclerView = viewGroup.findViewById(R.id.rvHome);
        mRecyclerView.setHasFixedSize(true);

        mManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mManager);

        reference = FirebaseDatabase.getInstance("https://wisata-yuk-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("wisata");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                wisataList = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Wisata wisata = dataSnapshot.getValue(Wisata.class);
                    wisata.setKey(dataSnapshot.getKey());
                    wisataList.add(wisata);
                }
                mAdapter = new WisataAdapter(getContext(), wisataList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        return viewGroup;
    }
}