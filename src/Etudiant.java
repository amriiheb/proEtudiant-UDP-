import java.net.DatagramSocket;
import java.net.InetAddress;

public class Etudiant {
	
	 String Pseudo ;
	 InetAddress adr;
	 int port;
	 DatagramSocket sc ;
	
	
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public DatagramSocket getSc() {
		return sc;
	}
	public void setSc(DatagramSocket sc) {
		this.sc = sc;
	}
	public Etudiant(String pseudo, InetAddress adr, int port, DatagramSocket sc) {
		super();
		Pseudo = pseudo;
		this.adr = adr;
		this.port = port;
		this.sc = sc;
	}
	public String getPseudo() {
		return Pseudo;
	}
	public void setPseudo(String pseudo) {
		Pseudo = pseudo;
	}
	public InetAddress getAdr() {
		return adr;
	}
	public void setAdr(InetAddress adr) {
		this.adr = adr;
	}
	
	
}
