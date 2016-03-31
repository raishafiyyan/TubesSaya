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
public class Kereta {

    private String nama;
    private String jurusan;
    private String jenis;
    private List<Gerbong> listGerbong = new ArrayList();

    public Kereta(String nama) {
        this.nama = nama;
    }

    public Kereta(String nama, String jurusan, String jenis) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.jenis = jenis;
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

    public String getJenis(String Jenis) {
        if (jenis.equals("Eks")) {
            return "Eksekutif";
        } else if (jenis.equals("Bis")) {
            return "Bisnis";
        } else if (jenis.equals("Eko")) {
            return "Ekonomi";
        } else {
            return "Jenis Gerbong yang Anda masukan salah";
        }
    }

    public void addGerbong(Gerbong gerbong) {
        this.listGerbong.add(gerbong);
    }

    public Gerbong getGerbong(String kode) {
        for (Gerbong g : listGerbong) {
            if (g.getKode() == kode) {
                return g;
            }
        }
        return null;
    }

    public void removeGerbong(String kode) {
        Gerbong g = getGerbong(kode);
        listGerbong.remove(g);
    }

    @Override
    public String toString() {
        String st = "Info Kereta : " + "\n Nama Kereta    : " + nama + "\n Jurusan Kereta : " + jurusan + "\n Jenis Kereta   : " + getJenis(jenis);
        if (!listGerbong.isEmpty()) {
            for (Gerbong g : listGerbong) {
                st += g.toString() + "\n";
            }
        }
        return st;
    }
}
