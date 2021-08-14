package com.alfredosoritua.tugas_uas_akb_2021_10118358.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alfredosoritua.tugas_uas_akb_2021_10118358.R;
import com.alfredosoritua.tugas_uas_akb_2021_10118358.TinyDB;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.alfredosoritua.tugas_uas_akb_2021_10118358.model.Wisata;

//12 Agustus 2021, 10118358 – Alfredo Soritua – IF9

import java.util.ArrayList;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {
    public Context context;
    public ArrayList<Wisata> wisatas;
    private DatabaseReference reference;

    public WisataAdapter (Context context, ArrayList<Wisata> wisatas) {
        this.context = context;
        this.wisatas = wisatas;
        reference = FirebaseDatabase.getInstance("https://wisata-yuk-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("wisata");
    }

    @NonNull
    @Override
    public WisataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WisataAdapter.ViewHolder holder, int position) {
        holder.tvNamaTempat.setText(wisatas.get(position).getNama_tempat());
        holder.itemView.setOnClickListener(view -> {
            TinyDB tinyDB = new TinyDB(context);
            tinyDB.putString("nama_tempat", wisatas.get(position).getNama_tempat());
            tinyDB.putString("kategori", wisatas.get(position).getKategori());;
            tinyDB.putString("alamat_tempat", wisatas.get(position).getAlamat_tempat());
            tinyDB.putString("no_telp", wisatas.get(position).getNo_telp());
            tinyDB.putString("deskripsi", wisatas.get(position).getDeskripsi());
            tinyDB.putString("gambar", wisatas.get(position).getGambar());
            tinyDB.putDouble("latitude", wisatas.get(position).getLatitude());
            tinyDB.putDouble("longitude", wisatas.get(position).getLongitude());
            Toast.makeText(view.getContext(), wisatas.get(position).getNama_tempat() + " dipilih, silahkan klik tombol pilih untuk memunculkan detail", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return wisatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaTempat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaTempat = itemView.findViewById(R.id.tvNamatempat);
        }
    }
}
