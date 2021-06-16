package com.hotel.restapi.model;

public class Hotel {
    private long id;
    private String name;
    private String kota;
    private int kamar;
    private int terpakai;
    private int tersedia;
    private Double harga;
    private String imglink;

    Hotel(){}

    public Hotel(long inputId, String inputNama, String letakKota,
                 int jumlahKamar, int jumlahTerpakai, int jumlahTersedia, Double hargaKamar) {
        this.id = inputId;
        this.name = inputNama;
        this.kota = letakKota;
        this.kamar = jumlahKamar;
        this.terpakai = jumlahTerpakai;
        this.tersedia = jumlahTersedia;
        this.harga = hargaKamar;
    }

    // Setter
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setKota(String kota) {
        this.kota = kota;
    }
    public void setKamar(int kamar) {
        this.kamar = kamar;
    }
    public void setTerpakai(int terpakai) {
        this.terpakai = terpakai;
    }
    public void setTersedia(int tersedia) {
        this.tersedia = tersedia;
    }
    public void setHarga(Double harga){
        this.harga = harga;
    }
    public void setImage(String input){this.imglink = input;}

    // Getter
    public long getId(){return id;}
    public String getName(){return name;}
    public String getKota(){return kota;}
    public int getKamar(){return kamar;}
    public int getTerpakai(){return terpakai;}
    public int getTersedia(){return tersedia;}
    public Double getHarga(){return harga;}
    public String getImageLink(){return imglink;}

    // Change Value
    public void tambahTerpakai(){
        this.terpakai++;
    }
    public void kurangiTerpakai(){
        this.terpakai--;
    }
    public void tambahTersedia(){
        this.tersedia++;
    }
    public void kurangiTersedia(){
        this.tersedia--;
    }

}
