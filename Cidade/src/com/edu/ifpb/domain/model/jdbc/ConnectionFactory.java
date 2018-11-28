package com.edu.ifpb.domain.model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String usuario;
	private String senha;
	private String url;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		url = "jdbc:postgresql://localhost:5432/DB_ATVD";
		usuario="postgres";
		senha="postgres";
		
		return DriverManager.getConnection(url, usuario, senha);
	}
}
