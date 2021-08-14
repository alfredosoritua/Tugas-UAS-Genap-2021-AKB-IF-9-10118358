package com.alfredosoritua.tugas_uas_akb_2021_10118358.model;

//12 Agustus 2021, 10118358 – Alfredo Soritua – IF9

public class Wisata {
    public String key;
    public String nama_tempat;
    public String kategori;
    public String no_telp;
    public String alamat_tempat;
    public String deskripsi;
    public String gambar;
    public Double latitude;
    public Double longitude;

    public String getAlamat_tempat() {
        return alamat_tempat;
    }

    public void setAlamat_tempat(String alamat_tempat) {
        this.alamat_tempat = alamat_tempat;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNama_tempat() {
        return nama_tempat;
    }

    public void setNama_tempat(String nama_tempat) {
        this.nama_tempat = nama_tempat;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Wisata() {

    }

    public Wisata(String nama_tempat, String alamat_tempat, String deskripsi, String kategori, String no_telp,
                  String gambar, Double latitude, Double longitude) {
        this.nama_tempat = nama_tempat;
        this.alamat_tempat = alamat_tempat;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.no_telp = no_telp;
        this.gambar = gambar;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
