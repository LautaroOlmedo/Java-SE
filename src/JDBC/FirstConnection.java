package JDBC;

import java.sql.*;

public class FirstConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		try {
			// 1. CREAR CONEXIÓN !!  => Los !! hacen referencia a que nunca se modificará esta parte
			Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce", "root", "jlomar12");
			
			// 2. CREAR OBJETO STATEMENT !!
			Statement myStatement = myConnection.createStatement();
			
			// 3. EJECUTAR SQL
			
			ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM users");
			
			while(myResultSet.next()) {
				System.out.println(myResultSet.getString("firstname") + " " + myResultSet.getString("lastname")); // EN VEZ DE EL NOMBRE DEL CAMPO PODEMOS PONER EL NUMERO QUE LO REPRESENTA 
			} 
			// SI EL CAMPO NO ES DE TIPO VARCHAR NO UTILIZAMOS .GETSTRING UTILIZARIAMOS GETINT O GETDATE
			myResultSet.close();
			
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			
		}

	}

}
