/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

/**
 * Klasa koja predstavlja staratelja deteta.
 * Staratelj konkurise za svoje dete u vrtice.
 */
public class Staratelj {
	/**
	 * Ime staratelja.
	 */
	protected String ime;
	/**
	 * Prezime staratelja.
	 */
	protected String prezime;
	/**
	 * Jedinstveni maticni broj gradjana.
	 */
	protected String jmbg;
	/**
	 * Broj licne karte staratelja.
	 */
	protected String brojLicneKarte;
	/**
	 * Broj telefona staratelja.
	 */
	protected String brojTelefona;
	/**
	 * Adresa stanovanja staratelja.
	 */
	protected String adresa;

	/**
	 * Podrazumevani konstruktor klase Staratelj.
	 */
	public Staratelj() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Staratelj.
	 * @param ime - ime staratelja
	 * @param prezime - prezime staratelja
	 * @param jmbg - jedinstveni maticni broj gradjana
	 * @param brojLicneKarte - broj licne karte staratelja
	 * @param brojTelefona - broj telefona staratelja
	 * @param adresa - adresa stanovanja staratelja
	 */
	public Staratelj(String ime, String prezime, String jmbg, String brojLicneKarte, String brojTelefona,
			String adresa) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.brojLicneKarte = brojLicneKarte;
		this.brojTelefona = brojTelefona;
		this.adresa = adresa;
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
	 * @return the adresa
	 */
	public String getAdresa() {
		return adresa;
	}

	/**
	 * @param adresa the adresa to set
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	@Override
	public String toString() {
		return "Staratelj [ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", brojLicneKarte="
				+ brojLicneKarte + ", brojTelefona=" + brojTelefona + ", adresa=" + adresa + "]";
	}
}
