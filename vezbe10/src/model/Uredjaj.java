/**
 * @author Aleksandra Samardzic
 * @date 29. 4. 2026.
 */
package model;

/**
 * Klasa predstavlja uredjaj na kojem se pusta i prekida sadrzaj sa korisnickog naloga.
 */
public class Uredjaj {
	protected int id;
	protected String ipAdresa;
	protected String naziv;
	
	protected KorisnickiNalog korisnickiNalog;
	

	/**
	 * Podrazumevani konstruktor klase Uredjaj.
	 */
	public Uredjaj() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Konstruktor sa parametrima klase Uredjaj.
	 * @param id - jedinstveni identifikator
	 * @param ipAdresa - IP adresa uredjaja konektovanog na mrezu
	 * @param naziv - naziv uredjaja
	 * @param korisnickiNalog - nalog koji je prijavljen na uredjaju
	 */
	public Uredjaj(int id, String ipAdresa, String naziv, KorisnickiNalog korisnickiNalog) {
		super();
		this.id = id;
		this.ipAdresa = ipAdresa;
		this.naziv = naziv;
		this.korisnickiNalog = korisnickiNalog;
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
	 * @return the ipAdresa
	 */
	public String getIpAdresa() {
		return ipAdresa;
	}

	/**
	 * @param ipAdresa the ipAdresa to set
	 */
	public void setIpAdresa(String ipAdresa) {
		this.ipAdresa = ipAdresa;
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

	// FIXME: Promena korisnickog naloga nije bezbedna konkurentno
	/**
	 * @return the korisnickiNalog
	 */
	public KorisnickiNalog getKorisnickiNalog() {
		return korisnickiNalog;
	}

	/**
	 * @param korisnickiNalog the korisnickiNalog to set
	 */
	public void setKorisnickiNalog(KorisnickiNalog korisnickiNalog) {
		this.korisnickiNalog = korisnickiNalog;
	}

	@Override
	public String toString() {
		return "Uredjaj [id=" + id + ", ipAdresa=" + ipAdresa + ", naziv=" + naziv + ", korisnickiNalog="
				+ korisnickiNalog + "]";
	}
	
	/**
	 * Pustanje programa na uredjaju za prijavljenog korisnika.
	 * Pustanje uredjaja je operacija koja traje 10 sekundi (simulacija rada programa).
	 * Po zavrsetku programa korisnik se odjaljuje sa uredjaja.
	 */
	public void pustiProgram() {
		System.out.println("Program niti " + Thread.currentThread().getName() + " zauzima nalog!");
		korisnickiNalog.prijaviSe(); // lock
		System.out.println("Program niti " + Thread.currentThread().getName() + " je pusten!");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Program niti " + Thread.currentThread().getName() + " otkljucava nalog!");
		korisnickiNalog.odjaviSe();  // unlock
		System.out.println("Program niti " + Thread.currentThread().getName() + " je zavrsen!");
	}
}
