/**
 * @author Aleksandra Samardzic
 * @date 29. 4. 2026.
 */
package model;

/**
 * Klasa za simulaciju konkurentnosti uredjaja.
 */
public class KonkurentniUredjaj extends Uredjaj implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			super.pustiProgram();
		}
	}

}
