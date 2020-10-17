package com.system;

import java.util.Arrays;
import java.util.List;

public class Person implements Customer {

	int id;
	String name;
	public Complaint c;
	
	UserDAO dao=new UserDAO();
	
	public Person() {
		super();
		
	}
	
	public Person(int id, String name,Complaint c) {
		super();
		this.id = id;
		this.name = name;
		this.c = c;
	}

	@Override
	public List<Customer> viewAllCustomer() {
		List<Customer> list=dao.viewAllCustomer();
		return list;
	}

	@Override
	public List<Complaint> viewComplaintsById(int id) {
		System.out.println("here");
		List<Complaint> list=dao.viewAllComplaintById(id);
		return list;
	}

	@Override
	public Complaint viewComplaintStatus(int id) {
		Complaint comp = dao.viewComplaintStatus(id);
		return comp;
	}

	@Override
	public boolean launchComplaintWithExistingUser(Person p) {
		boolean b=dao.registerNewComplaint(p);
		return b;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", c=" + c + ", dao=" + dao + "]";
	}
	
	
}