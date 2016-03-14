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
	
	public Gerbong(String kode){
		setkode(kode);
	}
	public void setkode(String kode){
		this.kode = kode;
	}
	public String getkode(){
		return kode;
	}
	public void setjenis(String jenis){
		if (jenis.equals("Eks")){
			System.out.println("Eksekutif");
		}
		else if (jenis.equals("Bis")){
			System.out.println("Bisnis");
		}
		else if (jenis.equals("Eko")){
			System.out.println("Ekonomi");
		}
	}
	public String getjenis(){
		return jenis;
	}
	public void setjumlah(){
		this.jumlah = jumlah;
	}
	public int getjumlah(){
		return jumlah;
	}
}
