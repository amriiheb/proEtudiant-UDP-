import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ProfReceive extends Thread {
	DatagramSocket sc ;
	byte[] data = new byte[1024];
	
	
	public ProfReceive(DatagramSocket sc) {
		super();
		this.sc = sc;
		
	}


	public void run() {
			
			try {
				while(true) {
				DatagramPacket pk = new DatagramPacket(data, 1024);

				sc.receive(pk);
				
				String verif = new String(pk.getData(),0,pk.getLength());
				if(verif.startsWith("$$")) {
					ProfUDP.liste.add(new Etudiant(verif.substring(2, verif.length()), pk.getAddress(), pk.getPort(), sc));
					System.out.println("New user "+verif.substring(2, verif.length()));
				}
				else {
					System.out.println(verif);
				}
			}} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
