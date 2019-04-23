package com.msm.domain;

import java.io.Serializable;

public class Tuser implements Serializable{
	private int userid;
	private String uname;
	private int mtype;
	private int cdelete;
	public Tuser(int userid, String uname, int mtype, int cdelete) {
		super();
		this.userid = userid;
		this.uname = uname;
		this.mtype = mtype;
		this.cdelete = cdelete;
	}
	public Tuser() {
		super();
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getMtype() {
		return mtype;
	}
	public void setMtype(int mtype) {
		this.mtype = mtype;
	}
	public int getCdelete() {
		return cdelete;
	}
	public void setCdelete(int cdelete) {
		this.cdelete = cdelete;
	}
	@Override
	public String toString() {
		return "用户ID为："+this.getUserid()+"用户姓名为："+this.getUname();
	}
	
}
