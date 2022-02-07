

public class main {

	public static void main(String[] args) {
		Utilisateur ut1 = new Utilisateur("aa","aaaa","aa","aa");
		Utilisateur ut2 = new Utilisateur("bb","bbbb","bb","bb");
		Utilisateur ut3 = new Utilisateur("bb","bbbb","bb","bb");
		
		
		boolean test = ut1.Se_connecter();
		 test = ut2.Se_connecter();
		 test = ut3.Se_connecter();
		//ut1.Modifier_info();
		//ut1.Se_Deconnecter();
		//System.out.println(ut1.getLogin_ut());
		ut1.Ajouter_ami();
		ut3.Ajouter_ami();
		ut1.envoyerMessageTxt();
		ut1.envoyerMessageTxt();
		ut1.envoyerMessageTxt();
		
		ut2.notificationShow();
		
		ut2.demandeAjout();
		
		
		ut2.miseJour();
		ut1.miseJour();
		ut3.miseJour();
		ut1.voirAmi();
		ut2.voirAmi();
		ut3.voirAmi();
		
		ut1.envoyerMessageTxt();
		ut2.notificationShow();
		
		ut1.ajouterPublication();
		
		
	}

}
