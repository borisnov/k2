/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

/**
 * Klasa koja predstavlja vrtic u koji se dete upisuje.
 */
public class Vrtic {
	private String ime;
	private String adresa;
	private String brojTelefona;

	/**
	 * Podrazumevani konstruktor klase Vrtic.
	 */
	public Vrtic() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Vrtic.
	 * @param ime - ime vrtica
	 * @param adresa - adresa vrtica
	 * @param brojTelefona - broj telefona vrtica
	 */
	public Vrtic(String ime, String adresa, String brojTelefona) {
		super();
		this.ime = ime;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
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

	@Override
	public String toString() {
		return "Vrtic [ime=" + ime + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + "]";
	}
}
