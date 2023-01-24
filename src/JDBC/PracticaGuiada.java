package JDBC;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PracticaGuiada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame miMarco = new MarcoAplicacion();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoAplicacion extends JFrame {
	
	public MarcoAplicacion() {
		
		setVisible(true);
		setBounds(500, 300, 400, 400);
		setTitle("Consulta DB");
		setResizable(false);
		setLayout(new BorderLayout());
		
		JPanel menus = new JPanel();
		menus.setLayout(new FlowLayout());
		
		secciones = new JComboBox();
		secciones.setEditable(false);
		secciones.addItem("Todos");
		paises = new JComboBox();
		paises.setEditable(false);
		paises.addItem("Todos");
		
		resultado = new JTextArea(4, 50);
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		menus.add(paises);
		
		add(menus, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);
		
		JButton bontonConsulta = new JButton("Consulta");
		bontonConsulta.addActionListener(new ActionListener() { // CLASE ANÓNIMA INTERNA QUE PONE A LA ESCUCHA EL BOTON DE CONSULTA Y EJECUTA EL METODO EJECUTACONSULTA

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ejecutaConsulta();
			}
			
		});
		add(bontonConsulta, BorderLayout.SOUTH);
		
		// ---------- CONEXIÓN CON DB ----------
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_pildoras", "root", "jlomar12");
			Statement statement = connection.createStatement();
			
			// ---------- CARGA COMBOBOX SECCIONES
			String consultaSQL = "SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";
			ResultSet rs = statement.executeQuery(consultaSQL);
			 while(rs.next()) {
				 secciones.addItem(rs.getString("SECCIÓN"));
			 }
			 rs.close();
			 
			// ---------- CARGA COMBOBOX PAISES
			  consultaSQL = "SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
			  rs = statement.executeQuery(consultaSQL);
				 while(rs.next()) {
					 paises.addItem(rs.getString(1));
				 }
				 rs.close();
			
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	private void ejecutaConsulta() { // MÉTODO ENCARGADO DE CONSULTAR EN LA BASE DE DATOS Y TRATER LOS VALORES DE LA SECCIÓN
		ResultSet rs = null;
		try {
			resultado.setText("");
			
			String seccion = (String) secciones.getSelectedItem();
			String pais = (String) paises.getSelectedItem();
			
			if(!seccion.equals("Todos") && pais.equals("Todos")) {
				enviaConsultaSeccion = connection.prepareStatement(consultaSeccion);
				enviaConsultaSeccion.setString(1, seccion);
				rs = enviaConsultaSeccion.executeQuery();
				
			}else if(seccion.equals("Todos") && !pais.equals("Todos")) {
				enviaConsultaPais= connection.prepareStatement(consultaPais);
				enviaConsultaPais.setString(1, pais);
				rs = enviaConsultaPais.executeQuery();
				
			}else if(!seccion.equals("Todos") && !pais.equals("Todos")) {
				enviaConsultaTodos= connection.prepareStatement(consultaTodos);
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);
				rs = enviaConsultaTodos.executeQuery();
			}
			
			
			while(rs.next()) {
				resultado.append(rs.getString("NOMBREARTÍCULO"));
				resultado.append(", ");
				resultado.append(rs.getString("SECCIÓN"));
				resultado.append(", ");
				resultado.append(rs.getString("PRECIO"));
				resultado.append(", ");
				resultado.append(rs.getString("PAÍSDEORIGEN"));
				resultado.append("\n");
			}
	}catch(Exception e) {
		System.out.println(e);
		e.printStackTrace();
		}
	}
	
	private Connection connection;
	private JComboBox secciones;
	private JComboBox paises;
	private JTextArea resultado;
	private java.sql.PreparedStatement enviaConsultaSeccion;
	private java.sql.PreparedStatement enviaConsultaPais;
	private java.sql.PreparedStatement enviaConsultaTodos;
	private final String consultaSeccion = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN = ?";
	private final String consultaPais = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN = ?";
	private final String consultaTodos = "SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN = ? AND PAÍSDEORIGEN = ?";
}
