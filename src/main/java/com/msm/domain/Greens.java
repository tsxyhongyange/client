package com.msm.domain;

import java.io.Serializable;

public class Greens implements Serializable {
	private int gid;
	private String gname;
	private double gprice;
	private double gpriced;
	private int gvolume;
	private int gtypeid;
	private int cdelete;

	public Greens() {
		super();
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public double getGprice() {
		return gprice;
	}

	public void setGprice(double gprice) {
		this.gprice = gprice;
	}

	public double getGpriced() {
		return gpriced;
	}

	public void setGpriced(double gpriced) {
		this.gpriced = gpriced;
	}

	public int getGvolume() {
		return gvolume;
	}

	public void setGvolume(int gvolume) {
		this.gvolume = gvolume;
	}

	public int getGtypeid() {
		return gtypeid;
	}

	public void setGtypeid(int gtypeid) {
		this.gtypeid = gtypeid;
	}

	public int getCdelete() {
		return cdelete;
	}

	public void setCdelete(int cdelete) {
		this.cdelete = cdelete;
	}

	public Greens(int gid, String gname, double gprice, double gpriced, int gvolume, int gtypeid, int cdelete) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gprice = gprice;
		this.gpriced = gpriced;
		this.gvolume = gvolume;
		this.gtypeid = gtypeid;
		this.cdelete = cdelete;
	}

	@Override
	public String toString() {
		return this.gid + "\t\t" + this.gname + "\t\t" + this.gprice + "\t\t" + this.gpriced + "\t\t" + this.gtypeid;
	}
}
