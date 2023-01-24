package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. CREAR CONEXIÓN !!  => Los !! hacen referencia a que nunca se modificará esta parte
	    try {
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_pildoras", "root", "jlomar12");
			
		// 2. PREPARAR SENTENCIA
			java.sql.PreparedStatement sentencia = myConnection.prepareStatement("SELECT NOMBREARTÍCULO, SECCIÓN, PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN = ? AND PAÍSDEORIGEN = ?");
			
			// 3. ESTABLECER PARAMETROS DE CONSULTAS
			sentencia.setString(1, "deportes");
			sentencia.setString(2, "USA");
			
			// 4. EJECUTAR Y RECORRER CONSULTA
			ResultSet rs = sentencia.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			
			rs.close();
			
			// REUTILIZACION DE CONSULTAS
			System.out.println("---------- CAMBIO DE CONSULTA ----------");
			
			sentencia.setString(1, "cerámica");
			sentencia.setString(2, "China");
			
			// 4. EJECUTAR Y RECORRER CONSULTA
			 rs = sentencia.executeQuery();
			 
				while(rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				}
				
				rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					

	}

}
