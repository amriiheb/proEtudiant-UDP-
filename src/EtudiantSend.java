import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EtudiantSend extends Thread {
	
	DatagramSocket sc ;
	String pseudo;
	
	


	public EtudiantSend(DatagramSocket sc, String pseudo) {
		super();
		this.sc = sc;
		this.pseudo = pseudo;
	}




	public void run() {
		
		try {
			while(true) {
			BufferedReader inClavier = new BufferedReader(new InputStreamReader(System.in));

			String msg = inClavier.readLine();
			msg ="@"+pseudo+"@"+msg;
			DatagramPacket pk = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getLocalHost(), 3000);
			sc.send(pk);
			
			
			
		}} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
