import java.util.ArrayList;
import java.util.function.Predicate;

public class Adminstrateur extends Utilisateur implements bd{
	public static int id_ad;
	public String login_ad;
	public  String pass_ad;
	
	
	public Adminstrateur() {
		id_ad++;
		bd.adminn.add(this);
	}
	public Adminstrateur(String login_ad,String pass_ad) {
		id_ad++;
		this.login_ad = login_ad;
		this.pass_ad = pass_ad;
		bd.adminn.add(this);
	}
	public void creer_compte() {
		bd.utilisateur.add(new Utilisateur("cc","cccc","cc","cc"));
	}
	public void supprimer_compte() {
		System.out.print("Donner le nom est les prenom de l'utilisateur");
		
		System.out.println("Donner le nom");
		String nom = sc.next();
		System.out.println("Donner le prenom");
		String prenom = sc.next();
		for(Utilisateur u : bd.utilisateur) {
			if(u.nom_ut.equals(nom) && u.prenom_ut.equals(prenom)) {
				System.out.println("id = " + u.ut_id + " nom= " + u.nom_ut + " Prenom"
						+ "= " + u.prenom_ut);
			}
			System.out.println("donner l'id de l'utilisateur a supprimer");
			var x = sc.nextInt();
			for(int i=0;i<bd.utilisateur.size();i++) {
				if(utilisateur.get(i).ut_id == x) {
					utilisateur.remove(i);
				}
			}
			
		}
		}
	public void compter_point() {
		
	}
	public void saveAccount() {
		
	}
	
	
	
}
