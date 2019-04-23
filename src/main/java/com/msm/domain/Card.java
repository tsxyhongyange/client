package com.msm.domain;

import java.io.Serializable;

public class Card implements Serializable {
	private int cardid;
	private double cardbal;
	private int userid;
	private int cdelete;

	public Card(int cardid, double cardbal, int userid, int cdelete) {
		super();
		this.cardid = cardid;
		this.cardbal = cardbal;
		this.userid = userid;
		this.cdelete = cdelete;
	}

	public Card() {
		super();
	}

	public int getCardid() {
		return cardid;
	}

	public void setCardid(int cardid) {
		this.cardid = cardid;
	}

	public double getCardbal() {
		return cardbal;
	}

	public void setCardbal(double cardbal) {
		this.cardbal = cardbal;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCdelete() {
		return cdelete;
	}

	public void setCdelete(int cdelete) {
		this.cdelete = cdelete;
	}

}
