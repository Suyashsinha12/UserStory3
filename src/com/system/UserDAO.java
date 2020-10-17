package com.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.Complaint;
import com.system.Customer;
import com.system.Person;
import com.system.DAO.DBConnector;

public class UserDAO {

		Connection con;
		Statement st;
		PreparedStatement pst;
		ResultSet rs;
		
		public UserDAO() {
			super();
			con = new DBConnector().getCon();
			
		}
		
		public List<Customer> viewAllCustomer() {
		try {
			st=con.createStatement();
			rs=st.executeQuery("Select * from Customer");
			List<Customer> clist = new ArrayList<Customer>();
			while(rs.next()) {
				Person p=new Person();
				p.id=rs.getInt(1);
				p.name=rs.getString(2);
				
				clist.add(p);
				
				}
			return clist;
			}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
		public List<Complaint> viewAllComplaintById(int id) {
			try {
				pst=con.prepareStatement("Select * from customer where cust_id=?");
				pst.setInt(1, id);
				ResultSet rs=pst.executeQuery();
				boolean b=rs.next();
				if(b) {
					pst=con.prepareStatement("Select * from complaint where cust_id=?");
					pst.setInt(1, id);
					rs=pst.executeQuery();
					List<Complaint> clist = new ArrayList<Complaint>();
					while(rs.next()) {
						Complaint c= new Complaint();
						c.cust_id=rs.getInt(1);
						c.cid=rs.getInt(2);
						c.title=rs.getString(3);
						c.description=rs.getString(4);
						c.status=rs.getString(5);
						System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getString(4));
						clist.add(c);

					}
					return clist;
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		public Complaint viewComplaintStatus(int id) {
			try {
				pst=con.prepareStatement("Select * from complaint where cid=?");
				pst.setInt(1, id);
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					Complaint c=new Complaint();
					c.cust_id=rs.getInt(1);
					c.cid=rs.getInt(2);
					c.title=rs.getString(3);
					c.status=rs.getString(4);
					c.description=rs.getString(5);
					
					return c;
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public boolean registerNewComplaint(Person p) {
			try {
			
				pst=con.prepareStatement("insert into customer values(?,?)");
				pst.setInt(1, p.id);
				pst.setString(2, p.name);
				pst.execute();
				
				PreparedStatement pst1=con.prepareStatement("insert into complaint values(?,?,?,?,?)");
				pst1.setInt(2,p.c.cid);
				pst1.setString(3,p.c.title);
				pst1.setString(5,p.c.description);
				pst1.setInt(4,1);
				pst1.setInt(1,p.c.cust_id);
				pst1.execute();
				return true;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	
}
