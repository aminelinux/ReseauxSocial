import java.util.ArrayList;

public interface bd  {
	
		
	//all Utilisateur here
	public  ArrayList<Utilisateur> utilisateur = new ArrayList<>();
	 //all admin here
	public  ArrayList<Adminstrateur> adminn = new ArrayList<>();
	//Friends here
	public  ArrayList<String> ami = new ArrayList<>();
	
	public  ArrayList<Publication> publication = new ArrayList<>();
	//all demande ajout msg here
	public  ArrayList<String> msg = new ArrayList<>();
	//all msg txt here
	public ArrayList<String> msgTxt = new ArrayList<>();
	
	public abstract void Ajouter_ami();
	public abstract void recevoir_m(int ut);
	public abstract int notification();
	public abstract void demandeAjout();
	public void supprimer_m(int ut);
	public abstract void accepter();
	public abstract void voirAmi();
	public abstract void miseJour();
	
}
