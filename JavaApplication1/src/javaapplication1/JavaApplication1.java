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
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		Stasiun s1 = new Stasiun("Kiaracondong","Bandung, Kiaracondong","Bandung");
		Stasiun s2 = new Stasiun("Gambir","Jakarta Pusat","Jakarta");
		Kereta k = new Kereta("Argo Parahyangan","Bandung Jakarta","Eks");
		Gerbong g = new Gerbong("Eks01","Eks",7);
		Rute r = new Rute();
		Tiket t = new Tiket("T01","Eks","14 Maret 2016",50000,"Argo Parahyangan");

		r.addStasiun(s1);
		r.addStasiun(s2);
		t.addRute(r);

		k.addGerbong(g);
		r.addKereta(k);

		/*s1.display();
		s2.display();
		k.display();
		r.display();*/
		t.display();
}

    
}
