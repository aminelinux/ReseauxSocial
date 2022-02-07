import java.util.Scanner;

public class Photo extends Publication{
	public static int id_ph;
	//gif,png ....
	public String extension;
	//web address
	public String contenu;
	Scanner sc;
	//constructor
	public Photo() {
		super();
		id_ph++;
	}
	public Photo(String extension,String contenu) {
		super();
		this.contenu = contenu;
		this.extension = extension;
		id_ph++;
	}
	public void ajouter() {
		bd.publication.add(this);
	}
	@Override
	public void modifier(int id) {
		if(this.idUtilisateur == id) {
			System.out.println("modifier le contenue de la photo");
			this.contenu = sc.next();
			System.out.println("modifier l'extension");
			this.extension = sc.next();
		
	}
		
	}
	@Override
	public void consulter(int id) {
		for(int i=0;i<bd.publication.size();i++) {
			if(bd.publication.get(i).getClass() == Video.class && bd.publication.get(i).idUtilisateur == id) {
				System.out.println("user id = " + id);
				System.out.println("Publication: \n" + this.contenu);
				System.out.println("---------------------------------------------------");
			}
		}
		
	}
	@Override
	public void supprimer(int id) {
		
		
	}
	@Override
	public void noti_Pb(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
