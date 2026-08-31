/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Klasa koja predstavlja konkurs jednog deteta za upis u vrtic.
 * Za jedno dete se formira jedan konkurs, ali se moze konkurisati u najvise tri vrtica.
 * Posto oba staratelja istog deteta mogu istovremeno da konkurisu, izbor vrtica
 * se stiti semaforom sa jednom dozvolom.
 */
public class Konkurs {
	/**
	 * Najveci broj vrtica u koje se moze konkurisati jednim konkursom.
	 */
	public static final int MAKS_VRTICA = 3;

	private Dete dete;
	private List<Vrtic> vrtici = new ArrayList<>();
	private Vrtic primljenUVrtic;

	private final Semaphore semafor = new Semaphore(1);

	/**
	 * Podrazumevani konstruktor klase Konkurs.
	 */
	public Konkurs() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Konkurs.
	 * Vrtic u koji je dete primljeno je na pocetku nedefinisan.
	 * @param dete - dete za koje se konkurise
	 */
	public Konkurs(Dete dete) {
		super();
		this.dete = dete;
	}

	/**
	 * @return the dete
	 */
	public Dete getDete() {
		return dete;
	}

	/**
	 * @param dete the dete to set
	 */
	public void setDete(Dete dete) {
		this.dete = dete;
	}

	/**
	 * @return the vrtici
	 */
	public List<Vrtic> getVrtici() {
		return vrtici;
	}

	/**
	 * @param vrtici the vrtici to set
	 */
	public void setVrtici(List<Vrtic> vrtici) {
		this.vrtici = vrtici;
	}

	/**
	 * @return the primljenUVrtic
	 */
	public Vrtic getPrimljenUVrtic() {
		return primljenUVrtic;
	}

	/**
	 * @param primljenUVrtic the primljenUVrtic to set
	 */
	public void setPrimljenUVrtic(Vrtic primljenUVrtic) {
		this.primljenUVrtic = primljenUVrtic;
	}

	@Override
	public String toString() {
		return "Konkurs [dete=" + dete + ", vrtici=" + vrtici + ", primljenUVrtic=" + primljenUVrtic + "]";
	}

	/**
	 * Dodavanje vrtica u konkurs.
	 * Vrtic se ne dodaje ako je vec dostignut najveci broj vrtica
	 * ili ako je taj vrtic vec izabran.
	 * @param vrtic - vrtic koji se dodaje u konkurs
	 * @return true ako je vrtic dodat, u suprotnom false
	 */
	public boolean dodajVrtic(Vrtic vrtic) {
		if (vrtici.size() >= MAKS_VRTICA) {
			return false;
		}
		if (vrtici.contains(vrtic)) {
			return false;
		}
		return vrtici.add(vrtic);
	}

	/**
	 * Uklanjanje vrtica iz konkursa.
	 * @param vrtic - vrtic koji se uklanja iz konkursa
	 * @return true ako je vrtic uklonjen, u suprotnom false
	 */
	public boolean ukloniVrtic(Vrtic vrtic) {
		return vrtici.remove(vrtic);
	}

	/**
	 * Konkurisanje staratelja za svoje dete u zadatom vrticu.
	 * Konkurisanje je izbor vrtica u koji staratelj zeli da upise dete.
	 * Semafor obezbedjuje da u jednom trenutku samo jedan staratelj menja konkurs,
	 * cime se postuje ogranicenje od najvise tri vrtica.
	 * @param vrtic - vrtic u koji se konkurise
	 * @return true ako je konkurisanje uspesno, u suprotnom false
	 */
	public boolean konkurisi(Vrtic vrtic) {
		try {
			semafor.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		try {
			System.out.println("Staratelj niti " + Thread.currentThread().getName() + " konkurise za dete "
					+ dete.getIme() + " " + dete.getPrezime() + " u vrticu " + vrtic.getIme() + "!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			boolean uspesno = dodajVrtic(vrtic);
			if (uspesno) {
				System.out.println("Vrtic " + vrtic.getIme() + " je dodat u konkurs deteta " + dete.getIme() + " "
						+ dete.getPrezime() + " (izabrano vrtica: " + vrtici.size() + "/" + MAKS_VRTICA + ").");
			} else {
				System.out.println("Vrtic " + vrtic.getIme() + " nije dodat u konkurs deteta " + dete.getIme() + " "
						+ dete.getPrezime() + " (vec je izabran ili je dostignut maksimum od " + MAKS_VRTICA
						+ " vrtica).");
			}
			return uspesno;
		} finally {
			semafor.release();
		}
	}

	/**
	 * Upis deteta nakon zavrsenog konkurisanja.
	 * Dete se prima u prvi vrtic koji je odabran.
	 */
	public void upisiDete() {
		if (vrtici.isEmpty()) {
			System.out.println("Za dete " + dete.getIme() + " " + dete.getPrezime()
					+ " nije konkurisano ni u jedan vrtic!");
			return;
		}
		primljenUVrtic = vrtici.get(0);
		System.out.println("Dete " + dete.getIme() + " " + dete.getPrezime() + " je primljeno u vrtic "
				+ primljenUVrtic.getIme() + "!");
	}
}
