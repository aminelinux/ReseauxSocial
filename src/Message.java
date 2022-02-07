

public abstract class Message {
	public static int id_msg;
	public static int nbr_msg;
	
	
	public Message() {
		id_msg++;
		nbr_msg++;
	}
	public abstract void recevoir_m(int ut);
	public abstract void supprimer_m(int i);
	
	public abstract int notification();
	 
}
