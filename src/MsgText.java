import java.util.Scanner;

public class MsgText extends Message implements bd {
		public static int id_txt;
		public String contenu_tx;
		Scanner sc;
		public MsgText() {
			super();
			id_txt++;
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
		public void accepter() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void recevoir_m(int ut) {
			int i = 0;
			for(String m  : msgTxt) {
				
				sc = new Scanner(m);
				if(sc.nextInt()==ut) {
					System.out.println(" id message = " + i);
					System.out.println("un message de utilisateur d'id=  " + String.valueOf(sc.nextInt()));
					String ch = sc.next();
					String ch1 = sc.next();
					System.out.println(ch1 + "\n" +"message= \n" + ch);
					for(Utilisateur u : utilisateur) {
						if(u.ut_id == ut) {
							u.id_message = i;
						}
					}
					}
				i++;
			}
			while(true) {
				System.out.println("Donner l'id de message a Supprimer ou tapez 'q'");
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(System.in);
				String x = scanner.next();
				if(!x.equals("q")) {
					supprimer_m(Integer.parseInt(x));
				} else
					break;
			}
			
		}
		@Override
		public void supprimer_m(int i) {
			
			msgTxt.remove(i);
		}
		@Override
		public int notification() {
			
			return 0;
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
