package com.paf.models;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ships {

	public String getShips() {
		String shipGrid = null;  
		Connection con = null;   
		Statement st = null;   
		ResultSet rs = null; 
		
		try { 
		con = DBConnection.createConnection();
		st = con.createStatement(); 
		
		rs = st.executeQuery("select * from Ships");
		if (rs.first()) 
		{
			shipGrid = "<table border='1'"
					+ " cellspacing='1' cellpadding='1'><tr><th>No</th><th>Ship Name</th><th>Description</th><th>Edit</t "
					+ "	h><th>Delete</th></tr>"; 
			rs.beforeFirst(); 
			
			while(rs.next()) 
			{
				shipGrid = shipGrid + "<tr><td>" + rs.getString(1) + "</td>" 
				+ "<td>" + rs.getString(2) + "</td>" 
				+ "<td>" + rs.getString(3) + "</td>" 
				+ "<td><input id=\"btnEdit\" type=\"button\" name=\"btnEdit\" "
				+ " param=\"" + rs.getString(1) + "\" value=\"Edit\"</td>" 
				+ "<td>" + "<input id=\"btnRemove\" type=\"button\" "
				+ "name=\"btnRemove\" param=\"" + rs.getString(1) + "\" "
				+ "value=\"Remove\"</td></tr>"; 
			}
		}
			else
				shipGrid = "There are no Ships...";    
		shipGrid = shipGrid + "</table></br>"; 
			}
		catch (SQLException e) {   
			e.printStackTrace(); 
		}
		return shipGrid;
		
		}
	public String saveAnship(String shpName, String shpDesc) {
		
		String res = null;  
		String sql = null;   
		Connection con = null;   
		Statement st = null;
		
		try {    
			con = DBConnection.createConnection(); 
			
			st = con.createStatement(); 
			sql = "insert into ships (nameships, descships) values ('\" + shpName + \"', '\" + shpDesc + \"')\"";
					
					st.executeUpdate(sql);
					res = "Successfully inserted...";
		}
		catch (SQLException e) {  
			e.printStackTrace(); 
		}
		
		return res;
	}

}
