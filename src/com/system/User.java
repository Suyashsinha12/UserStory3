package com.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class User {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Customer per = new Person();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to menu:::");
		while(true) {
			System.out.println("1.View all customers ");
			System.out.println("2.Select customer to view all complaints");
			System.out.println("3.Select a complaint to view its status");
			System.out.println("4.Register a complaint with new user");
			
			
			System.out.println("Enter ur choice::");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				List<Customer> clist = per.viewAllCustomer();
				for(Customer c : clist) {
					System.out.println(((Person)c).id+" "+((Person)c).name);
				}
				break;		
			
			case 2:
				System.out.println("Enter KeyId:");
				int id=sc.nextInt();
				List<Complaint> list = per.viewComplaintsById(id);
				
				break;
		
			case 3:
				System.out.println("Enter the complaint id : ");
				int cid=sc.nextInt();
				Complaint comp = per.viewComplaintStatus(cid);
				System.out.println("Your complaint title is "+comp.title+"\n Your Complaint status is "+comp.status);
				
				break;
				
			case 4:
				System.out.println("Enter the id : ");
				int id2=sc.nextInt();
				System.out.println("Enter Customer name : ");
				String name=sc.next();
				System.out.println("Enter Complaint id : ");
				String cid1=sc.next();
				System.out.println("Enter Title : ");
				String title=sc.next();
				System.out.println("Enter Description : ");
				sc.nextLine();
				String description=sc.next();
				
				Complaint com = new Complaint(1,title,description,cid1,id2);
				Person p = new  Person(id2,name,com);
				boolean b = per.launchComplaintWithExistingUser(p);
				if(b) {
					System.out.println("Complaint Registered");
				}
				else {
					System.out.println("Some problem");
				}
				break;
				
			default:
				break;
			}
			
			
		}
			 		
	}
	}




