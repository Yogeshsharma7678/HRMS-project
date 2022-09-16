/*This is a basic hr management system project 
 * in which employee can be added and remove
 * and can hike up the salary of any particular
 * employee !
 * -Yogesh Sharma  
 */

package com.HRMS;

import java.util.Scanner;

//creating a main class 
public class HRMS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        
		Scanner sc = new Scanner(System.in);                 //scanner object creation to take inputs from user
	
		employeeDao dao = new employeeDao();                 //creating dao object to call all the methods of dao class
		
		Employee e = new Employee();                          /*creating an object of employee class by which 
		                                                       we can add multiple employees using employee class's entities*/
		int op=0;
		//this loop is for performing back to back operations of user's choice 
		while (op<5) {
	    System.out.println("\t ---------Welcome to Human Resource Mngmnt System------\t");
	    
	    System.out.println("\t Select options : \n Press 1: for add employee \n Press 2: for remove employee \n Press 3: for hike in salary\n Press 4: To exit\t");
	   
	     op =sc.nextInt();
	    
	     if(op==4) {
	    	 
	    	 break;
	     }
	     //switch statement for performing operation which is choosed by user
	    switch(op){
	    case 1 -> {
	    	 //details for adding employee
	    	System.out.println("----Enter Employee details----");
	    	
	    	System.out.println("Enter Employee Name :");
	    	
	    	String eName = sc.next();
	    	
            System.out.println("Enter Employee Domain :");
	    	
	    	String eDomain = sc.next();

            System.out.println("Enter Employee Designation :");
	    	
	    	String eDesignation = sc.next();
	        
	    	System.out.println("Enter Employee Location :");
	    	
	    	String eLocation = sc.next();    
            
	    	System.out.println("Enter Employee Salary :");
	    	
	    	int eSal = sc.nextInt();
	    
            System.out.println("Enter Employee phone no :");
	    	
	    	String ePhone = sc.next();
	    	
	    	e.eName=eName;
	    	e.eDomain=eDomain;
	    	e.eDesignation=eDesignation;
	    	e.eLocation=eLocation;
	    	e.eSal=eSal;
	    	e.ePhone=ePhone;
	    	
	    	//calling dao object to establish connection 
	    	dao.connect();
	    	
	    	int res = dao.addEmployee(e);
	    	
	    	if(res==1)
	    		System.out.println("\t-----Employee added successfully----\t");
	    	else
	    		System.out.println("\t-----Employee already exist----\t");
	    }
	    
	    case 2 -> {
	    	int eId;
	    	//to remove employee from table
	    	System.out.println("Enter employee id which you want to delete from the table/database: ");
	    	
	    	eId=sc.nextInt();
	    	dao.connect();
	    	int rs = dao.removeEmployee(eId);
	    	
	    	if(rs==1) {
	    		
	    		System.out.println("------Employee removed----");
	    	}
	    	else
	    		
	    		System.out.println("Employee doesnt exist");
	    	
	    }
	    
	    case 3 -> {
	    	
	    	//to hiking up the salary of employee
	    	int eId ,hike =0;
	    	
	    	System.out.println("Enter Employee id to hike his salary");
	    	
	    	eId=sc.nextInt();
	    	
	    	System.out.println("Enter hike percentages of the salary");
	    	
	    	hike =sc.nextInt();
	    	dao.connect();
	    	int rs=dao.hikeSalary(eId, hike);
	    	
	    	if(rs==1) {
	    		
	    		System.out.println("----Salary got hiked of the Employee Successfully---");
	    	}
	    	else
	    		
	    		System.out.println("hike % or employee id is wrong.....try again!");
	    		
	    }
	 }
	 
		}sc.close();                    //closing of scanner object
	}
}
