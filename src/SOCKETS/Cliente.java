package SOCKETS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCliente miMarcoCliente = new MarcoCliente();
		miMarcoCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCliente extends JFrame{
	public MarcoCliente() {
		setTitle("CLIENTE");	
		setBounds(600, 300, 280, 350);
		
		LaminaCliente miLamina = new LaminaCliente();
		add(miLamina);
		
		setVisible(true);
	}
}

class LaminaCliente extends JPanel implements Runnable{
	public LaminaCliente() {
		//setLayout(new BorderLayout());
		nick = new JTextField(5);
		add(nick);
		JLabel texto = new JLabel("CHAT");
		add(texto);
		ip = new JTextField(8);
		add(ip);
		campoChat = new JTextArea(12, 20);
		add(campoChat);
		
		campo1 = new JTextField();
		add(campo1);
		
		miBoton = new JButton("Enviar");
		EnviaTexto miEvento = new EnviaTexto();
		miBoton.addActionListener(miEvento);
		add(miBoton);
		
		Thread miHilo = new Thread(this);
		miHilo.start();
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				Socket miSocketCliente = new Socket("10.0.0.100", 9999); // GENERACIÓN DEL SOCKET
				
				Enviame datos = new Enviame();
				datos.setNick(nick.getText());// AGREGANDO LOS VALORES INTRODUCIDOS EN LOS CAMPOS 
				datos.setIp(ip.getText());
				datos.setMensaje(campoChat.getText());
				
				ObjectOutputStream paquete = new ObjectOutputStream(miSocketCliente.getOutputStream()); // CREACIÓN DEL OBJETO A ENVIAR
				paquete.writeObject(datos); // ESCRIBIENDO EN EL FLUJO DE DATOS 
				miSocketCliente.close(); // CIERRE DE SOCKET 
				
		
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
			
		}
		
	}
	
	@Override
	public void run() { // ACTUA IGUAL QUE EL METODO RUN DEL SERVIDOR. SE UTILIZA EN CASO DE TENER MULTIPLES CLIENTES 
		// TODO Auto-generated method stub
		try {
			ServerSocket servidorCliente = new ServerSocket(9090);
			Socket cliente;
			Enviame datosRecibidos;
			while(true) {
				cliente = servidorCliente.accept();
				ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
				datosRecibidos = (Enviame) flujoEntrada.readObject();
				campoChat.append("\n" + datosRecibidos.getNick() + " : " + datosRecibidos.getMensaje());
				cliente.close();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private  JButton miBoton;
	private JTextField campo1;
	private JTextField nick;
	private JTextField ip;
	private JTextArea campoChat;
	
}

class Enviame implements Serializable { // CLASE DE LA CUAL SE CREARA EL OBJETO CON LOS DATOS NICK MENSAJE Y IP. IMPLEMENTA SERIALIZABLE PARA SER ENVIADO POR BYTES
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	private String nick, ip, mensaje;

}
