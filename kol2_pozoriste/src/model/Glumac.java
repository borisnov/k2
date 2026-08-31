/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

/**
 * Klasa koja predstavlja glumca koji igra neku ulogu u predstavi.
 */
public class Glumac {
	private String ime;
	private String prezime;

	/**
	 * Podrazumevani konstruktor klase Glumac.
	 */
	public Glumac() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Glumac.
	 * @param ime - ime glumca
	 * @param prezime - prezime glumca
	 */
	public Glumac(String ime, String prezime) {
		super();
		this.ime = ime;
		this.prezime = prezime;
	}

	/**
	 * @return the ime
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * @param ime the ime to set
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * @return the prezime
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * @param prezime the prezime to set
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return "Glumac [ime=" + ime + ", prezime=" + prezime + "]";
	}
}
