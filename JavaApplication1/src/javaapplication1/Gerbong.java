/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author aconggancuk
 */
public class Gerbong {
    private String kode;
    private String jenis;
    private int jumlah;
    
    public Gerbong(String kode) {
        this.kode = kode;
    }

    public Gerbong(String kode,String jenis,int jumlah) {
	this.kode = kode;
	this.jenis = jenis;
	this.jumlah = jumlah;
    }

    public void setKode(String kode) {
	this.kode = kode;
    }

    public String getKode() {
	return kode;
    }

    public String getJenis(String jenis) {
	if (jenis.equals("Eks")) {
            return ("Eksekutif");
	} 
	else if (jenis.equals("Bis")) {
            return ("Bisnis"); 
	} 
	else if (jenis.equals("Eko")) {
            return ("Ekonomi");
	}
	else
	{
            return ("Jenis Gerbong yang Anda masukan salah");
	}
    }

    public void setJumlah(int jumlah) {
	this.jumlah = jumlah;
    }

    public int getJumlah() {
    	return jumlah;
    }
    
    @Override
    public String toString() {
        return "Info Gerbong : " + "\n Kode Gerbong = " + kode + "\n Jenis Gerbong = " + getJenis(jenis) + "\n Jumlah Gerbong = " + jumlah;
    }
}
