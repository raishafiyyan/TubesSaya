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
public class Rute {
	private Stasiun stasiun1;
	private Stasiun stasiun2;
	private Kereta kereta[] = new Kereta[15];
	private Stasiun daftarstasiun[] = new Stasiun[10];
	private int numkereta;
	private int numstasiun;

	public void setStasiun1(Stasiun s) {
		this.stasiun1 = s;
	}

	public Stasiun getStasiun1() {
		return stasiun1;
	}

	public void setStasiun2(Stasiun s) {
		this.stasiun2 = s;
	}

	public Stasiun getStasiun2() {
		return stasiun2;
	}

	public void addKereta(Kereta k) {
		if (numkereta < 15) {
			this.kereta[numkereta] = k;
			numkereta++;
		}
		else {
			numkereta = numkereta;
		}
	}

	public void addStasiun(Stasiun s) {
		if (numstasiun < 15) {
			this.daftarstasiun[numstasiun] = s;
			numstasiun++;
		}
		else {
			numstasiun = numstasiun;
		}
	}	

	public void display() {
		System.out.println("======= Info Rute =======");
		System.out.println();
		for (int j=0;j<numstasiun;j++) {
			if (j % 2 == 0) {
				System.out.println("Stasiun Keberangkatan : "+daftarstasiun[j].getNama());
			}
			else if (j % 2 == 1) {
				System.out.println("Stasiun Tujuan : "+daftarstasiun[j].getNama());	
			}
		}
		System.out.println("Info Kereta   : ");
		for (int i=1;i<=numkereta;i++) {
			System.out.println("   1. Nama Kereta    : "+kereta[i-1].getNama());
			System.out.println("   2. Jenis Kereta   : "+kereta[i-1].getJenis());
			System.out.println("   3. Jurusan Kereta : "+kereta[i-1].getJurusan());
		}
		System.out.println();
	}
}    

