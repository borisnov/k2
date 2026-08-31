/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa za simulaciju konkurentnosti staratelja pri konkurisanju u vrtice.
 */
public class KonkurentniStaratelj extends Staratelj implements Runnable {
	private Konkurs konkurs;
	private List<Vrtic> izabraniVrtici = new ArrayList<>();

	/**
	 * Podrazumevani konstruktor klase KonkurentniStaratelj.
	 */
	public KonkurentniStaratelj() {
		super();
	}

	/**
	 * @return the konkurs
	 */
	public Konkurs getKonkurs() {
		return konkurs;
	}

	/**
	 * @param konkurs the konkurs to set
	 */
	public void setKonkurs(Konkurs konkurs) {
		this.konkurs = konkurs;
	}

	/**
	 * @return the izabraniVrtici
	 */
	public List<Vrtic> getIzabraniVrtici() {
		return izabraniVrtici;
	}

	/**
	 * @param izabraniVrtici the izabraniVrtici to set
	 */
	public void setIzabraniVrtici(List<Vrtic> izabraniVrtici) {
		this.izabraniVrtici = izabraniVrtici;
	}

	/**
	 * Dodavanje vrtica u listu vrtica u koje ovaj staratelj zeli da konkurise.
	 * @param vrtic - vrtic koji staratelj bira
	 */
	public void izaberiVrtic(Vrtic vrtic) {
		izabraniVrtici.add(vrtic);
	}

	@Override
	public void run() {
		for (Vrtic v : izabraniVrtici) {
			konkurs.konkurisi(v);
		}
	}

}
