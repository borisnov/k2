/**
 * @author Boris Novakovic
 * @date 31. 8. 2026.
 */
package main;

import model.Dete;
import model.Konkurs;
import model.KonkurentniStaratelj;
import model.Vrtic;

/**
 * Glavna aplikacija u kojoj se simuliraju tri vrtica, cetiri staratelja i dvoje dece.
 * Oba staratelja jednog deteta konkurisu istovremeno na istom konkursu,
 * a nakon konkurisanja se deca primaju u prvi vrtic koji je odabran.
 */
public class Aplikacija {

	/**
	 * Podrazumevani konstruktor klase Aplikacija.
	 */
	public Aplikacija() {
		super();
	}

	/**
	 * Pokretanje simulacije.
	 * @param args - argumenti komandne linije (ne koriste se)
	 */
	public static void main(String[] args) {
		Vrtic v1 = new Vrtic("Bambi", "Kralja Petra I 12, Novi Sad", "021111222");
		Vrtic v2 = new Vrtic("Pcelica", "Bulevar cara Lazara 5, Novi Sad", "021333444");
		Vrtic v3 = new Vrtic("Duga", "Futoska 88, Novi Sad", "021555666");

		KonkurentniStaratelj s1 = new KonkurentniStaratelj();
		s1.setIme("Boris");
		s1.setPrezime("Novakovic");
		s1.setJmbg("0101999800011");
		s1.setBrojLicneKarte("008123456");
		s1.setBrojTelefona("0641234567");
		s1.setAdresa("Kralja Petra I 12, Novi Sad");

		KonkurentniStaratelj s2 = new KonkurentniStaratelj();
		s2.setIme("Milica");
		s2.setPrezime("Novakovic");
		s2.setJmbg("0202000805022");
		s2.setBrojLicneKarte("008123457");
		s2.setBrojTelefona("0649876543");
		s2.setAdresa("Kralja Petra I 12, Novi Sad");

		KonkurentniStaratelj s3 = new KonkurentniStaratelj();
		s3.setIme("Nikola");
		s3.setPrezime("Petrovic");
		s3.setJmbg("0303998800033");
		s3.setBrojLicneKarte("008123458");
		s3.setBrojTelefona("0631112223");
		s3.setAdresa("Futoska 45, Novi Sad");

		KonkurentniStaratelj s4 = new KonkurentniStaratelj();
		s4.setIme("Jelena");
		s4.setPrezime("Petrovic");
		s4.setJmbg("0404999805044");
		s4.setBrojLicneKarte("008123459");
		s4.setBrojTelefona("0664445556");
		s4.setAdresa("Futoska 45, Novi Sad");

		Dete d1 = new Dete("Luka", "Novakovic", s1, s2);
		Dete d2 = new Dete("Ana", "Petrovic", s3, s4);

		Konkurs k1 = new Konkurs(d1);
		Konkurs k2 = new Konkurs(d2);

		// Oba staratelja deteta Luka konkurisu na istom konkursu.
		s1.setKonkurs(k1);
		s1.izaberiVrtic(v1);
		s1.izaberiVrtic(v2);

		s2.setKonkurs(k1);
		s2.izaberiVrtic(v2);
		s2.izaberiVrtic(v3);

		// Oba staratelja deteta Ana konkurisu na istom konkursu.
		s3.setKonkurs(k2);
		s3.izaberiVrtic(v3);

		s4.setKonkurs(k2);
		s4.izaberiVrtic(v1);
		s4.izaberiVrtic(v2);
		s4.izaberiVrtic(v3);

		Thread n1 = new Thread(s1, s1.getIme() + " " + s1.getPrezime());
		Thread n2 = new Thread(s2, s2.getIme() + " " + s2.getPrezime());
		Thread n3 = new Thread(s3, s3.getIme() + " " + s3.getPrezime());
		Thread n4 = new Thread(s4, s4.getIme() + " " + s4.getPrezime());

		n1.start();
		n2.start();
		n3.start();
		n4.start();

		try {
			n1.join();
			n2.join();
			n3.join();
			n4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("Konkurisanje je zavrseno, vrsi se upis dece:");
		k1.upisiDete();
		k2.upisiDete();

		System.out.println();
		System.out.println("Stanje konkursa nakon upisa:");
		System.out.println(k1);
		System.out.println(k2);

	}

}
