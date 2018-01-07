package com.igs.ipi.tpspringbootPereauAlban.Model;
import java.io.File;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;



public class DbTest {

    static Connection con; 
    
    // What is JDBC ?? Java Database Connectivity API (Application Programming Interface)
    // ---> https://docs.oracle.com/javase/tutorial/jdbc/overview/
    // JDBC is an API that enables us to talk to many different types of data stores.
    // anything under java.sql is part of JDBC
    // jdbc protocol - hsqldb type - file type - path to resource
    static String connectionString = "jdbc:hsqldb:file:db-data/mydatabase";
    
	public static void main(String[] args) throws Exception {
	    
		String createTable = readToString("sql/puissance4.sql");
		String populate = readToString("sql/populate.sql");
		
		System.out.println("Attempting to create contacts DB ... ");
		System.out.println(createTable);
		
		
		// this loads the DB driver
		// explained here: http://stackoverflow.com/questions/5992126/loading-jdbc-driver
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			throw e;
		}
		
		try {
			// will create DB if does not exist
			// "SA" is default user with hypersql
			con = DriverManager.getConnection(connectionString, "SA", "");
			
			// create table
			con.createStatement()
					.executeUpdate(createTable);
			
			// add 
			con.createStatement()
					.executeUpdate(populate);
			
			// select everything
			PreparedStatement pst = con.prepareStatement("select * from puissance4");
	        pst.clearParameters();
	        ResultSet rs = pst.executeQuery();
	        
	        List<GameModel> puissance4 = new ArrayList<>();
	        while(rs.next()){
	        	//Array part = rs.getArray("partie");
	        	//Array[] partie= new Array[41];
	           // partie = (Array[])part.getArray();
	        	puissance4.add(new GameModel(    		   
	        			rs.getString(1), 
	        			rs.getString(2), 
	        			rs.getString(3),
	        			rs.getString(4)
	        			//partie
	        		
	        		)
    			);
	        }
			
	        for(GameModel gameModel : puissance4) {
	        	System.out.println("boucle affichage....");
	        	System.out.println(gameModel.getNom1());
	        	System.out.println(gameModel.getNom2());
	        	System.out.println(gameModel.getJoueurActuel());
	        	System.out.println(gameModel.getGagnant());
	        	
	        }
	        
		} catch (SQLException e) {
			throw e;
		} finally {
		
			con.close();
		}
	}
	
	public static String readToString(String fname) throws Exception {
		File file = new File(fname);
		String string = FileUtils.readFileToString(file, "utf-8");
		return string;
	}
	
	
}
