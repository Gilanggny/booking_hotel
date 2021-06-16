package com.hotel.restapi.model;

public class OrderHotel {
    private long id;
    private String username;
    private String phone;
    private String hotel;
    private int durasi;
    private int tanggalpesan;
    private int tanggalakhir;
    private Double tarif;

    OrderHotel(){}

    public OrderHotel(long inputId, String inputUsername, String namaHotel,
                 int lamaDurasi, int tanggalPesanan) {
        this.id = inputId;
        this.username = inputUsername;
        this.hotel = namaHotel;
        this.durasi = lamaDurasi;
        this.tanggalpesan = tanggalPesanan;
    }

    // Setter
    public void setId(long id) {
        this.id = id;
    }
    public void setUsername(String input) {
        this.username = input;
    }
    public void setHotel(String input) {
        this.hotel = input;
    }
    public void setDurasi(int input) {
        this.durasi = input;
    }
    public void setTanggalpesan(int input) {
        this.tanggalpesan = input;
    }
    public void setPhone(String input){this.phone = input;}

    // Getter
    public long getId(){return id;}
    public String getUsername(){return username;}
    public String getHotel(){return hotel;}
    public int getDurasi(){return durasi;}
    public int getTanggalpesan(){return tanggalpesan;}
    public int getTanggalAkhir(){return tanggalakhir;}
    public Double getTarif(){return tarif;}
    public String getPhone(){return phone;}

    // Calculate
    public void calculateFinalDate(){
        int finalDate = getDurasi() + getTanggalpesan();
        this.tanggalakhir = finalDate;
    }
    public void calculatePrice(Double inputPrice){
        this.tarif = Double.parseDouble(String.valueOf(getDurasi())) * inputPrice;
    }

}
