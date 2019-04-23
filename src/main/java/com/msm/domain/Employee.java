package com.msm.domain;

import java.io.Serializable;

public class Employee implements Serializable{
	private int eid;
	private int magr;
	private String ename;
	private String epassword;
	public Employee(int eid, int magr, String ename, String epassword) {
		super();
		this.eid = eid;
		this.magr = magr;
		this.ename = ename;
		this.epassword = epassword;
	}
	public Employee() {
		super();
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getMagr() {
		return magr;
	}
	public void setMagr(int magr) {
		this.magr = magr;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEpassword() {
		return epassword;
	}
	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}
	
}
	
