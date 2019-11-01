import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.List;


public class ProfSend extends Thread {

	 int portEtu;
		DatagramSocket sc ;
	
	
	public ProfSend(DatagramSocket sc) {
			super();
			this.sc = sc;
		}


	/*
	 * public List<DatagramPacket> CreatPacket() {
	 * 
	 * List<DatagramPacket> LpkSend = null; byte[] dataSend = new byte[1024];
	 * 
	 * 
	 * try { InetAddress ipProf = InetAddress.getLocalHost(); 
	 *  dataSend = msg.getBytes(); String sous_msg =
	 * msg.substring(1,3); if(sous_msg.equals("all")) { for(Etudiant E: LE) {
	 * DatagramPacket pksend = new DatagramPacket(dataSend, dataSend.length,
	 * E.getAdr(), portEtu); LpkSend.add(pksend) ; }
	 * 
	 * } else { for(Etudiant E: LE) { String Etu = E.getPseudo().substring(1,3);
	 * if(sous_msg.equals(Etu)) { DatagramPacket pksend = new
	 * DatagramPacket(dataSend, dataSend.length, E.getAdr(), portEtu);
	 * LpkSend.add(pksend) ; }
	 * 
	 * } } } catch (Exception e) { // TODO Auto-generated catch block
	 * e.getMessage(); } return LpkSend; }
	 */
	public void run() {
		
		
		try {
			while(true) {

			BufferedReader inClavier = new BufferedReader(new InputStreamReader(System.in));
			String msg = inClavier.readLine();
			if(msg.startsWith("@all@")) {
				String MessageNet = msg.substring(5,msg.length());
				for(Etudiant E : ProfUDP.liste) {
				DatagramPacket pk = new DatagramPacket(MessageNet.getBytes(), MessageNet.length(), E.getAdr(), E.getPort());
				sc.send(pk);}}
			else if(msg.startsWith("@")) {
				
				String[] Mesprive = msg.split("@");
				for(Etudiant E : ProfUDP.liste) {
					if(Mesprive[1].equals(E.getPseudo())) {
					DatagramPacket pk = new DatagramPacket(Mesprive[2].getBytes(), Mesprive[2].length(), E.getAdr(), E.getPort());
					sc.send(pk);
				}}

				
			}}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		
		
	}
}
