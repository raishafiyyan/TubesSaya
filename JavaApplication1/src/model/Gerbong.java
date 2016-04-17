/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author HANIZAR
 */
public class Gerbong implements Serializable {
    private String kode;
    private String jenis;
    private String jumlah;
    
    public Gerbong() {}
    
    public Gerbong(String kode) {
        this.kode = kode;
    }

    public Gerbong(String kode,String jenis,String jumlah) {
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

    public final void setJenis(String jenis) {
        switch(jenis) {
            case "1" : 
                jenis = "Eksekutif";
                break;
            case "2" :
                jenis = "Bisnis";
                break;
            case "3" :
                jenis = "Ekonomi";
                break;
            default:
                jenis = "Jenis Gerbong yang Anda masukkan salah";
        }
    }
    
    public String getJenis() {
	return jenis;
    }

    public void setJumlah(String jumlah) {
	this.jumlah = jumlah;
    }

    public String getJumlah() {
    	return jumlah;
    }
    
    @Override
    public String toString() {
        return "Info Gerbong : "
                + "\n Jenis Gerbong = " + jenis  
                + "\n Jumlah Gerbong = " + jumlah + "\n";
    }
    
    public String show() {
        return "Info Gerbong : "
                + "\n Kode Gerbong = " + kode
                + "\n Jenis Gerbong = " + jenis  
                + "\n Jumlah Gerbong = " + jumlah + "\n"
                + "=====================================";
    }
    
    public String tampilKode() {
        return kode + "\n";
    }
}
