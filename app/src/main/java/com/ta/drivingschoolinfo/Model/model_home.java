package com.ta.drivingschoolinfo.Model;

public class model_home {

    private String nama;
    private String alamat;
    private String notel;

    public model_home(String nama, String alamat, String notel) {
        this.nama = nama;
        this.alamat = alamat;
        this.notel = notel;

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotel() {
        return notel;
    }

    public void setNotel(String notel) {
        this.notel = notel;
    }
}
