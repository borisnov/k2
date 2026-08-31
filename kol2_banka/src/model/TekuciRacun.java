/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Klasa koja predstavlja tekuci racun vlasnika sa karticama koje su za njega uvezane.
 * Posto vise kartica istog racuna moze istovremeno da plati razlicite fakture,
 * promena stanja se stiti zakljucavanjem (ReentrantLock).
 */
public class TekuciRacun {
	private String jedinstveniBroj;
	private Vrsta vrsta;
	private Vlasnik vlasnik;
	private List<Kartica> kartice = new ArrayList<>();
	private double stanje;

	private final ReentrantLock rl = new ReentrantLock();

	/**
	 * Podrazumevani konstruktor klase TekuciRacun.
	 */
	public TekuciRacun() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase TekuciRacun.
	 * @param jedinstveniBroj - jedinstveni broj tekuceg racuna
	 * @param vrsta - vrsta racuna (dinarski ili devizni)
	 * @param vlasnik - vlasnik tekuceg racuna
	 * @param stanje - novcani iznos za raspolaganje
	 */
	public TekuciRacun(String jedinstveniBroj, Vrsta vrsta, Vlasnik vlasnik, double stanje) {
		super();
		this.jedinstveniBroj = jedinstveniBroj;
		this.vrsta = vrsta;
		this.vlasnik = vlasnik;
		this.stanje = stanje;
	}

	/**
	 * @return the jedinstveniBroj
	 */
	public String getJedinstveniBroj() {
		return jedinstveniBroj;
	}

	/**
	 * @param jedinstveniBroj the jedinstveniBroj to set
	 */
	public void setJedinstveniBroj(String jedinstveniBroj) {
		this.jedinstveniBroj = jedinstveniBroj;
	}

	/**
	 * @return the vrsta
	 */
	public Vrsta getVrsta() {
		return vrsta;
	}

	/**
	 * @param vrsta the vrsta to set
	 */
	public void setVrsta(Vrsta vrsta) {
		this.vrsta = vrsta;
	}

	/**
	 * @return the vlasnik
	 */
	public Vlasnik getVlasnik() {
		return vlasnik;
	}

	/**
	 * @param vlasnik the vlasnik to set
	 */
	public void setVlasnik(Vlasnik vlasnik) {
		this.vlasnik = vlasnik;
	}

	/**
	 * @return the kartice
	 */
	public List<Kartica> getKartice() {
		return kartice;
	}

	/**
	 * @param kartice the kartice to set
	 */
	public void setKartice(List<Kartica> kartice) {
		this.kartice = kartice;
	}

	/**
	 * @return the stanje
	 */
	public double getStanje() {
		return stanje;
	}

	/**
	 * @param stanje the stanje to set
	 */
	public void setStanje(double stanje) {
		this.stanje = stanje;
	}

	@Override
	public String toString() {
		return "TekuciRacun [jedinstveniBroj=" + jedinstveniBroj + ", vrsta=" + vrsta + ", vlasnik=" + vlasnik
				+ ", kartice=" + kartice + ", stanje=" + stanje + "]";
	}

	/**
	 * Dodavanje kartice na tekuci racun. Kartica se time uvezuje za ovaj racun.
	 * @param kartica - kartica koja se dodaje
	 */
	public void dodajKarticu(Kartica kartica) {
		kartice.add(kartica);
		kartica.setTekuciRacun(this);
	}

	/**
	 * Uklanjanje kartice sa tekuceg racuna. Kartica time vise nije uvezana ni za jedan racun.
	 * @param kartica - kartica koja se uklanja
	 */
	public void ukloniKarticu(Kartica kartica) {
		kartice.remove(kartica);
		kartica.setTekuciRacun(null);
	}

	/**
	 * Umanjenje stanja na racunu za placeni iznos.
	 * Operacija je zasticena zakljucavanjem kako dve kartice istog racuna
	 * ne bi istovremeno menjale stanje i time izgubile jednu izmenu.
	 * @param iznos - iznos koji se skida sa racuna
	 */
	public void umanjiStanje(double iznos) {
		rl.lock();
		try {
			stanje = stanje - iznos;
		} finally {
			rl.unlock();
		}
	}
}
