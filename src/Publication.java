import java.util.ArrayList;

public abstract class Publication {
	public static int id_pb;
	public String contenu;
	ArrayList<Commentaire> commentaire;
	public int idUtilisateur;
	public int pb_id;
	
	public Publication() {
		id_pb++;
		commentaire = new ArrayList<>();
		pb_id = id_pb;
	}
	
	public Publication(String contenu) {
		id_pb++;
		this.contenu = contenu;
		commentaire = new ArrayList<>();
		pb_id = id_pb;
	}
	public void ajouter_pb() {
		
	}
	
	public abstract void modifier(int id);
	public abstract void consulter(int id);
	public abstract void supprimer(int id);
	public abstract void noti_Pb(int id);
	
}
