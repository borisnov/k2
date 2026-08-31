/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package main;

import model.Clan;
import model.ClanskaKarta;
import model.KonkurentnaTeretana;
import model.VrstaClanarine;

/**
 * Glavna aplikacija u kojoj se simulira jedan clan sa svojom clanskom kartom
 * i vise teretana u kojima zeli da trenira.
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
		ClanskaKarta ck = new ClanskaKarta(2050, "Boris", "Novakovic", VrstaClanarine.STUDENTSKA);
		Clan c = new Clan(ck, "boris.novakovic@singidunum.ac.rs", "0641234567");

		KonkurentnaTeretana t1 = new KonkurentnaTeretana();
		KonkurentnaTeretana t2 = new KonkurentnaTeretana();
		KonkurentnaTeretana t3 = new KonkurentnaTeretana();

		t1.setNaziv("FitPass Centar");
		t1.setPib("100123456");
		t1.setMaticniBroj("20123456");
		t1.setAdresa("Bulevar oslobodjenja 100, Novi Sad");
		t1.setRadnoVreme("07:00 - 23:00");
		t1.setClan(c);

		t2.setNaziv("Gold Gym");
		t2.setPib("100123457");
		t2.setMaticniBroj("20123457");
		t2.setAdresa("Zmaj Jovina 12, Novi Sad");
		t2.setRadnoVreme("06:00 - 22:00");
		t2.setClan(c);

		t3.setNaziv("Iron House");
		t3.setPib("100123458");
		t3.setMaticniBroj("20123458");
		t3.setAdresa("Futoska 45, Novi Sad");
		t3.setRadnoVreme("08:00 - 24:00");
		t3.setClan(c);

		Thread n1 = new Thread(t1, t1.getNaziv());
		Thread n2 = new Thread(t2, t2.getNaziv());
		Thread n3 = new Thread(t3, t3.getNaziv());

		n1.start();
		n2.start();
		n3.start();

		try {
			n1.join();
			n2.join();
			n3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
