import java.util.Scanner;

public class Staut extends Publication{
	public static int id_st;
	public String contenu_st;
	Scanner sc;
	public Staut() {
		super();
		id_st++;
	}
	public Staut(String contenu) {
		super();
		this.contenu_st = contenu;
		id_st++;
	}
	public void ajouter() {
		bd.publication.add(this);
	}
	@Override
	public void modifier(int id) {
		if(this.idUtilisateur == id) {
			System.out.println("modifier le contenue du statue");
			this.contenu = sc.next();
		}
		
	}
	@Override
	public void consulter(int id) {
		for(int i=0;i<bd.publication.size();i++) {
			if(bd.publication.get(i).getClass() == Staut.class && bd.publication.get(i).idUtilisateur == id) {
				System.out.println("user id = " + id);
				System.out.println("Publication: \n" + this.contenu_st);
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
