/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

/**
 * Klasa koja predstavlja jednu ulogu u predstavi koju tumaci jedan glumac.
 */
public class Uloga {
	private String naziv;
	private TipUloge tip;
	private Glumac glumac;

	/**
	 * Podrazumevani konstruktor klase Uloga.
	 */
	public Uloga() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Uloga.
	 * @param naziv - naziv uloge
	 * @param tip - tip uloge (glavna ili sporedna)
	 * @param glumac - glumac koji tumaci ulogu
	 */
	public Uloga(String naziv, TipUloge tip, Glumac glumac) {
		super();
		this.naziv = naziv;
		this.tip = tip;
		this.glumac = glumac;
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
	 * @return the tip
	 */
	public TipUloge getTip() {
		return tip;
	}

	/**
	 * @param tip the tip to set
	 */
	public void setTip(TipUloge tip) {
		this.tip = tip;
	}

	/**
	 * @return the glumac
	 */
	public Glumac getGlumac() {
		return glumac;
	}

	/**
	 * @param glumac the glumac to set
	 */
	public void setGlumac(Glumac glumac) {
		this.glumac = glumac;
	}

	@Override
	public String toString() {
		return "Uloga [naziv=" + naziv + ", tip=" + tip + ", glumac=" + glumac + "]";
	}
}
