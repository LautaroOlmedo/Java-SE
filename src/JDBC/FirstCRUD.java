package JDBC;

import java.sql.*;

public class FirstCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// 1. CREAR CONEXIÓN !!  => Los !! hacen referencia a que nunca se modificará esta parte
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_pildoras", "root", "jlomar12");
			
			// 2. CREAR OBJETO STATEMENT !!
			Statement myStatement = myConnection.createStatement();
			// ADD: String instruccionSql = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO, IMPORTADO) VALUES ('AR77', 'PANTALON', 25.35, 0)";
			// UPDATE: String instruccionSql = "UPDATE PRODUCTOS SET PRECIO = PRECIO * 2 WHERE CÓDIGOARTÍCULO = 'AR77'";
			String instruccionSql = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO = 'AR77'";
			myStatement.executeUpdate(instruccionSql);
			System.out.print("Datos insertados correctamente");
			System.out.print("Dato actualizado correctamente");
			System.out.print("Dato eliminado correctamente");
			
		
			
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			
		}

	}


	

}
