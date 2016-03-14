/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author HANIZAR
 */
public class Tiket {
    private String kode_tiket;
    private String jenis;
    private String tanggal;
    private long harga;
    private String nama_kereta;
    private Rute rute;

    public Tiket(String kode_tiket, String jenis, String tanggal, long harga, String nama_kereta) {
        this.kode_tiket = kode_tiket;
	this.jenis = jenis;
	this.tanggal = tanggal;
	this.harga = harga;
	this.nama_kereta = nama_kereta;
    }

    public void setKode_Tiket(String kode_tiket) {
	this.kode_tiket = kode_tiket;
    }

    public String getKode_Tiket() {
        return kode_tiket;
    }

    public void setNama_Kereta(String nama_kereta) {
        this.nama_kereta = nama_kereta;
    }

    public String getNama_Kereta() {
        return nama_kereta;
    }

    public void setHarga(long harga) {
	this.harga = harga;
    }

    public long getHarga() {
	return harga;
    }

    public void setJenis(String jenis) {
	this.jenis = jenis;
    }

    public String getJenis() {
    	if (jenis == "Eks") {
            return "Eksekutif";
	} 
	else if (jenis == "Bis") {
            return "Bisnis";
	} 
	else if (jenis == "Eko") {
            return "Ekonomi";
	}
	else
	{
            return "Jenis Gerbong yang Anda masukan salah";
	}
    }

    public void setTanggal(String tanggal) {
	this.tanggal = tanggal;
    }

    public String getTanggal() {
	return tanggal;
    }

    public void addRute(Rute rute) {
    	this.rute = rute;
    }

    public void display() {
	System.out.println("======= Info Tiket =======");
	System.out.println();
	System.out.println("Kode Tiket    : "+getKode_Tiket());
	System.out.println("Jenis Tiket   : "+getJenis());
	System.out.println("Tanggal Tiket : "+getTanggal());
	System.out.println("Harga Tiket   : "+getHarga());
	System.out.println("Nama Kereta   : "+getNama_Kereta());
	rute.display();
    }
}
