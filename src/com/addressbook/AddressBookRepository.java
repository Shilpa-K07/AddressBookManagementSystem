package com.addressbook;
import java.sql.*;
public class AddressBookRepository 
{
	   Connection conn = null;
	   Statement stmt = null;
	   public void addPerson(Person person,String name)
	   {
		   Connection conn = null;
		   try {
			   conn=DBConnection.getConnection();
			   String sql;
			   sql="INSERT INTO " +name+ "(firstname,lastname,city,state,address,zip,phonenumber) VALUES(?,?,?,?,?,?,?)";
			   PreparedStatement pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, person.getFirstName());
	           pstmt.setString(2, person.getLastName());
	           pstmt.setString(3,person.getCity());
	           pstmt.setString(4,person.getState());
	           pstmt.setString(5,person.getAddress());
	           pstmt.setString(6,person.getZip());
	           pstmt.setLong(7,person.getPhoneNumber());
	           pstmt.executeUpdate();
		   }
		   catch(Exception e)
		   {
			   System.out.println(e);
		   }
	   }

	public void editCity(String city, int personId,String name) {
		try 
		{
			conn=DBConnection.getConnection();
			String query = "UPDATE "+name+" SET city = ? WHERE id = ?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1, city);
			pstmt.setInt(2, personId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editState(String state, int personId,String name) {
		try 
		{
			conn=DBConnection.getConnection();
			String query = "UPDATE "+name+" SET state = ? WHERE id = ?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1, state);
			pstmt.setInt(2, personId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editAddress(String address, int personId,String name) {
		try 
		{
			conn=DBConnection.getConnection();
			String query = "UPDATE "+name+" SET address = ? WHERE id = ?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1, address);
			pstmt.setInt(2, personId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editZip(String zip, int personId,String name) {
		try 
		{
			conn=DBConnection.getConnection();
			String query = "UPDATE "+name+" SET zip = ? WHERE id = ?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setString(1, zip);
			pstmt.setInt(2, personId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editPhoneNumber(int phonenumber, int personId,String name) {
		try 
		{
			conn=DBConnection.getConnection();
			String query = "UPDATE "+name+" SET phonenumber = ? WHERE id = ?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, phonenumber);
			pstmt.setInt(2, personId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int deletePerson(int personId,String name) {
		int result=0;
		try 
		{
			conn=DBConnection.getConnection();
			String query = "DELETE from "+name+" WHERE id = ?";
			PreparedStatement pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, personId);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void getDetails(String name) {
		try 
		{
			conn=DBConnection.getConnection();
			String query = "SELECT * from "+name;
			PreparedStatement pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getLong(7)+" "); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sortByLastName(String name) {
		try 
		{
			conn=DBConnection.getConnection();
			String query = "SELECT * from "+name+" ORDER BY lastname";
			PreparedStatement pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getLong(7)+" "); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sortByZip(String name) {
		try 
		{
			conn=DBConnection.getConnection();
			String query = "SELECT * from "+name+" ORDER BY zip";
			PreparedStatement pstmt=conn.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getLong(7)+" "); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createNewAddressBook(String name) {
		try 
		{
			conn=DBConnection.getConnection();
			stmt=conn.createStatement();
			String query="CREATE TABLE "+name+ "(id int NOT NULL PRIMARY KEY AUTO_INCREMENT,firstname VARCHAR(45)NOT NULL,lastname VARCHAR(45) NOT NULL,city VARCHAR(45),state VARCHAR(45),address VARCHAR (50),zip INT(10),phonenumber INT)";
			stmt.executeUpdate(query);
			System.out.println("Address book created !!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}