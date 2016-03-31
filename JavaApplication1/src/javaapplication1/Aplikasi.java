/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author HANIZAR
 */
public class Aplikasi {
    private List<Kereta> daftarKereta = new ArrayList();
    private List<Tiket> daftarTiket = new ArrayList();
    private List<Gerbong> daftarGerbong = new ArrayList();
    private List<Stasiun> daftarStasiun = new ArrayList();
    private List<Rute> daftarRute = new ArrayList();
    private int nRute = 1;

    public void addKereta(Kereta kereta) {
        this.daftarKereta.add(kereta);
    }

    public void addTiket(Tiket tiket) {
        this.daftarTiket.add(tiket);
    }

    public void addGerbong(Gerbong gerbong) {
        this.daftarGerbong.add(gerbong);
    }

    public void addStasiun(Stasiun stasiun) {
    
    }

    public void addRute(Rute rute) {
        this.daftarRute.add(rute);
        nRute++;
    }

    public Kereta getKereta(String nama) {
        for (Kereta k : daftarKereta) {
            if (k.getNama().equals(nama)) {
                return k;
            }
        }
        return null;
    }

    public Tiket getTiket(String kode_tiket) {
        for (Tiket t : daftarTiket) {
            if (t.getKode_Tiket().equals(kode_tiket)) {
                return t;
            }
        }
        return null;
    }

    public Gerbong getGerbong(String kode) {
        for (Gerbong g : daftarGerbong) {
            if (g.getKode().equals(kode)) {
                return g;
            }
        }
        return null;
    }

    public Stasiun getStasiun(String nama) {
        for (Stasiun s : daftarStasiun) {
            if (s.getNama().equals(nama)) {
                return s;
            }
        }
        return null;
    }

    public Rute getRute(Stasiun stasiun1, Stasiun stasiun2) {
        for (Rute r : daftarRute) {
            if (r.getStasiun1().equals(stasiun1) && r.getStasiun2().equals(stasiun2)) {
                return r;
            }
        }
        return null;
    }
    
    public void setGerbong(int x, int y) {
        daftarKereta.get(x).addGerbong(daftarGerbong.get(y));
    }
    
    public void setKereta(int i, int j) {
        daftarRute.get(i).addKereta(daftarKereta.get(j));
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

    public void menuSatu(String kode, String jenis, int jumlah) {
        Gerbong g = new Gerbong(kode, jenis, jumlah);
        addGerbong(g);
    }

    public void menuDua(String nama, String jurusan, String jenis) {
        Kereta k = new Kereta(nama, jurusan, jenis);
        addKereta(k);
    }

    public void menuTiga(String nama, String alamat, String daerah_operasi) {
        Stasiun s = new Stasiun(nama, alamat, daerah_operasi);
        addStasiun(s);
    }
    
    public void menuEmpat(Stasiun stasiun1, Stasiun stasiun2) {
        Rute r = new Rute(stasiun1,stasiun2);
        addRute(r);
    }
    
    public void menuLima(int iKereta, int iGerbong) {
        setGerbong(iKereta,iGerbong);
    }
    
    public void menuEnam(int iRute, int iKereta) {
        setKereta(iRute,iKereta);
    }

    public void menuEnamBelas(String kode_tiket, String jenis, String tanggal, long harga, String nama_kereta,Rute rute){
        Tiket t = new Tiket(kode_tiket,jenis,tanggal,harga,nama_kereta,rute);
        addTiket(t);
    }
        
    public void mainMenu() {
        Scanner sInt = new Scanner(System.in);
        Scanner sString = new Scanner(System.in);
        Scanner sLong = new Scanner(System.in);
        int pil, x, y;
        String nama;
        String alamat;
        String daerah_operasi;
        String kode;
        String jenis;
        int jumlah;
        String jurusan;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Input Data Gerbong");
            System.out.println("2. Input Data Kereta");
            System.out.println("3. Input Data Stasiun");
            System.out.println("4. Input Data Rute");
            System.out.println("5. Set Data Gerbong ke Kereta");
            System.out.println("6. Set Data Kereta ke Rute");
            System.out.println("7. Search Data Gerbong by Id");
            System.out.println("8. Search Data Kereta by Name");
            System.out.println("9. Search Data Stasiun by Name");
            System.out.println("10. Search Data Rute by ");
            System.out.println("11. Delete Data Gerbong");
            System.out.println("12. Delete Data Kereta");
            System.out.println("13. Delete Data Stasiun");
            System.out.println("14. Delete Data Rute");
            System.out.println("15. View All Data");
            System.out.println("16. Buat Tiket");
            System.out.println("17. Exit");
            System.out.print("Input pilihan : ");
            pil = sInt.nextInt();
            switch (pil) {
                case 1:
                    
                    break;

                case 2:
                    System.out.print("Nama Kereta : ");
                    nama = sString.nextLine();
                    System.out.print("Jurusan : ");
                    jurusan = sString.nextLine();
                    System.out.print("Jenis Kereta : ");
                    jenis = sString.nextLine();
                    menuDua(nama,jurusan,jenis);
                    break;

                case 3:
                    System.out.print("Nama Stasiun : ");
                    nama = sString.nextLine();
                    System.out.print("Alamat Stasiun :");
                    alamat = sString.nextLine();
                    System.out.print("Daerah Operasi : ");
                    daerah_operasi = sString.nextLine();
                    menuTiga(nama,alamat,daerah_operasi);
                    break;

                case 4:
                    System.out.println("Masukkan stasiun pertama : ");
                    int i = sInt.nextInt() ;
                    System.out.println("Masukkan stasiun kedua : ");
                    int j = sInt.nextInt() ;
                    menuEmpat(daftarStasiun.get(i), daftarStasiun.get(j));
                    break;
                    
                case 5 :
                    System.out.print("Masukkan Kereta : ");
                    x = sInt.nextInt();
                    System.out.print("Masukkan Gerbong : ");
                    y = sInt.nextInt();
                    menuLima(x,y);
                    break;
                    
                case 6:
                    System.out.println("Masukkan Rute : ");
                    x = sInt.nextInt();
                    System.out.println("Masukkan Kereta : ");
                    y = sInt.nextInt();
                    menuEnam(x,y);
                    break;

                case 7:
                    System.out.print("Masukan Kode Gerbong : ");
                    kode = sString.nextLine();
                    Gerbong g = getGerbong(kode);
                    System.out.print(g.toString());
                    break;

                case 8:
                    System.out.println("Masukkan Nama Kereta : ");
                    nama = sString.nextLine();
                    Kereta k = getKereta(nama);
                    System.out.println(k.toString());
                    break;

                case 9:
                    System.out.println("Masukkan Nama Stasiun : ");
                    nama = sString.nextLine();
                    Stasiun s = getStasiun(nama);
                    System.out.println(s.toString());
                    break;

                case 10:
                    System.out.println("Masukkan stasiun pertama : ");
                    int l = sInt.nextInt() ;
                    System.out.println("Masukkan stasiun kedua : ");
                    int m = sInt.nextInt() ;
                    Rute r = new Rute(daftarStasiun.get(l), daftarStasiun.get(m));
                    System.out.println(r.toString());
                    break;

                case 11:
                    System.out.print("Masukkan Kode Gerbong yang akan dihapus : ");
                    kode = sString.nextLine();
                    deleteGerbong(kode);
                    System.out.println("Data Gerbong telah dihapus");
                    break;

                case 12:
                    System.out.println("Masukkan Nama Kereta yang akan dihapus : ");
                    nama = sString.nextLine();
                    deleteKereta(nama);
                    System.out.println("Data Kereta telah dihapus");
                    break;

                case 13:
                    System.out.println("Masukkan Nama Stasiun yang akan dihapus : ");
                    nama = sString.nextLine();
                    deleteStasiun(nama);
                    break;
                    
                case 14:
                    System.out.println("Masukkan ");
                    break;
                    
                case 15:
                    System.out.println("-- Data Gerbong --");
                    for(Gerbong ge : daftarGerbong) {
                        System.out.println(ge);
                    }
                    System.out.println("-- Data Kereta --");
                    for(Kereta ke : daftarKereta) {
                        System.out.println(ke);
                    }
                    System.out.println("-- Data Stasiun --");
                    for(Stasiun st : daftarStasiun) {
                        System.out.println(st);
                    }
                    System.out.println("-- Data Rute --");
                    for(Rute ru : daftarRute) {
                        System.out.println(ru);
                    }
                    System.out.println("-- Data Tiket --");
                    for(Tiket ti : daftarTiket) {
                        System.out.println(ti);
                    }
                    break;
                    
                case 16:
                    System.out.println("kode tiket"); 
                    String kd = sString.nextLine();
                    System.out.println("jenis"); 
                    jenis = sString.nextLine();
                    System.out.println("tanggal"); 
                    String tanggal = sString.nextLine();
                    System.out.println("harga"); 
                    long harga = sLong.nextLong();
                    System.out.println("nama kereta"); 
                    nama = sString.nextLine();
                    System.out.println("rute"); 
                    int iRute = sInt.nextInt();
                    menuEnamBelas(kd,jenis,tanggal,harga,nama,daftarRute.get(iRute));
                    break;
            }
        } while (pil != 17);
    }
}
