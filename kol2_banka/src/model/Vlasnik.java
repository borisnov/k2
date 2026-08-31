/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

/**
 * Klasa koja predstavlja vlasnika tekuceg racuna.
 */
public class Vlasnik {
	private String ime;
	private String prezime;
	private String jmbg;
	private String brojTelefona;
	private String brojLicneKarte;

	/**
	 * Podrazumevani konstruktor klase Vlasnik.
	 */
	public Vlasnik() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Vlasnik.
	 * @param ime - ime vlasnika
	 * @param prezime - prezime vlasnika
	 * @param jmbg - jedinstveni maticni broj gradjana
	 * @param brojTelefona - broj telefona vlasnika
	 * @param brojLicneKarte - broj licne karte vlasnika
	 */
	public Vlasnik(String ime, String prezime, String jmbg, String brojTelefona, String brojLicneKarte) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.brojTelefona = brojTelefona;
		this.brojLicneKarte = brojLicneKarte;
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
	 * @return the jmbg
	 */
	public String getJmbg() {
		return jmbg;
	}

	/**
	 * @param jmbg the jmbg to set
	 */
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	/**
	 * @return the brojTelefona
	 */
	public String getBrojTelefona() {
		return brojTelefona;
	}

	/**
	 * @param brojTelefona the brojTelefona to set
	 */
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	/**
	 * @return the brojLicneKarte
	 */
	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	/**
	 * @param brojLicneKarte the brojLicneKarte to set
	 */
	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	@Override
	public String toString() {
		return "Vlasnik [ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", brojTelefona=" + brojTelefona
				+ ", brojLicneKarte=" + brojLicneKarte + "]";
	}
}
