import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class EtudiantUDP {

	public static void main(String[] args) {

		
			
			
			try {
				
				DatagramSocket sc = new DatagramSocket();
				BufferedReader inClavier = new BufferedReader(new InputStreamReader(System.in));
				String msg ="";
				do {
				msg = inClavier.readLine();
				}while(!msg.startsWith("$$"));
				
				InetAddress adr = InetAddress.getLocalHost();
				//ProfUDP.liste.add(new Etudiant(, adr, 3000, sc));
				DatagramPacket pk = new DatagramPacket(msg.getBytes(),msg.length() , adr, 3001);
				sc.send(pk);
				String pseudo = msg.substring(2, msg.length());
				EtudiantSend e1 = new EtudiantSend(sc, pseudo);
				EtudiantReceive e2 = new EtudiantReceive(sc);
				
				e1.start();
				e2.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
