import java.util.ArrayList;
import java.util.Scanner;

public class DemandeAjout extends Message implements bd{
	public int id_dm;
	ArrayList<String> rec = new ArrayList<>();
	Scanner sc;
	
	public DemandeAjout() {super();id_dm++;}
	public void accepter() {
		for(String s : rec) {
			//scanner prend message a dechiffrée
			String ch3 = s;
			sc = new Scanner(ch3);
			int ch1 = sc.nextInt();
			//System.out.println("message apres dechiffrage = " + ch1 );
			ch1 = sc.nextInt();
			//System.out.println("message apres dechiffrage = " + ch1 );
			System.out.println("Voulez-Vous Accepter cette utilisateur <oui> ou <non> --> id = "
					+ ch1);
			sc = new Scanner(System.in);
			String ch = sc.next();
			if(ch.equals("oui")) {
				ami.add(s);
				//System.out.println(s);
				System.out.println(" Utilisateur de l' id = " + ch1 + " est ajouter a la liste d'ami");
			}
			else
				 refuser(ch1);
				
		}
		
		
	}
	public void refuser(int i) {
		System.out.println(" Utilisateur de l' id = " + i  + " n'est pas ajouter a la liste d'ami");
		
	}
	public void envoyer_m() {
		
	}
	@Override
	public void recevoir_m(int ut) {
		
		//System.out.println(msg.size());
		for(String s : msg) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(s);
			String ch = sc.next();
			//System.out.println(ch);
			//System.out.println("Fonction recvoir chaine apres dechifrage" + ch);
			if(Integer.parseInt(ch) == ut) {
				rec.add(s);
			}	
		}
		
	}
	@Override
	public void supprimer_m(int ut) {
		for(int i=0;i<msg.size();i++) {
			Scanner sc = new Scanner(msg.get(i));
			String ch = sc.next();
			//System.out.println(ch);
			//System.out.println("Fonction recvoir chaine apres dechifrage" + ch);
			if(Integer.parseInt(ch) == ut) {
				msg.remove(i);
			}	
		}
		
	}
	@Override
	public int notification() {
		int n = 0;
			System.out.println("vous avez " + rec.size() + " notification de demande d'ajout");
			n = rec.size();
		return n;
	}
	@Override
	public void Ajouter_ami() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void demandeAjout() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void voirAmi() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void miseJour() {
		// TODO Auto-generated method stub
		
	}

	

}
