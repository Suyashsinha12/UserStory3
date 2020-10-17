package com.system;

public class Complaint {
	int cust_id,cid;
	String status;
	String title,description;
	

	public Complaint() {
		// TODO Auto-generated constructor stub
				
	}
	
	public Complaint(int cid, String title, String description, String status,int cust_id) {
		super();
		this.cust_id = cust_id;
		this.cid = cid;
		this.status = status;
		this.title = title;
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Complaint [cust_id=" + cust_id + ", cid=" + cid + ", status=" + status + ", title=" + title
				+ ", description=" + description + "]";
	}

	
	
	
}
