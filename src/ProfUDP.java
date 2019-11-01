import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ProfUDP {
	
public   static List<Etudiant> liste;
	
	
	public static void main(String[] args) {
				
				try {
					liste = new ArrayList<Etudiant>();
					DatagramSocket sc = new DatagramSocket(3001);
					

					ProfSend ps = new ProfSend(sc);
					ProfReceive pr = new ProfReceive(sc);
					pr.start();
					ps.start();
					
					
				} catch (SocketException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		
	}

}
