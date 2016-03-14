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
    private Gerbong daftargerbong[] = new Gerbong[15];
	private String nama;
	private String jurusan;
	private String jenis;
	private int num;
	
	public Kereta(String nama,String jurusan,String jenis){
		setnama(nama);
		setjurusan(jurusan);
		setjenis(jenis);
	}
	public void setnama(String nama){
		this.nama = nama;
	}
	public void setjurusan(String jurusan){
		this.jurusan = jurusan;
	}
	public String getnama(){
		return nama;
	}
	public String getjurusan(){
		return jurusan;
	}
	public String getjenis(){
		return jenis;
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
	public void addgerbong(Gerbong g){
		if (num<15){
			daftargerbong[num] = g;
			num++;
		}
	}
	public void display(){
		System.out.println("Nama Kereta : " + getnama());
		System.out.println("Jenis Kereta : " + getjenis());
		System.out.println("Jurusan Kereta : " + getjurusan());
		for(int i=0;i<num;i++){
			System.out.println("Kode gerbong : " + daftargerbong[i-1].getkode());
			System.out.println("Kode gerbong : " + daftargerbong[i-1].getjumlah());
		}
	}
}
