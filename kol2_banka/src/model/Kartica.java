/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

import java.time.LocalDate;

/**
 * Klasa koja predstavlja platnu karticu uvezanu za neki tekuci racun.
 */
public class Kartica {
	/**
	 * Broj kartice.
	 */
	protected String broj;
	/**
	 * Datum do kog kartica vazi.
	 */
	protected LocalDate rokVazenja;
	/**
	 * Sigurnosni CVC kod kartice.
	 */
	protected int cvc;

	/**
	 * Tekuci racun za koji je kartica uvezana.
	 */
	protected TekuciRacun tekuciRacun;

	/**
	 * Podrazumevani konstruktor klase Kartica.
	 */
	public Kartica() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Kartica.
	 * @param broj - broj kartice
	 * @param rokVazenja - datum do kog kartica vazi
	 * @param cvc - sigurnosni CVC kod kartice
	 */
	public Kartica(String broj, LocalDate rokVazenja, int cvc) {
		super();
		this.broj = broj;
		this.rokVazenja = rokVazenja;
		this.cvc = cvc;
	}

	/**
	 * @return the broj
	 */
	public String getBroj() {
		return broj;
	}

	/**
	 * @param broj the broj to set
	 */
	public void setBroj(String broj) {
		this.broj = broj;
	}

	/**
	 * @return the rokVazenja
	 */
	public LocalDate getRokVazenja() {
		return rokVazenja;
	}

	/**
	 * @param rokVazenja the rokVazenja to set
	 */
	public void setRokVazenja(LocalDate rokVazenja) {
		this.rokVazenja = rokVazenja;
	}

	/**
	 * @return the cvc
	 */
	public int getCvc() {
		return cvc;
	}

	/**
	 * @param cvc the cvc to set
	 */
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	/**
	 * @return the tekuciRacun
	 */
	public TekuciRacun getTekuciRacun() {
		return tekuciRacun;
	}

	/**
	 * @param tekuciRacun the tekuciRacun to set
	 */
	public void setTekuciRacun(TekuciRacun tekuciRacun) {
		this.tekuciRacun = tekuciRacun;
	}

	// U toString se ispisuje samo broj tekuceg racuna, a ne ceo objekat,
	// jer bi u suprotnom doslo do beskonacnog rekurzivnog ispisa.
	@Override
	public String toString() {
		return "Kartica [broj=" + broj + ", rokVazenja=" + rokVazenja + ", cvc=" + cvc + ", tekuciRacun="
				+ (tekuciRacun == null ? "nije uvezana" : tekuciRacun.getJedinstveniBroj()) + "]";
	}
}
