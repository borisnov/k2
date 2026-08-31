/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja predstavlja pozoriste sa repertoarom predstava koje izvodi.
 */
public class Pozoriste {
	/**
	 * Naziv pozorista.
	 */
	protected String naziv;
	/**
	 * Adresa pozorista.
	 */
	protected String adresa;
	/**
	 * Radno vreme pozorista.
	 */
	protected String radnoVreme;

	/**
	 * Predstave koje pozoriste izvodi.
	 */
	protected List<Predstava> repertoar = new ArrayList<>();

	/**
	 * Podrazumevani konstruktor klase Pozoriste.
	 */
	public Pozoriste() {
		super();
	}

	/**
	 * Konstruktor sa parametrima klase Pozoriste.
	 * @param naziv - naziv pozorista
	 * @param adresa - adresa pozorista
	 * @param radnoVreme - radno vreme pozorista
	 * @param repertoar - predstave koje pozoriste izvodi
	 */
	public Pozoriste(String naziv, String adresa, String radnoVreme, List<Predstava> repertoar) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		this.radnoVreme = radnoVreme;
		this.repertoar = repertoar;
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
	 * @return the adresa
	 */
	public String getAdresa() {
		return adresa;
	}

	/**
	 * @param adresa the adresa to set
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	/**
	 * @return the radnoVreme
	 */
	public String getRadnoVreme() {
		return radnoVreme;
	}

	/**
	 * @param radnoVreme the radnoVreme to set
	 */
	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}

	/**
	 * @return the repertoar
	 */
	public List<Predstava> getRepertoar() {
		return repertoar;
	}

	/**
	 * @param repertoar the repertoar to set
	 */
	public void setRepertoar(List<Predstava> repertoar) {
		this.repertoar = repertoar;
	}

	@Override
	public String toString() {
		return "Pozoriste [naziv=" + naziv + ", adresa=" + adresa + ", radnoVreme=" + radnoVreme + ", repertoar="
				+ repertoar + "]";
	}

	/**
	 * Dodavanje predstave na repertoar pozorista.
	 * @param predstava - predstava koja se dodaje na repertoar
	 */
	public void dodajNaRepertoar(Predstava predstava) {
		repertoar.add(predstava);
	}

	/**
	 * Uklanjanje predstave sa repertoara pozorista.
	 * @param predstava - predstava koja se uklanja sa repertoara
	 */
	public void ukloniSaRepertoara(Predstava predstava) {
		repertoar.remove(predstava);
	}

	/**
	 * Prikazivanje predstave u pozoristu.
	 * Predstava se moze prikazati samo ako je na repertoaru ovog pozorista i
	 * ako je slobodan jedan od dva termina za istovremeno prikazivanje.
	 * Predstava traje 60 sekundi (umesto minuta).
	 * @param predstava - predstava koja se prikazuje
	 */
	public void prikaziPredstavu(Predstava predstava) {
		if (!repertoar.contains(predstava)) {
			System.out.println("Predstava " + predstava.getNaziv() + " nije na repertoaru pozorista " + naziv + "!");
			return;
		}
		System.out.println("Pozoriste niti " + Thread.currentThread().getName() + " ceka slobodan termin za predstavu "
				+ predstava.getNaziv() + "!");
		predstava.pocniPrikazivanje(); // acquire
		System.out.println("Predstava " + predstava.getNaziv() + " se prikazuje u pozoristu niti "
				+ Thread.currentThread().getName() + "!");
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Pozoriste niti " + Thread.currentThread().getName() + " oslobadja termin predstave "
				+ predstava.getNaziv() + "!");
		predstava.zavrsiPrikazivanje(); // release
		System.out.println("Predstava " + predstava.getNaziv() + " u pozoristu niti "
				+ Thread.currentThread().getName() + " je zavrsena!");
	}
}
