/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

/**
 * Klasa koja predstavlja dete koje se upisuje u vrtic.
 * Dete ima tacno dva staratelja.
 */
public class Dete {
	private String ime;
	private String prezime;
	private Staratelj prviStaratelj;
	private Staratelj drugiStaratelj;

	/**
	 * Podrazumevani konstruktor klase Dete.
	 */
	public Dete() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Dete.
	 * @param ime - ime deteta
	 * @param prezime - prezime deteta
	 * @param prviStaratelj - prvi staratelj deteta
	 * @param drugiStaratelj - drugi staratelj deteta
	 */
	public Dete(String ime, String prezime, Staratelj prviStaratelj, Staratelj drugiStaratelj) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.prviStaratelj = prviStaratelj;
		this.drugiStaratelj = drugiStaratelj;
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

	/**
	 * @return the prviStaratelj
	 */
	public Staratelj getPrviStaratelj() {
		return prviStaratelj;
	}

	/**
	 * @param prviStaratelj the prviStaratelj to set
	 */
	public void setPrviStaratelj(Staratelj prviStaratelj) {
		this.prviStaratelj = prviStaratelj;
	}

	/**
	 * @return the drugiStaratelj
	 */
	public Staratelj getDrugiStaratelj() {
		return drugiStaratelj;
	}

	/**
	 * @param drugiStaratelj the drugiStaratelj to set
	 */
	public void setDrugiStaratelj(Staratelj drugiStaratelj) {
		this.drugiStaratelj = drugiStaratelj;
	}

	@Override
	public String toString() {
		return "Dete [ime=" + ime + ", prezime=" + prezime + ", prviStaratelj=" + prviStaratelj + ", drugiStaratelj="
				+ drugiStaratelj + "]";
	}
}
