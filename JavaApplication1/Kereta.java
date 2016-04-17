/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HANIZAR
 */
public class Kereta implements Serializable {

    private String nama;
    private String jurusan;
    private String jenis;
    private List<Gerbong> listGerbong;

    public Kereta(String nama) {
        this.nama = nama;
    }

    public Kereta(String nama, String jurusan, String jenis) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.jenis = jenis;
        listGerbong = new ArrayList<>();
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJenis(String Jenis) {
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

    public void addGerbong(Gerbong gerbong) {
        if (listGerbong.size() < 15) {
            listGerbong.add(gerbong);
        }
        else {
          throw new IllegalStateException("Maximum Gerbong 15");
        } 
    }

    public Gerbong getGerbong(String kode) {
        /*for (Gerbong g : listGerbong) {
            if (g.getKode() == kode) {
                return g;
            }
        }
        return null; */
         return listGerbong.stream()
                .filter(g -> g.getKode().equals(kode))
                .findFirst().orElse(null);
    }

    public void removeGerbong(String kode) {
        /*Gerbong g = getGerbong(kode);
        listGerbong.remove(g);*/
        boolean removed = listGerbong.removeIf(g -> g.getKode().equals(kode));
    }

    @Override
    public String toString() {
        String st = "Info Kereta : "
                + "\n Nama Kereta = " + nama
                + "\n Jurusan Kereta : " + jurusan 
                + "\n Jenis Kereta   : " + jenis;
        return st;
    }
    
    public String show() {
        String st = "Info Kereta : "
                + "\n Nama Kereta = " + nama
                + "\n Jurusan = " + jurusan
                + "\n Jenis Kereta = " + jenis + "\n"
                + "=====================================";
        if (!listGerbong.isEmpty()) {
            for (Gerbong g : listGerbong) {
                st += g.toString() + "\n";
            }
        }
        return st;
    }
    
    public String tampilNama() {
        return nama+"\n"; 
    }
}
