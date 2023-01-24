package JDBC;
import java.sql.*;

public class Transactions_I {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection miConexion = null;
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_pildoras", "root", "jlomar12");
			miConexion.setAutoCommit(false); // AL PONER FALSE TOMA LAS INSTRUCIONES COMO BLOQUE
			
			Statement miSentencia = miConexion.createStatement();
			
			String instruccionSql1 = "INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";
			miSentencia.executeUpdate(instruccionSql1);
			
			String instruccionSql2 = "INSERT INTO PEDIDOS (NÚMEROPEDIDO, CÓDIGOCLIENTE, FECHADEPEDIDO) VALUES ('82', 'CT84', '11/03/2000')";
			miSentencia.executeUpdate(instruccionSql2);
			
			miConexion.commit(); // LE DA EL OK AL BLOQUE. O SE REALIZA TODO O NADA
			
			System.out.println("Done!!");
			
		}catch(SQLException e) {
			System.out.println("ERROR!!");
			e.printStackTrace();
			try {
				miConexion.rollback(); // REVIERTE LA DB PORQUE ALGO DEL BLOQUE FALLÓ! OSEA NO SE CARGÓ NADA EN LA DB 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
	//private Connection miConexion;

}
