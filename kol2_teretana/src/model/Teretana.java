/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

/**
 * Klasa predstavlja teretanu u kojoj clan trenira.
 * Za potrebe zadatka u teretani moze trenirati samo jedan clan.
 */
public class Teretana {
	/**
	 * Naziv teretane.
	 */
	protected String naziv;
	/**
	 * Poreski identifikacioni broj teretane.
	 */
	protected String pib;
	/**
	 * Maticni broj teretane.
	 */
	protected String maticniBroj;
	/**
	 * Adresa teretane.
	 */
	protected String adresa;
	/**
	 * Radno vreme teretane.
	 */
	protected String radnoVreme;

	/**
	 * Clan koji trenira u teretani.
	 */
	protected Clan clan;

	/**
	 * Podrazumevani konstruktor klase Teretana.
	 */
	public Teretana() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Teretana.
	 * @param naziv - naziv teretane
	 * @param pib - poreski identifikacioni broj teretane
	 * @param maticniBroj - maticni broj teretane
	 * @param adresa - adresa teretane
	 * @param radnoVreme - radno vreme teretane
	 * @param clan - clan koji trenira u teretani
	 */
	public Teretana(String naziv, String pib, String maticniBroj, String adresa, String radnoVreme, Clan clan) {
		super();
		this.naziv = naziv;
		this.pib = pib;
		this.maticniBroj = maticniBroj;
		this.adresa = adresa;
		this.radnoVreme = radnoVreme;
		this.clan = clan;
	}

	/**
	 * @return the naziv
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * @param naziv the naziv to set
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	/**
	 * @return the pib
	 */
	public String getPib() {
		return pib;
	}

	/**
	 * @param pib the pib to set
	 */
	public void setPib(String pib) {
		this.pib = pib;
	}

	/**
	 * @return the maticniBroj
	 */
	public String getMaticniBroj() {
		return maticniBroj;
	}

	/**
	 * @param maticniBroj the maticniBroj to set
	 */
	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
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
	 * @return the radnoVreme
	 */
	public String getRadnoVreme() {
		return radnoVreme;
	}

	/**
	 * @param radnoVreme the radnoVreme to set
	 */
	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}

	/**
	 * @return the clan
	 */
	public Clan getClan() {
		return clan;
	}

	/**
	 * @param clan the clan to set
	 */
	public void setClan(Clan clan) {
		this.clan = clan;
	}

	@Override
	public String toString() {
		return "Teretana [naziv=" + naziv + ", pib=" + pib + ", maticniBroj=" + maticniBroj + ", adresa=" + adresa
				+ ", radnoVreme=" + radnoVreme + ", clan=" + clan + "]";
	}

	/**
	 * Trening clana u teretani.
	 * Clan se prvo prijavljuje svojom clanskom kartom, cime se onemogucava
	 * prijava u drugim teretanama u to vreme.
	 * Trening je operacija koja traje 15 sekundi (umesto minuta).
	 * Po zavrsetku treninga clan se odjavljuje sa svoje kartice.
	 */
	public void trenira() {
		System.out.println("Clan niti " + Thread.currentThread().getName() + " ceka na slobodnu clansku kartu!");
		clan.prijaviSe(); // acquire
		System.out.println("Trening clana niti " + Thread.currentThread().getName() + " je poceo!");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Clan niti " + Thread.currentThread().getName() + " oslobadja clansku kartu!");
		clan.odjaviSe(); // release
		System.out.println("Trening clana niti " + Thread.currentThread().getName() + " je zavrsen!");
	}
}
