package com.msm.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Bill implements Serializable {
	private String uuid;
	private int eid;
	private int userid;
	private int cardid;
	Date bdate;
	private double bprice;
	private String loc;
	private String day;

	public Bill(int eid, int userid, int cardid, double bprice, String loc) {
		super();
		UUID uu = UUID.randomUUID();
		String s = uu.toString();
		String ss = s.replaceAll("-", "");
		this.uuid = ss;
		this.eid = eid;
		this.userid = userid;
		this.cardid = cardid;
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		day = df.format(d);
		this.bdate = d;
		this.bprice = bprice;
		this.loc = loc;
	}

	public Bill() {
		super();
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCardid() {
		return cardid;
	}

	public void setCardid(int cardid) {
		this.cardid = cardid;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public double getBprice() {
		return bprice;
	}

	public void setBprice(double bprice) {
		this.bprice = bprice;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "订单编号为：" + this.getUuid() + "收银员为：" + this.getEid() + "时间为：" + this.getDay() + "\n" + this.getLoc()
				+ "亚惠餐厅";
	}
}
