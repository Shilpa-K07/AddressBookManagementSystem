package com.addressbook;
import java.sql.*;
import java.sql.*;
import java.sql.*;
import java.sql.*;

public class DBConnection {       
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	   
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "Mahadyut@123";
	
    	static Connection con=null;
	static Connection con=null;
	static Connection con=null;
	static Connection con=null;
	static Connection con=null;
	static Connection con=null;
	
    public static Connection getConnection()
    {
        if (con != null) return con;
        try {
			con = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return con;  
    }

    }
