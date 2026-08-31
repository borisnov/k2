/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

import java.util.concurrent.Semaphore;

/**
 * Klasa koja predstavlja clansku kartu clana teretane.
 * Karta je jedinstvena i moze se u jednom trenutku koristiti samo u jednoj teretani,
 * pa se za sinhronizaciju koristi semafor sa jednom dozvolom.
 */
public class ClanskaKarta {
	private int id;
	private String ime;
	private String prezime;
	private VrstaClanarine vrstaClanarine;

	private final Semaphore semafor = new Semaphore(1);

	/**
	 * Podrazumevani konstruktor za ClanskaKarta.
	 */
	public ClanskaKarta() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase ClanskaKarta.
	 * @param id - jedinstveni broj clanske karte
	 * @param ime - ime vlasnika karte
	 * @param prezime - prezime vlasnika karte
	 * @param vrstaClanarine - vrsta clanarine koja se placa
	 */
	public ClanskaKarta(int id, String ime, String prezime, VrstaClanarine vrstaClanarine) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.vrstaClanarine = vrstaClanarine;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the ime
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * @param ime the ime to set
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * @return the prezime
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * @param prezime the prezime to set
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	/**
	 * @return the vrstaClanarine
	 */
	public VrstaClanarine getVrstaClanarine() {
		return vrstaClanarine;
	}

	/**
	 * @param vrstaClanarine the vrstaClanarine to set
	 */
	public void setVrstaClanarine(VrstaClanarine vrstaClanarine) {
		this.vrstaClanarine = vrstaClanarine;
	}

	@Override
	public String toString() {
		return "ClanskaKarta [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", vrstaClanarine="
				+ vrstaClanarine + "]";
	}

	/**
	 * Prijavom karticom se zauzima jedina dozvola semafora, cime se
	 * onemogucava prijava istom karticom u drugim teretanama u to vreme.
	 */
	public void prijaviSe() {
		try {
			semafor.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Odjavom se dozvola semafora vraca, cime se omogucava prijava u drugim teretanama.
	 */
	public void odjaviSe() {
		semafor.release();
	}
}
