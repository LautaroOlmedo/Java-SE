package JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metadata_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mostrarInfoTablas();
		

	}
	
	static void mostrarInfoTablas() {
		Connection connect = null;
		ResultSet rs = null;
		try {
			// 1. CONEXIÓN
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_pildoras", "root", "jlomar12");
			
			// 2. OBTENCIÓN DE METADATA
			DatabaseMetaData myData = connect.getMetaData();
			
			// 3. LISTA DE TABLAS
			
			/*System.out.println("Tablas" + ": ");
			rs = myData.getTables(null, null,"p%", null);
			while(rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
			*/
			// 3. LISTA DE COLUMNAS DE PRODUCTOS
			System.out.println("COLUMNAS DE PRODUCTOS" + ": ");
			
			System.out.println("COLUMNAS DE PRODUCTOS" + ": ");
			rs = myData.getColumns(null, null, "productos", null);
			while(rs.next()) {
				System.out.println(rs.getString("COLUMN_NAME"));
			}
		
			
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
