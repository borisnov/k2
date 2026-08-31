/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package main;

import java.time.LocalDate;
import java.util.Scanner;

import model.Faktura;
import model.KonkurentnaKartica;
import model.TekuciRacun;
import model.Vlasnik;
import model.Vrsta;

/**
 * Glavna aplikacija u kojoj se simuliraju dva tekuca racuna sa po dve kartice
 * i dve fakture koje te kartice pokusavaju da plate.
 * Za svaku fakturu se placanje dozvoljava samo prvoj kartici koja ga preuzme.
 */
public class Aplikacija {

	/**
	 * Podrazumevani konstruktor klase Aplikacija.
	 */
	public Aplikacija() {
		super();
	}

	/**
	 * Pokretanje simulacije.
	 * @param args - argumenti komandne linije (ne koriste se)
	 */
	public static void main(String[] args) {
		Vlasnik v1 = new Vlasnik("Boris", "Novakovic", "0101999800011", "0641234567", "008123456");
		Vlasnik v2 = new Vlasnik("Milica", "Jovanovic", "0202000805022", "0649876543", "008654321");

		TekuciRacun tr1 = new TekuciRacun("265-1234567890123-45", Vrsta.DINARSKI, v1, 150000.0);
		TekuciRacun tr2 = new TekuciRacun("160-9876543210987-65", Vrsta.DEVIZNI, v2, 2500.0);

		KonkurentnaKartica k1 = new KonkurentnaKartica();
		k1.setBroj("4111111111111111");
		k1.setRokVazenja(LocalDate.of(2028, 12, 31));
		k1.setCvc(111);

		KonkurentnaKartica k2 = new KonkurentnaKartica();
		k2.setBroj("5222222222222222");
		k2.setRokVazenja(LocalDate.of(2027, 6, 30));
		k2.setCvc(222);

		KonkurentnaKartica k3 = new KonkurentnaKartica();
		k3.setBroj("4333333333333333");
		k3.setRokVazenja(LocalDate.of(2029, 3, 31));
		k3.setCvc(333);

		KonkurentnaKartica k4 = new KonkurentnaKartica();
		k4.setBroj("5444444444444444");
		k4.setRokVazenja(LocalDate.of(2026, 11, 30));
		k4.setCvc(444);

		tr1.dodajKarticu(k1);
		tr1.dodajKarticu(k2);
		tr2.dodajKarticu(k3);
		tr2.dodajKarticu(k4);

		Faktura f1 = new Faktura(12000.0);
		Faktura f2 = new Faktura(800.0);

		System.out.println("Tekuci racuni:");
		System.out.println(tr1);
		System.out.println(tr2);
		System.out.println();
		System.out.println("Fakture za placanje:");
		System.out.println(f1);
		System.out.println(f2);
		System.out.println();

		// Fakturu f1 pokusavaju da plate kartice k1 i k3, a fakturu f2 kartice k2 i k4.
		k1.setFaktura(f1);
		k3.setFaktura(f1);
		k2.setFaktura(f2);
		k4.setFaktura(f2);

		// Unos CVC kodova se trazi pre pokretanja niti, kako se poruke za unos
		// ne bi preplitale sa ispisom konkurentnih placanja.
		Scanner unos = new Scanner(System.in);
		System.out.print("Unesite CVC kod za karticu " + k1.getBroj() + ": ");
		k1.setUneseniCvc(unos.nextInt());
		System.out.print("Unesite CVC kod za karticu " + k2.getBroj() + ": ");
		k2.setUneseniCvc(unos.nextInt());
		System.out.print("Unesite CVC kod za karticu " + k3.getBroj() + ": ");
		k3.setUneseniCvc(unos.nextInt());
		System.out.print("Unesite CVC kod za karticu " + k4.getBroj() + ": ");
		k4.setUneseniCvc(unos.nextInt());
		unos.close();
		System.out.println();

		Thread n1 = new Thread(k1, k1.getBroj());
		Thread n2 = new Thread(k2, k2.getBroj());
		Thread n3 = new Thread(k3, k3.getBroj());
		Thread n4 = new Thread(k4, k4.getBroj());

		n1.start();
		n2.start();
		n3.start();
		n4.start();

		try {
			n1.join();
			n2.join();
			n3.join();
			n4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("Stanje nakon placanja:");
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(tr1);
		System.out.println(tr2);

	}

}
