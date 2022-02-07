import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Commentaire {
	public static int id_cm;
	public String contenu_Cm;
	public LocalDate date_Cm;
	int cm_id;
	Scanner sc = new Scanner(System.in);
	public Commentaire() {
		id_cm++;
		date_Cm = LocalDate.now();
		cm_id = id_cm;
	}
	public Commentaire(String contenu) {
		this.contenu_Cm = contenu;
		id_cm++;
		date_Cm = LocalDate.now();
	}
	
	public void ajouter(int id_pb) {
		System.out.println(" Donner le contenue du message");
		contenu_Cm = sc.next();
		date_Cm = LocalDate.now();
		for(int i = 0;i< bd.publication.size();i++) {
			if(bd.publication.get(i).commentaire.add(this));
		}
		
		
	}
	public void modifier_cm(int id) {
		
		
	}
	public void Supprimer_cm() {
		
	}
}
