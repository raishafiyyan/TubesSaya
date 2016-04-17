/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import database.FileIO;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.ComboBoxModel;

/**
 *
 * @author HANIZAR
 */
public class Aplikasi implements Serializable {

    private List<Kereta> daftarKereta;
    private List<Tiket> daftarTiket;
    private List<Gerbong> daftarGerbong;
    private List<Stasiun> daftarStasiun;
    private List<Rute> daftarRute;
    private int nRute = 1;
    private FileIO save;

    public Aplikasi() {
        daftarKereta = new ArrayList();
        daftarTiket = new ArrayList();
        daftarGerbong = new ArrayList();
        daftarStasiun = new ArrayList();
        daftarRute = new ArrayList();
        save = new FileIO();
    }
    
    public List<Gerbong> getDataGerbong(){
       return daftarGerbong;
    }
    
    public List<Kereta> getDataKereta(){
        return daftarKereta;
    }
    
    public List<Stasiun> getDataStasiun() {
        return daftarStasiun;
    }
    
    public List<Rute> getDataRute() {
        return daftarRute;
    }
    
    public void addGerbong(String kode,String jenis,String jumlah) {
        daftarGerbong.add(new Gerbong(kode,jenis,jumlah));
    }
    
    public void addKereta(String nama, String jurusan, String jenis) {
        daftarKereta.add(new Kereta(nama,jurusan,jenis));
    }

    public void addStasiun(String nama, String alamat, String daerah_operasi) {
        daftarStasiun.add(new Stasiun(nama,alamat,daerah_operasi));
    }

    public void addRute(Stasiun stasiun1, Stasiun stasiun2) {
        daftarRute.add(new Rute(stasiun1,stasiun2));
        nRute++;
    }
    
    public void addTiket(String kode_tiket, String jenis, String tanggal, long harga, String nama_kereta,Rute rute) {
        daftarTiket.add(new Tiket(kode_tiket,jenis,tanggal,harga,nama_kereta,rute));
    }
    
    public Gerbong getGerbong(String kode) {
        /*
        for (Gerbong g : daftarGerbong) {
            if (g.getKode().equals(kode)) {
                return g;
            }
        }
        return null;
        */
        return daftarGerbong.stream()
                .filter(g -> g.getKode().equals(kode))
                .findFirst().orElse(null);
    }

    public Kereta getKereta(String nama) {
        /*
        for (Kereta k : daftarKereta) {
            if (k.getNama().equals(nama)) {
                return k;
            }
        }
        return null;
        */
        return daftarKereta.stream()
                .filter(k -> k.getNama().equals(nama))
                .findFirst().orElse(null);
    }

    public Tiket getTiket(String kode_tiket) {
        /*
        for (Tiket t : daftarTiket) {
            if (t.getKode_Tiket().equals(kode_tiket)) {
                return t;
            }
        }
        return null;
        */
        return daftarTiket.stream()
                .filter(t -> t.getKode_Tiket().equals(kode_tiket))
                .findFirst().orElse(null);
    }

    public Stasiun getStasiun(String nama) {
        /*
        for (Stasiun s : daftarStasiun) {
            if (s.getNama().equals(nama)) {
                return s;
            }
        }
        return null;
        */
        return daftarStasiun.stream()
                .filter(s -> s.getNama().equals(nama))
                .findFirst().orElse(null);
    }

    public Rute getRute(Stasiun stasiun1, Stasiun stasiun2) {
        /*
        for (Rute r : daftarRute) {
            if (r.getStasiun1().equals(stasiun1) && r.getStasiun2().equals(stasiun2)) {
                return r;
            }
        }
        return null;
        */
        return daftarRute.stream()
                .filter(r -> r.getStasiun1().equals(stasiun1) && r.getStasiun2().equals(stasiun2))
                .findFirst().orElse(null);
    }
    
    public String[] getListGerbong() {
        List kode = daftarGerbong.stream()
                .filter(g -> !(g instanceof Gerbong))
                .map(g -> g.getKode()).collect(Collectors.toList());
        return (String[]) kode.stream().toArray(size -> new String[size]);
    }
    
    public String[] getListKereta() {
        List nama = daftarKereta.stream()
                .filter(k -> !(k instanceof Kereta))
                .map(k -> k.getNama()).collect(Collectors.toList());
        return (String[]) nama.stream().toArray(size -> new String[size]);
    }
    
    public String[] getListStasiun(){
        List nama = daftarStasiun.stream().filter(s -> !(s instanceof Stasiun))
                .map(s -> s.getNama()).collect(Collectors.toList());
        return (String[]) nama.stream().toArray(size -> new String[size]);
    }
    
    public String[] getListTiket(){
        List kode = daftarTiket.stream().filter(t -> !(t instanceof Tiket))
                .map(t -> t.getKode_Tiket()).collect(Collectors.toList());
        return (String[]) kode.stream().toArray(size -> new String[size]);
    }
    
    public void viewListConsole(String[] list) {
        Arrays.stream(list).forEach(System.out::println);
    }
    
    public void setGerbong(int x, int y) {
        daftarKereta.get(x).addGerbong(daftarGerbong.get(y));
    }
    
    public void setKereta(int i, int j) {
        daftarRute.get(i).addKereta(daftarKereta.get(j));
    }
    
    public void setRute(int k) {
        daftarRute.get(k);
    }
    
    public void deleteKereta(String nama) {
        Kereta k = getKereta(nama);
        daftarKereta.remove(k);
    }

    public void deleteTiket(String kode_tiket) {
        Tiket t = getTiket(kode_tiket);
        daftarTiket.remove(t);
    }

    public void deleteGerbong(String kode) {
        Gerbong g = getGerbong(kode);
        daftarGerbong.remove(g);
    }

    public void deleteRute(Stasiun stasiun1, Stasiun stasiun2) {
        Rute r = getRute(stasiun1, stasiun2);
        daftarRute.remove(r);
    }

    public void deleteStasiun(String nama) {
        Stasiun s = getStasiun(nama);
        daftarStasiun.remove(s);
    }

    public void loadGerbong() throws FileNotFoundException, IOException {
        try {
            daftarGerbong = (ArrayList<Gerbong>) save.loadObject("gerbong.dat");
        } catch (FileNotFoundException ex) {
            File f = new File("gerbong.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            daftarGerbong = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
    
    public void saveGerbong() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarGerbong, "gerbong.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
    
    public void loadKereta() throws FileNotFoundException, IOException {
        try {
            daftarKereta = (ArrayList<Kereta>) save.loadObject("kereta.dat");
        } catch (FileNotFoundException ex) {
            File f = new File("kereta.dat");
            f.createNewFile();
        } catch (EOFException ex) {
            daftarKereta = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
    
    public void saveKereta() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarKereta, "kereta.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
    
     public void loadRute() throws FileNotFoundException, IOException {
        try{
            daftarRute = (ArrayList<Rute>) save.loadObject("rute.dat");
        } catch(FileNotFoundException ex){
            File f = new File("rute.dat");
            f.createNewFile();
        } catch(EOFException ex){
            daftarRute = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex){
            throw new IOException("error" + ex.getMessage());
        }
    }
    
    public void saveRute() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarRute, "rute.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
    
    public void loadTiket() throws FileNotFoundException, IOException {
        try{
            daftarTiket = (ArrayList<Tiket>) save.loadObject("Tiket.dat");
        } catch(FileNotFoundException ex){
            File f = new File("Tiket.dat");
            f.createNewFile();
        } catch(EOFException ex){
            daftarTiket = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex){
            throw new IOException("error" + ex.getMessage());
        }
    }
    
    public void saveTiket() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarTiket, "Tiket.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
    
    public void loadStasiun() throws FileNotFoundException, IOException {
        try{
            daftarStasiun = (ArrayList<Stasiun>) save.loadObject("Stasiun.dat");
        } catch(FileNotFoundException ex){
            File f = new File("Stasiun.dat");
            f.createNewFile();
        } catch(EOFException ex){
            daftarStasiun = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex){
            throw new IOException("error" + ex.getMessage());
        }
    }
    
    public void saveStasiun() throws FileNotFoundException, IOException {
        try {
            save.saveObject(daftarStasiun, "Stasiun.dat");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }
}