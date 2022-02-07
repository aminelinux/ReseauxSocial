import java.util.Scanner;

public class Video extends Publication  {
	public static int id_vd;
	
	public String extension;
	public String contenu;
	Scanner sc;
	public Video() {
		super();
		id_vd++;
	}
	public Video(String extension,String contenu) {
		super();
		this.contenu = contenu;
		this.extension = extension;
		id_vd++;
	}
	public void ajouter() {
		bd.publication.add(this);
	}
	@Override
	public void modifier(int id) {
		if(this.idUtilisateur == id) {
			System.out.println("modifier le contenue de la video");
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void noti_Pb(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
