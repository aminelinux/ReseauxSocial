import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilisateur implements bd{
	public static int id_ut;
	public int ut_id;
	public String nom_ut;
	public String prenom_ut;
	private String login_ut;
	private String pass_ut;
	public String date_n_ut;
	public String adress_ut;
	public String tel_ut;
	// Utilisateur est connecter ou non 
	private boolean is_ut = false;
	
	//amis de this Utilsateur
	ListeAmis friend ;
	
	//message ajout en attente
	DemandeAjout aj;
	
	//message txt
	MsgText messaget;
	// last id message
	int id_message ;
	
	//new publication
	Video video ;
	Photo photo;
	Staut statut;
	//new Commentaire
	Commentaire cm;
	
	//Scanner
	Scanner sc = new Scanner(System.in);
	//Constructeur default
	public Utilisateur() {
		id_ut++;
		ut_id = id_ut++;
		utilisateur.add(this);
		friend = new ListeAmis();
	}
	public Utilisateur(int id) {
		Utilisateur.id_ut = id;
		ut_id = id_ut++;
		utilisateur.add(this);
		friend = new ListeAmis();	
	}
	//constructeur personaliser
	public Utilisateur(String nom,String prenom,String login_ut,String pass_ut) {
		id_ut++;
		ut_id = id_ut;
		this.nom_ut = nom;
		this.prenom_ut = prenom;
		this.login_ut = login_ut;
		this.pass_ut = pass_ut;
		utilisateur.add(this);
		friend = new ListeAmis();
		id_message = 0;	
	}	
	
		//connecter a un compte pour modifier contenu
	public boolean Se_connecter() {
		/*variable sur login_ut and pass_ut si test < 2 -> false
		si test = 2 ->true
		*/
		int test = 0;
		System.out.println("Donner votre adresse e-mail");
		if(login_ut.equals(sc.next()))
			test++;
		System.out.println("Donner votre mot passe");
		if(pass_ut.equals(sc.next()))
			test++;
		if(test>1) {
			System.out.println("Welcome");
			// modifier utlisateur à est connecter
			is_ut = true;
			return true;
		}
		else {
			System.out.println("Sorry, e-mail or password incorrect");
			return false;
		}
	}
	
	public void Se_Deconnecter() {
		// modifier utlisateur à est Deconnecter
		is_ut = false;
		System.out.println("Disconnected ,see you soon");
		//System.exit(0);
	}
	public String getLogin_ut() {
		// ne donne pas  login_ut info si n'est pas TRUE Utilisateur sinon return  login_ut
		if(is_ut)
			return login_ut;
		else
			return "Denied";
	}
	public void setLogin_ut(String login_ut) {
		// ne donne pas  nouveaux login_ut si n'est pas TRUE Utilisateur sinon modifier login_ut
		this.login_ut = login_ut; 
		if(is_ut)
			this.login_ut = login_ut;
		else
			System.out.println("Denied");
	}	
	public String getPass_ut() {
		// ne donne pas  pass_ut info si n'est pas TRUE Utilisateur sinon return  pass_ut
		if(is_ut)
			return pass_ut;
		else
			return "Denied";
	}	
	public void setPass_ut(String pass_ut) {
		// ne donne pas  nouveaux pass_ut si n'est pas TRUE Utilisateur sinon modifier pass_ut
		if(is_ut)
			this.pass_ut = pass_ut;
		else
			System.out.println("Denied");
	}	
	
	//getter and setter
	public int getId_ut() {
		return Utilisateur.id_ut;
	}
	public static void setId_ut(int id_ut) {
		Utilisateur.id_ut = id_ut;
	}
	public String getNom_ut() {
		return nom_ut;
	}
	public void setNom_ut(String nom_ut) {
		this.nom_ut = nom_ut;
	}
	public String getPrenom_ut() {
		return prenom_ut;
	}
	public void setPrenom_ut(String prenom_ut) {
		this.prenom_ut = prenom_ut;
	}
	public String getDate_n_ut() {
		return date_n_ut;
	}
	public void setDate_n_ut(String date_n_ut) {
		this.date_n_ut = date_n_ut;
	}
	public String getAdress_ut() {
		return adress_ut;
	}
	public void setAdress_ut(String adress_ut) {
		this.adress_ut = adress_ut;
	}
	public String getTel_ut() {
		return tel_ut;
	}
	public void setTel_ut(String tel_ut) {
		this.tel_ut = tel_ut;
	}
	
	//ajouter des information utile pour la premiere fois
	public void Ajouter_info() {
		String testMod;		
		if(testSurDate_n_ut() && is_ut== true) {
			System.out.println("voulez vous ajouter une date de naissance tapez <<oui>> ou <<non>>");
			testMod = sc.next();
			switch(testMod) {
			case "oui": System.out.println("Donner voter date de naissance");
			this.date_n_ut = sc.next();
			case "non" : System.out.println("La prochane fois");
			}
		}
		if(testSurAdress_ut() && is_ut) {
			System.out.println("voulez vous ajouter une adresse tapez <<oui>> ou <<non>>");
			testMod = sc.next();
			switch(testMod) {
			case "oui": System.out.println("Donner votre adresse");
			this.adress_ut = sc.next();
			case "non" : System.out.println("La prochane fois");
			}
		}
		if(testSurTel_ut() && is_ut) {
			System.out.println("voulez vous ajouter une adresse tapez <<oui>> ou <<non>>");
			testMod = sc.next();
			switch(testMod) {
			case "oui": System.out.println("Donner votre adresse");
			this.tel_ut = sc.next();
			case "non" : System.out.println("La prochane fois");
			}			
		}		
	}
	
	//modifier des information qui existe deja sinon faire appella à Ajouter_info()
	public void Modifier_info() {
		final String info = "tapez --> 1 : modifier nom \n tapez --> 2 : modifier  \n"
				+ "tapez --> 3 : modifier date de naissance \n tapez --> 4 : modifier adresse"
				+ "tapez --> 5 : modifier n. telephone \n tapez --> 6 : modifier login e-mail \n"
				+ "tapez 7 : modifier mdp\n tapez --> q : pour quitter";
		System.out.println(info);
		String choice = sc.next();
		boolean inLoop = true;
		while(inLoop) {
			switch(choice) {
			case "1" :  System.out.println("Donner nom");
						this.setNom_ut(sc.next());
						System.out.println(info);
						choice = sc.next();
						
						break;
			case "2" :	System.out.println("Donner prenom");
						this.setPrenom_ut(sc.next());
						System.out.println(info);
						choice = sc.next();
						break;
			case "3" :	{
				
				if(!testSurDate_n_ut())
				{	System.out.println("Donner Date de naissance");
					this.setDate_n_ut(sc.next());
					System.out.println(info);
					choice = sc.next();
				}
				else
				{
					this.Ajouter_info();
					System.out.println(info);
					choice = sc.next();
				}
				break;
			}
			case "4" : System.out.println("Donner adresse");
						if(!testSurAdress_ut())
						{
							System.out.println("Donner adresse");
							this.setAdress_ut(sc.next());
							System.out.println(info);
							choice = sc.next();
						}
						
						else
						{
							this.Ajouter_info();
							System.out.println(info);
							choice = sc.next();
						}
						break;
			case "5" : System.out.println("Donner adresse");
						if(!testSurTel_ut())
						{
							this.setTel_ut(sc.next());
							System.out.println(info);
							choice = sc.next();
						}
						else
						{
							this.Ajouter_info();
							System.out.println(info);
							choice = sc.next();
						}
						break;
			case "6" : System.out.println("Donner Login e-mail");
						if(is_ut) {
							System.out.println("Donner votre actuelle e-mail");
								if(login_ut.equals(sc.next())) {
									System.out.println("Donner votre nouveaux login e-mail");
									String str = sc.next();
									System.out.println("confirmer votre login e-mail une autre fois");
									while(true) {
										if(str.equals(sc.next())) {
											this.login_ut = str;
											break;
										}
										System.out.println("no matching , confirmer de noveaux");
									}
								}
								System.out.println(info);
								choice = sc.next();
						}else
							{
							System.out.println("Denied");
							System.out.println(info);
							choice = sc.next();
							}
							
						break;
			case "7" :	System.out.println("Donner Login e-mail");
							if(is_ut) {
								System.out.println("Donner votre actuelle mot de pass");
								if(login_ut.equals(sc.next())) {
									System.out.println("Donner votre nouveaux mot de pass");
									String str = sc.next();
									System.out.println("confirmer votre mot de pass une autre fois");
									while(true) {
										if(str.equals(sc.next())) {
											this.login_ut = str;
											break;
										}
										System.out.println("no matching , confirmer de noveaux");
									}
								}
								System.out.println(info);
								choice = sc.next();
							}else {						
								System.out.println("denied");
								System.out.println(info);
								choice = sc.next();
							}
				break;
			case "q" : inLoop=false ;break;
			default : System.out.println("Error");
			}
		}
		
	}
	
	//envoyer une demande d'ajout à un utlisateur
	public void Ajouter_ami() {
		System.out.println("Donner l'id de l'utlisateur à ajouter");
		int id = sc.nextInt();
		String msgd = Integer.toString(id) + " " + Integer.toString(this.ut_id);
		//System.out.println("ajouter_ami message apres concatination" + msgd);
		msg.add(msgd);
		//System.out.println(msg.toString());
		//System.out.println(msg.size());		
	}
	
	//envoyer un message texte a un utilisatuer
	public void envoyerMessageTxt() {
		messaget = new MsgText();
		System.out.println("Donner l'id utilisateur à envoyer un message");
		int x = sc.nextInt();
		System.out.println("Message à envoyer -------->");
		bd.msgTxt.add(x + " " + this.ut_id + " " + sc.next() + " "+ LocalDate.now());		
	}	
	
	//tester si l'utilisateur est connecter pour pouvoir faire des modification sur  le compte 
	private boolean testSurDate_n_ut() {
		if(date_n_ut == null) {
			//System.out.println(" is true");
			return true;
		}
			
		else {
			//System.out.println(" is false");
			return false;
	}
	}
	 
	private boolean testSurAdress_ut() {
		if(adress_ut == null)
			return true;
		else
			return false;
	}
	private boolean testSurTel_ut() {
		if(tel_ut == null)
			return true;
		else
			return false;
	}
	
	
	//mise a jour sur le compte pour voir s'il des notification d'ajout a la liste d'amie oud des nouveaux message
	public void notificationShow() {
		aj = new DemandeAjout();
		messaget = new MsgText();
		aj.recevoir_m(this.ut_id);
		aj.notification();
		this.miseJour();
		messaget.recevoir_m(this.ut_id);
	}
	
	
	public void demandeAjout() {
		aj = new DemandeAjout();
		aj.recevoir_m(this.ut_id);
		aj.accepter();
		this.miseJour();
		aj.supprimer_m(ut_id);		
	}	
	
	//voir la liste des amis
	public void voirAmi() {
		System.out.println(this.nom_ut + this.prenom_ut + this.ut_id + "vos amis sont   ");
		for(Utilisateur utAmie : friend.amis ) {
			utAmie.affichageInFriend();
		}	
	}
	@Override
	public void recevoir_m(int ut) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int notification() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void supprimer_m(int ut) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void accepter() {
		// TODO Auto-generated method stub
		
	}
	
	//mise à jour la liste d'amis
	@Override
	public void miseJour() {
		ArrayList<Utilisateur> ut2 = new ArrayList<>();
		System.out.println("mise a jour en cours");
		for(String tami : ami) {
		if(tami.contains(String.valueOf(this.ut_id))) {
			System.out.println("conditon 1 mise a jour ");
			for(Utilisateur ut : utilisateur) {
				if(tami.contains(String.valueOf(ut.ut_id)) && !(ut.equals(this))){
					System.out.println("condition 2 mise a jour");
					//this.friend.amis.add(ut);
					if (!ut2.contains(ut)) {
			            System.out.println(ut);
			            ut2.add(ut);
			        }
					System.out.println(this.friend.amis.size());
				}
			}
			}		
		}		
		this.friend.amis = ut2;		
	}
	
	public void affichageInFriend() {
		System.out.println("Amis [id Friend= "+ ut_id + ", nom= "+ this.nom_ut + "prenom=" + this.prenom_ut + " ]");	
	}
	//ajouter publication
	public void ajouterPublication() {
		System.out.println("tapez 1 si vous voulez publier un video , tapez 2 si vous voulez publier une photo ou  tapez 3 "
				+ "si vous voulez publier un statu sion tapez q pour quitter");
		String ch = sc.next();
		switch(ch) {
			case "1" :  this.video = new Video();
						System.out.println("Donner l'extension du video");
						this.video.extension = sc.next();
						System.out.println("Donner l'url du video");
						this.video.contenu = sc.next();
						this.video.idUtilisateur = this.ut_id;
						this.video.ajouter();
						
				break;
			case "2" :  this.photo = new Photo();
						System.out.println("Donner l'extension de photo");
						this.photo.extension = sc.next();
						System.out.println("Donner l'url de photo");
						this.photo.contenu = sc.next();
						this.photo.idUtilisateur = this.ut_id;
						this.photo.ajouter();
						
				break;
			case "3" :	this.statut = new Staut();
						System.out.println("Donner le contenue du statue");
						this.statut.contenu = sc.next();
						this.statut.idUtilisateur = this.ut_id;
				break;
			case "q" : 
				break;
			default :System.out.println("error");
		}
	}
	//modification de la Publication
	public void modifierPub(int id) {
		System.out.println("tapez 1 si vous voulez modifier un video , tapez 2 si vous voulez modifier une photo ou  tapez 3 "
				+ "si vous voulez modifier un statu sion tapez q pour quitter");
		String ch = sc.next();
		switch(ch) {
			case "1" :  System.out.println(" mdifier video");
						this.video.modifier(id);
						
				break;
			case "2" :  System.out.println("modofier photo");
						this.photo.modifier(id);
						
				break;
			case "3" :	System.out.println("modifier txt");
						this.statut.modifier(id);
				break;
			case "q" : 
				break;
			default :System.out.println("error");
		}
		
	}
	//Consulter Publication
	
	public void consulterPub(int id) {
		System.out.println("tapez 1 si vous voulez consulter les videos , tapez 2 si vous voulez consulter une photo ou  tapez 3 "
				+ "si vous voulez consulter un statu sion tapez q pour quitter");
		String ch = sc.next();
		switch(ch) {
			case "1" :  System.out.println(" video");
						this.video.modifier(id);
						
				break;
			case "2" :  System.out.println(" photo");
						this.photo.modifier(id);
						
				break;
			case "3" :	System.out.println(" txt");
						this.statut.modifier(id);
				break;
			case "q" : 
				break;
			default :System.out.println("error");
		}
	}	
	
	//ajouter commentaire pour une publication par son id
	public void ajuterCommentaire() {
		this.cm = new Commentaire();
		System.out.println("Donner id publication");
		int x = sc.nextInt();
		cm.ajouter(x);
	}
	
	void setnom(String nom) {
		this.nom_ut = nom;
	}
	String getnom() {
		return this.nom_ut;
	}
}

