package com.example.catering;

import java.io.Serializable;

public class Pesanan implements Serializable {
    String alamat;
    String tanggal;
    String jam;
    String jml;

    public Pesanan() {

    }

    public Pesanan(String alamat, String tanggal, String jam, String jml) {
        this.alamat = alamat;
        this.tanggal = tanggal;
        this.jam = jam;
        this.jml = jml;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public String getJml() {
        return jml;
    }

}
