package JDBC;
import java.sql.*;

public class StoredProcedure_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String nombreArticulo = "alicates";
			int precioArticulo = 26;
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_pildoras", "root", "jlomar12");
			CallableStatement miSentencia = miConexion.prepareCall("{call MACTUALIZA_PRECIO(?, ?)}"); // CON PARÁMETROS
			miSentencia.setInt(1, precioArticulo);
			miSentencia.setString(2, nombreArticulo);
			miSentencia.execute();
			System.out.println("DONE!!");
		}catch(Exception e) {
			
		}

	}
	

	

}
