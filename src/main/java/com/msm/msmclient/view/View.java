package com.msm.msmclient.view;

import java.util.List;

import com.msm.domain.Greens;

public class View {
	public void welcome() {
		System.out.println("欢迎来到亚惠餐厅管理系统");
		System.out.println("=======================");
		System.out.println();
		System.out.println();
		System.out.println("1.员工登录");
		System.out.println();
		System.out.println("2.经理登录");
		System.out.println();
		System.out.println("0.退出系统");
		System.out.println();
		System.out.println();
		System.out.println("=======================");
	}

	public void println(String msg) {
		System.out.println(msg);
	}

	// 二级菜单
	public void employeeG() {
		System.out.println("=======================");
		System.out.println();
		System.out.println();
		System.out.println("1.点餐");
		System.out.println();
		System.out.println("2.结账");
		System.out.println();
		System.out.println("3.开卡");
		System.out.println();
		System.out.println("4.挂失");
		System.out.println();
		System.out.println("5.充值");
		System.out.println();
		System.out.println("6.退出登录");
		System.out.println();
		System.out.println("0.返回");
		System.out.println();
		System.out.println();
		System.out.println("=======================");
	}

	// 点餐表头栏
	public void showGreen(List<Greens> arr) {
		System.out.println("菜品id\t\t菜名\t\t菜品价格\t\t菜品今日价格");
		for (Greens g : arr) {
			System.out.println(g.getGid() + "\t\t" + g.getGname() + "\t\t" + g.getGprice() + "\t\t" + g.getGpriced());
		}
	}

	// 结账三级菜单
	public void showpaymethod() {
		System.out.println(">>>请选择结账方式");
		System.out.println("1.现金");
		System.out.println("2.刷卡");
	}

	public void showpaymethod2() {
		System.out.println(">>>请选择刷卡类型");
		System.out.println("1.普通会员刷卡");
		System.out.println("2.超级会员刷卡");
		System.out.println("0.返回");
	}

	// 经理登录二级菜单
	public void managerG() {
		System.out.println("=======================");
		System.out.println();
		System.out.println();
		System.out.println("1.员工管理");
		System.out.println();
		System.out.println("2.菜品管理");
		System.out.println();
		System.out.println("3.补卡");
		System.out.println();
		System.out.println("4.账户冻结");
		System.out.println();
		System.out.println("5.销售金额");
		System.out.println();
		System.out.println("6.销量排行榜");
		System.out.println();
		System.out.println("7.特价菜设置");
		System.out.println();
		System.out.println("8.会员优惠额度设置");
		System.out.println();
		System.out.println("0.返回上一层");
		System.out.println();
	}

	// 经理登录后三级菜单
	public void guanliEmployee() {
		System.out.println("1.添加员工");
		System.out.println("2.删除员工");
		System.out.println("0.返回上一层");
	}

	public void guanliGreens() {
		System.out.println("1.添加菜品");
		System.out.println("2.修改菜品价格");
		System.out.println("3.查看菜品");
		System.out.println("4.删除菜品");
		System.out.println("0.返回上一层");
	}

	public void discountsM() {
		System.out.println(">>>设置优惠额度在0—1之间");
		System.out.println("1.普通会员优惠");
		System.out.println("2.超级会员优惠");
		System.out.println("0.返回上一层");
	}
}
