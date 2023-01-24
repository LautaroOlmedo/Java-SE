package JDBC;
import java.sql.*;
public class StoredProcedure_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_pildoras", "root", "jlomar12");
			CallableStatement miSentencia = miConexion.prepareCall("{call MUESTRA_CLIENTES}"); // LLAMA AL PROCEDIMIENTO ALMACENADO QUE CREAMOS. EL CUAL TRAE A LOS CLIENTES DE BARCELONA
			ResultSet rs = miSentencia.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
