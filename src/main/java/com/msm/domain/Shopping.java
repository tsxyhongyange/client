package com.msm.domain;

import java.io.Serializable;

public class Shopping implements Serializable {
	private int gid;
	private int cdelete;

	public Shopping(int gid, int cdelete) {
		super();
		this.gid = gid;
		this.cdelete = cdelete;
	}

	public Shopping() {
		super();
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getCdelete() {
		return cdelete;
	}

	public void setCdelete(int cdelete) {
		this.cdelete = cdelete;
	}

}
