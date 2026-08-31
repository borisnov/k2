/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

/**
 * Klasa za simulaciju konkurentnosti pozorista.
 */
public class KonkurentnoPozoriste extends Pozoriste implements Runnable {

	/**
	 * Podrazumevani konstruktor klase KonkurentnoPozoriste.
	 */
	public KonkurentnoPozoriste() {
		super();
	}

	@Override
	public void run() {
		while (true) {
			for (Predstava p : super.getRepertoar()) {
				super.prikaziPredstavu(p);
			}
		}
	}

}
