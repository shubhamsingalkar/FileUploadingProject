package com.jbk.entity;

public class User {

	private int userid;
	private String name;
	private String branch;
	private long amount;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userid, String name, String branch, long amount) {
		super();
		this.userid = userid;
		this.name = name;
		this.branch = branch;
		this.amount = amount;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", branch=" + branch + ", amount=" + amount + "]";
	}
	
}
