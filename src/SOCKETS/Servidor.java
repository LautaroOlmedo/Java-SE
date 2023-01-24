package SOCKETS;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoServidor miMarcoServidor = new MarcoServidor();
		miMarcoServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoServidor extends JFrame implements Runnable{
	public MarcoServidor() {
		setTitle("SERVIDOR");
		setBounds(600, 300, 280, 350);
		setVisible(true);
		
		JPanel laminaServidor = new JPanel();
		laminaServidor.setLayout(new BorderLayout());
		
		areaTexto = new JTextArea();
		laminaServidor.add(areaTexto, BorderLayout.CENTER);
		add(laminaServidor);
		
		Thread miHilo = new Thread(this);
		miHilo.start();
	}
	
	@Override
	public void run() { // CREACIÓN DEL HILO Y SU MÉTODO QUE PERMITE A TRAVÉS DE SOCKET PERMANECE A LA ESCUCHA 
		
		
		try {
			ServerSocket servidor = new ServerSocket(9999); // ABRE UNA CONEXIÓN EN EL PUERTO 9999
			String nick, ip, mensaje; // VARIABLES A MOSTRAR
			Enviame datosRecibidos = new Enviame(); // CLASE QUE TIENE LOS CAMPOS NICK IP Y MENSAJE 
			while(true) {
				Socket miSocketServidor = servidor.accept(); // ACEPTA PETICIONES
				
				ObjectInputStream flujoEntrada = new ObjectInputStream(miSocketServidor.getInputStream()); // RECIBE EL OBJETO DEL CLIENTE
				datosRecibidos = (Enviame) flujoEntrada.readObject(); // REFACTOR YA QUE EL OBJETO ENVIADO ES DE TIPO ObjectOutputStream
				nick = datosRecibidos.getNick(); // UNA VEZ HECHO EL REFACTOR TOMAMOS LOS VALORES DEL OBJETO A TRAVES DE LOS GETTERS
				ip = datosRecibidos.getIp();
				mensaje = datosRecibidos.getMensaje();
				

				areaTexto.append("\n" + nick + " : " + mensaje + " .Para " + ip); // AGREGAMOS AL AREA DE TEXTO LOS VALORES 
				
				
				// -------------------- EN CASO DE QUERER CREAR UN CHAT QUE PERMITA CONECTAR VARIOS CLIENTES UTILIZAMOS EL CODIGO COMENTADO DE ABAJO --------------------
				
				/*Socket enviaDestinatario = new Socket(ip, 9090); // ABRE UNA CONEXIÓN CLIENTE
				ObjectOutputStream datosEnviados = new ObjectOutputStream(enviaDestinatario.getOutputStream()); // CREACIÓN DEL ObjectOutputStream
				datosEnviados.writeObject(datosRecibidos); // FLUJO DE DATOS QUE SE ENVÍA
				enviaDestinatario.close(); // CIERRE DEL SOCKET  DUDA: ¿ SE CIERRA EL SERVERSOCKET ?
				;*/
				miSocketServidor.close();
			}
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	private JTextArea areaTexto;
}
