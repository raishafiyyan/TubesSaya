/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Arief
 */
public class Stasiun {
	private String nama;
	private String alamat;
	private String daerah_operasi;

	public Stasiun(String nama, String alamat, String daerah_operasi) {
		this.nama = nama;
		this.alamat = alamat;
		this.daerah_operasi = daerah_operasi;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNama() {
		return nama;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setDaerah_Operasi(String daerah_operasi) {
		this.daerah_operasi = daerah_operasi;
	}

	public String getDaerah_Operasi() {
		return daerah_operasi;
	}

	public void display() {
		System.out.println("======= Info Stasiun =======");
		System.out.println();
		System.out.println("Nama Stasiun   : "+getNama());
		System.out.println("Alamat Stasiun : "+getAlamat());
		System.out.println("Daerah Operasi : "+getDaerah_Operasi());
		System.out.println();
	}
}
