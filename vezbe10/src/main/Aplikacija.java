/**
 * @author Aleksandra Samardzic
 * @date 29. 4. 2026.
 */
package main;

import model.KonkurentniUredjaj;
import model.KorisnickiNalog;

/**
 * 
 */
public class Aplikacija {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KorisnickiNalog kn = new KorisnickiNalog(100220, "Aleksandra", "Samardzic", "asamardzic@singidunum.ac.rs");
		
		KonkurentniUredjaj ku1 = new KonkurentniUredjaj();
		KonkurentniUredjaj ku2 = new KonkurentniUredjaj();
		KonkurentniUredjaj ku3 = new KonkurentniUredjaj();
		
		ku1.setId(1050);
		ku1.setIpAdresa("192.159.123.23");
		ku1.setNaziv("LG TV");
		ku1.setKorisnickiNalog(kn);
		
		ku2.setId(1051);
		ku2.setIpAdresa("192.165.123.24");
		ku2.setNaziv("Samsung TV");
		ku2.setKorisnickiNalog(kn);
		
		ku3.setId(1053);
		ku3.setIpAdresa("192.132.123.25");
		ku3.setNaziv("Xiaomi Phone");
		ku3.setKorisnickiNalog(kn);
		
		Thread t1 = new Thread(ku1, ku1.getNaziv());
		Thread t2 = new Thread(ku2, ku2.getNaziv());
		Thread t3 = new Thread(ku3, ku3.getNaziv());
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
