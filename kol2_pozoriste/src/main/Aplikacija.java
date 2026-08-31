/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package main;

import model.Glumac;
import model.KonkurentnoPozoriste;
import model.Predstava;
import model.TipUloge;
import model.Uloga;

/**
 * Glavna aplikacija u kojoj se simulira jedna predstava i tri pozorista
 * u kojima se ta predstava prikazuje.
 * Posto predstava moze biti na repertoaru najvise dva pozorista i emitovati se
 * u isto vreme, trece pozoriste ceka da se oslobodi termin.
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
		Glumac g1 = new Glumac("Petar", "Kralj");
		Glumac g2 = new Glumac("Mirjana", "Karanovic");
		Glumac g3 = new Glumac("Nikola", "Simic");

		Uloga u1 = new Uloga("Hamlet", TipUloge.GLAVNA, g1);
		Uloga u2 = new Uloga("Ofelija", TipUloge.GLAVNA, g2);
		Uloga u3 = new Uloga("Horacije", TipUloge.SPOREDNA, g3);

		Predstava p = new Predstava();
		p.setNaziv("Hamlet");
		p.dodajUlogu(u1);
		p.dodajUlogu(u2);
		p.dodajUlogu(u3);

		KonkurentnoPozoriste pz1 = new KonkurentnoPozoriste();
		KonkurentnoPozoriste pz2 = new KonkurentnoPozoriste();
		KonkurentnoPozoriste pz3 = new KonkurentnoPozoriste();

		pz1.setNaziv("Srpsko narodno pozoriste");
		pz1.setAdresa("Pozorisni trg 1, Novi Sad");
		pz1.setRadnoVreme("09:00 - 22:00");
		pz1.dodajNaRepertoar(p);

		pz2.setNaziv("Pozoriste mladih");
		pz2.setAdresa("Ignjata Pavlasa 4, Novi Sad");
		pz2.setRadnoVreme("10:00 - 21:00");
		pz2.dodajNaRepertoar(p);

		pz3.setNaziv("Novosadsko pozoriste");
		pz3.setAdresa("Jovana Subotica 3, Novi Sad");
		pz3.setRadnoVreme("10:00 - 23:00");
		pz3.dodajNaRepertoar(p);

		Thread n1 = new Thread(pz1, pz1.getNaziv());
		Thread n2 = new Thread(pz2, pz2.getNaziv());
		Thread n3 = new Thread(pz3, pz3.getNaziv());

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
