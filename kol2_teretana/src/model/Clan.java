/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

/**
 * Klasa koja predstavlja clana teretane.
 * Clan se prijavljuje i odjavljuje svojom clanskom kartom.
 */
public class Clan {
	private ClanskaKarta clanskaKarta;
	private String email;
	private String brojTelefona;

	/**
	 * Podrazumevani konstruktor za Clan.
	 */
	public Clan() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Clan.
	 * @param clanskaKarta - clanska karta clana
	 * @param email - email adresa clana
	 * @param brojTelefona - broj telefona clana
	 */
	public Clan(ClanskaKarta clanskaKarta, String email, String brojTelefona) {
		super();
		this.clanskaKarta = clanskaKarta;
		this.email = email;
		this.brojTelefona = brojTelefona;
	}

	/**
	 * @return the clanskaKarta
	 */
	public ClanskaKarta getClanskaKarta() {
		return clanskaKarta;
	}

	/**
	 * @param clanskaKarta the clanskaKarta to set
	 */
	public void setClanskaKarta(ClanskaKarta clanskaKarta) {
		this.clanskaKarta = clanskaKarta;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
		return "Clan [clanskaKarta=" + clanskaKarta + ", email=" + email + ", brojTelefona=" + brojTelefona + "]";
	}

	/**
	 * Prijava clana svojom clanskom kartom.
	 * Prijavom se onemogucava prijava u drugim teretanama u to vreme.
	 */
	public void prijaviSe() {
		clanskaKarta.prijaviSe();
	}

	/**
	 * Odjava clana svojom clanskom kartom.
	 * Odjavom se omogucava prijava u drugim teretanama.
	 */
	public void odjaviSe() {
		clanskaKarta.odjaviSe();
	}
}
