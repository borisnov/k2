/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Klasa koja predstavlja pozorisnu predstavu sa ulogama koje u njoj ucestvuju.
 * Ista predstava moze biti na repertoaru najvise dva pozorista i u isto vreme
 * se emitovati, pa se za sinhronizaciju koristi semafor sa dve dozvole.
 */
public class Predstava {
	/**
	 * Najveci broj pozorista u kojima se predstava moze prikazivati u isto vreme.
	 */
	public static final int MAKS_ISTOVREMENIH_PRIKAZIVANJA = 2;

	private String naziv;
	private List<Uloga> uloge = new ArrayList<>();

	private final Semaphore semafor = new Semaphore(MAKS_ISTOVREMENIH_PRIKAZIVANJA);

	/**
	 * Podrazumevani konstruktor klase Predstava.
	 */
	public Predstava() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Predstava.
	 * @param naziv - naziv predstave
	 * @param uloge - uloge koje ucestvuju u predstavi
	 */
	public Predstava(String naziv, List<Uloga> uloge) {
		super();
		this.naziv = naziv;
		this.uloge = uloge;
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
	 * @return the uloge
	 */
	public List<Uloga> getUloge() {
		return uloge;
	}

	/**
	 * @param uloge the uloge to set
	 */
	public void setUloge(List<Uloga> uloge) {
		this.uloge = uloge;
	}

	@Override
	public String toString() {
		return "Predstava [naziv=" + naziv + ", uloge=" + uloge + "]";
	}

	/**
	 * Dodavanje uloge u predstavu.
	 * @param uloga - uloga koja se dodaje
	 */
	public void dodajUlogu(Uloga uloga) {
		uloge.add(uloga);
	}

	/**
	 * Uklanjanje uloge iz predstave.
	 * @param uloga - uloga koja se uklanja
	 */
	public void ukloniUlogu(Uloga uloga) {
		uloge.remove(uloga);
	}

	/**
	 * Zauzimanje jednog od dva termina za istovremeno prikazivanje predstave.
	 * Ako su oba termina zauzeta, pozoriste ceka da se neki oslobodi.
	 */
	public void pocniPrikazivanje() {
		try {
			semafor.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Oslobadjanje termina za prikazivanje predstave, cime se omogucava
	 * prikazivanje u nekom drugom pozoristu.
	 */
	public void zavrsiPrikazivanje() {
		semafor.release();
	}
}
