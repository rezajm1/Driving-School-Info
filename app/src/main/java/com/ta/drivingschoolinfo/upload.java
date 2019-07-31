package com.ta.drivingschoolinfo;

public class upload  {
    private String mNamakursus;
    private String GambarUrl;
    private String mNotel;
    private String mAlamat;



    public upload()
    {
        //Construktor Kosong

    }
    public upload(String medittextnamakursus, String meditnotel, String meditalamatlengkap, String gambarUrl)
    {
        if (medittextnamakursus.trim().equals(""))
        {
            medittextnamakursus = "Nama Kursus Tidak ADA";
        }
        else if (meditnotel.trim().equals(""))
        {
            meditnotel = "Nomor Telepon Tidak ADA";
        }
        else if (meditalamatlengkap.trim().equals(""))
        {
            meditalamatlengkap = "Alamat Tidak ADA";
        }
        this.mNamakursus = medittextnamakursus;
        this.mNotel = meditnotel;
        this.mAlamat = meditalamatlengkap;
        this.GambarUrl = gambarUrl;

    }
    public String getmNamakursus()
    {
        return mNamakursus;
    }
    public void setmName(String medittextnamakurus)
    {
        mNamakursus = medittextnamakurus;
    }
    public String getmNotel()
    {
        return mNotel;
    }
    public void setmNotel(String meditnotel)
    {
        mNotel = meditnotel;
    }
    public String getmAlamat()
    {
        return mAlamat;
    }
    public void setmAlamat(String meditalamatlengkap)
    {
        mAlamat = meditalamatlengkap;
    }
    public String getGambarUrl()
    {
        return GambarUrl;
    }
    public void setGambarUrl(String gambarUrl)
    {
        GambarUrl = gambarUrl;
    }

}