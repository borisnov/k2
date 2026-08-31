/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

/**
 * Klasa za simulaciju konkurentnosti teretana.
 */
public class KonkurentnaTeretana extends Teretana implements Runnable {

	/**
	 * Podrazumevani konstruktor klase KonkurentnaTeretana.
	 */
	public KonkurentnaTeretana() {
		super();
	}

	@Override
	public void run() {
		while (true) {
			super.trenira();
		}
	}

}
