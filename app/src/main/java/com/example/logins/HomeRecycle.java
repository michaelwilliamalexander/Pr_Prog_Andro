package com.example.logins;

public class HomeRecycle {
    private  String judul;
    private  String nama;
    private int foto;
    public HomeRecycle(String judul, String nama , int foto) {
        this.judul = judul;
        this.nama = nama;
        this.foto = foto;
    }
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
