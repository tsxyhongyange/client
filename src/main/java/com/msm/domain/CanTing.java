package com.msm.domain;

import java.io.Serializable;

public class CanTing implements Serializable {
	private String loc;
	private double zprice;

	public CanTing(String loc, double zprice) {
		super();
		this.loc = loc;
		this.zprice = zprice;
	}

	public CanTing() {
		super();
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public double getZprice() {
		return zprice;
	}

	public void setZprice(double zprice) {
		this.zprice = zprice;
	}

	@Override
	public String toString() {
		return this.loc + "\t\t" + this.zprice;
	}

}
