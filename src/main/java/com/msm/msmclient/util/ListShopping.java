package com.msm.msmclient.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.msm.domain.Greens;
import com.msm.domain.Shopping;

public class ListShopping {
	private List<Shopping> list;

	public ListShopping() {
		super();
		this.list = new ArrayList<Shopping>();
	}

	// 增加商品
	public String addGreens(Greens g) {
		list.add(new Shopping(g.getGid(), 1));
		return "添加成功！";
	}

	// 删除商品
	public String deleteGreens(int gid) {
		Iterator<Shopping> it = list.iterator();
		while (it.hasNext()) {
			Shopping g = it.next();
			if (g.getGid() == gid) {
				it.remove();
				return "删除成功";
			}
		}
		return "删除失败";
	}

	// 查找商品
	public List<Shopping> findGreens() {
		return list;
	}

}
