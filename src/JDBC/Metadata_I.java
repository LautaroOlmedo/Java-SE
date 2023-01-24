package JDBC;
import java.sql.*;

public class Metadata_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connect = null;
		try {
			// 1. CONEXIÓN
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_pildoras", "root", "jlomar12");
			
			// 2. OBTENCIÓN DE METADATA
			DatabaseMetaData myData = connect.getMetaData();
			
			// 3. MOSTRAR LA INFORMACIÓN DE LA BBDD
			
			System.out.println("Gestor de BBDD" + ": "+ myData.getDatabaseProductName());
			System.out.println("Versión del gestor" + ": "+ myData.getDatabaseProductVersion());
			System.out.println("Nombre del Driver" + ": " + myData.getDriverName());
			System.out.println("Versión del Driver" + ": " + myData.getDriverVersion());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
