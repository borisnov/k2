/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

/**
 * Klasa za simulaciju konkurentnosti kartica pri placanju fakture.
 */
public class KonkurentnaKartica extends Kartica implements Runnable {
	private Faktura faktura;
	private int uneseniCvc;

	/**
	 * Podrazumevani konstruktor klase KonkurentnaKartica.
	 */
	public KonkurentnaKartica() {
		super();
	}

	/**
	 * @return the faktura
	 */
	public Faktura getFaktura() {
		return faktura;
	}

	/**
	 * @param faktura the faktura to set
	 */
	public void setFaktura(Faktura faktura) {
		this.faktura = faktura;
	}

	/**
	 * @return the uneseniCvc
	 */
	public int getUneseniCvc() {
		return uneseniCvc;
	}

	/**
	 * @param uneseniCvc the uneseniCvc to set
	 */
	public void setUneseniCvc(int uneseniCvc) {
		this.uneseniCvc = uneseniCvc;
	}

	@Override
	public void run() {
		faktura.plati(this, uneseniCvc);
	}

}
