/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

import java.time.LocalDate;
import java.util.concurrent.Semaphore;

/**
 * Klasa koja predstavlja fakturu koja se placa tacno jednom karticom.
 * Iako vise kartica moze pokusati da izvrsi uplatu, placanje se dozvoljava
 * samo prvoj kartici koja preuzme jedinu dozvolu semafora.
 * Dozvola se ne vraca, jer se placanje moze pokusati tacno jednom.
 */
public class Faktura {
	private double iznos;
	private Kartica kartica;
	private LocalDate datum = LocalDate.now();

	private boolean placena = false;
	private final Semaphore semafor = new Semaphore(1);

	/**
	 * Podrazumevani konstruktor klase Faktura.
	 * Datum se podrazumevano postavlja na danasnji.
	 */
	public Faktura() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Faktura.
	 * Datum se podrazumevano postavlja na danasnji.
	 * @param iznos - iznos koji se placa
	 */
	public Faktura(double iznos) {
		super();
		this.iznos = iznos;
	}

	/**
	 * Konstruktor sa parametrima klase Faktura.
	 * @param iznos - iznos koji se placa
	 * @param datum - datum fakture
	 */
	public Faktura(double iznos, LocalDate datum) {
		super();
		this.iznos = iznos;
		this.datum = datum;
	}

	/**
	 * @return the iznos
	 */
	public double getIznos() {
		return iznos;
	}

	/**
	 * @param iznos the iznos to set
	 */
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	/**
	 * @return the kartica
	 */
	public Kartica getKartica() {
		return kartica;
	}

	/**
	 * @param kartica the kartica to set
	 */
	public void setKartica(Kartica kartica) {
		this.kartica = kartica;
	}

	/**
	 * @return the datum
	 */
	public LocalDate getDatum() {
		return datum;
	}

	/**
	 * @param datum the datum to set
	 */
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	/**
	 * @return the placena
	 */
	public boolean isPlacena() {
		return placena;
	}

	/**
	 * @param placena the placena to set
	 */
	public void setPlacena(boolean placena) {
		this.placena = placena;
	}

	@Override
	public String toString() {
		return "Faktura [iznos=" + iznos + ", kartica=" + kartica + ", datum=" + datum + ", placena=" + placena + "]";
	}

	/**
	 * Placanje fakture zadatom karticom.
	 * Pravo na placanje dobija samo prva kartica koja preuzme dozvolu semafora,
	 * dok se svim ostalim karticama placanje odmah odbija.
	 * Kartica mora biti uvezana za neki tekuci racun.
	 * Placanje traje 2 sekunde i uspesno je samo ako se uneseni CVC kod
	 * poklapa sa CVC kodom kartice.
	 * @param kartica - kartica kojom se pokusava placanje
	 * @param uneseniCvc - CVC kod koji je korisnik uneo
	 * @return true ako je placanje uspesno, u suprotnom false
	 */
	public boolean plati(Kartica kartica, int uneseniCvc) {
		if (!semafor.tryAcquire()) {
			System.out.println("Kartica " + kartica.getBroj() + " ne moze da plati fakturu od " + iznos
					+ " jer je placanje vec preuzela druga kartica!");
			return false;
		}
		System.out.println("Kartica " + kartica.getBroj() + " je preuzela placanje fakture od " + iznos + "!");

		if (kartica.getTekuciRacun() == null) {
			System.out.println("Kartica " + kartica.getBroj()
					+ " nije uvezana ni za jedan tekuci racun - placanje je neuspesno!");
			return false;
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (kartica.getCvc() != uneseniCvc) {
			System.out.println("Uneseni CVC kod za karticu " + kartica.getBroj()
					+ " nije ispravan - placanje je neuspesno!");
			return false;
		}

		this.kartica = kartica;
		this.placena = true;
		kartica.getTekuciRacun().umanjiStanje(iznos);
		System.out.println("Placanje fakture od " + iznos + " karticom " + kartica.getBroj()
				+ " je uspesno! Novo stanje racuna " + kartica.getTekuciRacun().getJedinstveniBroj() + " je "
				+ kartica.getTekuciRacun().getStanje() + ".");
		return true;
	}
}
