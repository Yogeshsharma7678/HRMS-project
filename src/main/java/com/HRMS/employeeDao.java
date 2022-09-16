/* Making a class employeeDao for connect database 
 * with java application 
 * using DAO object methodology 
 */
package com.HRMS;

import java.sql.*;

public class employeeDao {
	
	//initialisation of connection object as null
	Connection con=null;
	
	public void connect() throws Exception                         //connect method to establish connection with database
    {
    
	  Class.forName("com.mysql.cj.jdbc.Driver");
    
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123456");
    }
      
	//method to add employee
	public int addEmployee(Employee e)throws Exception{
		
		String query = "select * from Employee where eName = '"+e.eName+"'";
		
		Statement st= con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		if(rs.next()) {
			
			return -1;
			
		}
		
		else
		{   
			String Query1 = "insert into Employee(eName , eDomain , eDesignation , eLocation , eSal , ePhone) values(?,?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(Query1);
			
			pst.setString(1, e.eName);
			
			pst.setString(2, e.eDomain);
			
			pst.setString(3, e.eDesignation);
			
			pst.setString(4, e.eLocation);

			pst.setInt(5, e.eSal);
			
			pst.setString(6, e.ePhone);
			
			int res = pst.executeUpdate();
			return res;
		}
		
		
		
	}
	
	//method to remove employee from the table
	public int removeEmployee(int eId) throws Exception{
		
	Statement st= con.createStatement();
	
	ResultSet rs = st.executeQuery("select * from Employee where eId = '"+eId +"'");
	
	if(rs.next()) {
		
		//rs.close();
		
		Statement stm = con.createStatement();
		
		stm.executeUpdate("delete from Employee where eId ="+eId);
		
		return 1;
		
	}
	else 
		
		return 0;
	}
    
	//method to hiking up the salary
	public int hikeSalary(int eId, int hike) throws Exception{
		
	String query1="select * from Employee where eId ="+eId ;
	
	Statement st = con.createStatement();
	
	ResultSet rs = st.executeQuery(query1);
	
	if(rs.next()) {
		
		PreparedStatement stm =con.prepareStatement(query1);
		
		stm.executeUpdate("update Employee set eSal=eSal+(eSal*"+hike+")/100 ");
		
		return 1;
		
	}
	else 
	return 0;
	
	}

	
}

