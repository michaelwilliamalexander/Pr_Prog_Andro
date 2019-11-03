package com.example.logins;

public class Matakuliahs {
    private String namaDosen;
    private int sks;
    private String mataKuliah;

    public Matakuliahs(){
    }

    public Matakuliahs(String mataKuliah,int sks, String namaDosen){
        this.mataKuliah = mataKuliah;
        this.sks = sks;
        this.namaDosen = namaDosen;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
         this.sks = sks;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }
}
