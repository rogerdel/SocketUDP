import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {

	public static void main(String[] args) {
		System.out.println("------Servidor-----------");
		try {
			DatagramSocket socketUDP = new 	DatagramSocket(6543);
			byte [] bufer = new byte[10000];
			while(true) {
				DatagramPacket peticion = new DatagramPacket(bufer,bufer.length);
				socketUDP.receive(peticion);
				String rec = new String(peticion.getData());
				String [] palb = rec.split(" ");
				String env = "El numero de palabras "+palb.length;
				byte [] enviar = env.getBytes();
				
				DatagramPacket mensaje = new DatagramPacket(enviar,env.length(),peticion.getAddress(),peticion.getPort());
				socketUDP.send(mensaje);
				System.out.println("Datos "+new String(peticion.getData()));
			}
	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
