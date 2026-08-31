/**
 * @author Aleksandra Samardzic
 * @date 29. 4. 2026.
 */
package model;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Klasa koja predstavlja nalog korisnika za platforme koje se koriste na uredjaju.
 */
public class KorisnickiNalog {
	private int id;
	private String ime;
	private String prezime;
	private String email;
	
	private final ReentrantLock rl = new ReentrantLock();
	
	/**
	 * Podrazumevani konstruktor za KorisnickiNalog.
	 */
	public KorisnickiNalog() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Konstruktor sa parametrima klase KorisnickiNalog.
	 * @param id - jedinstveni broj korisnika
	 * @param ime - ime korisnika
	 * @param prezime - prezime korisnika
	 * @param email - email korisnika
	 */
	public KorisnickiNalog(int id, String ime, String prezime, String email) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "KorisnickiNalog [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + "]";
	}
	
	/**
	 * Prijavljanjem se onemoguacava prijava na drugim uredjajima za isti korisnicki nalog.
	 */
	public void prijaviSe() {
		rl.lock();
	}
	
	/**
	 * Odjavljivanjem se omoguacava prijava na drugim uredjajima za isti korisnicki nalog.
	 */
	public void odjaviSe() {
		rl.unlock();
	}
}
