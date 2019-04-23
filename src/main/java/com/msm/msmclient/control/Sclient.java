package com.msm.msmclient.control;

import java.util.List;

import com.msm.domain.CanTing;
import com.msm.domain.Employee;
import com.msm.domain.Greens;
import com.msm.domain.Shopping;
import com.msm.domain.Tuser;
import com.msm.msmclient.util.ListShopping;
import com.msm.msmclient.util.UserInput;
import com.msm.msmclient.view.View;

public class Sclient {
	// 属性
	private View v;
	private UserInput ui;
	private ListShopping ls;
	public static final String IP = "10.10.49.40";
	public static final int PORT = 6666;
	public int empid;// 员工id
	public int userid;// 用户id
	public Tuser tuser;// 用户
	private Service service;
	private double dis;

	// 构造方法
	public Sclient() {
		super();
		this.v = new View();
		this.ui = new UserInput();
		this.ls = new ListShopping();
		// 创建代理对象
		service = ProxyClient.getClient(Service.class, IP, PORT);

	}

	// 自定义方法 --项目流程
	public void start() {
		// 员工或经理登录
		// 获取员工id 密码或者经理id 密码
		while (true) {
			this.v.welcome();
			int select = this.ui.getInt("请选择:");
			if (select == 0) {
				this.v.println("系统终止");
				System.exit(0);
			} else if (select == 1) {
				this.employeeLoad();
				this.tuser();
				this.v.employeeG();
				System.out.println(tuser);

				// // 员工的功能
				loopE: while (true) {
					int selectE = this.ui.getInt("请选择:");
					if (selectE == 6) {
						break loopE;// 返回上一层界面
					} else if (selectE == 1) {
						// 点餐
						this.showGreens();
						this.chooseGreens();
					} else if (selectE == 2) {

					} else if (selectE == 3) {
						this.openCard();
					} else if (selectE == 4) {
						this.lossCard();
					} else if (selectE == 5) {
						this.top_up();
					} else if (selectE == 0) {
						this.tuser();
						this.v.employeeG();
					} else {
						this.v.println("请正确输入指令");
					}
				}
			} else if (select == 2) {
				// 经理登录
				this.managerLoad();
				this.v.managerG();
				loopM: while (true) {
					int selectM = this.ui.getInt("请选择:");
					if (selectM == 0) {
						break loopM;
					} else if (selectM == 1) {
						this.guanEmployee();
					} else if (selectM == 2) {
						this.guanGreens();
					} else if (selectM == 3) {
						this.aliveCard();
					} else if (selectM == 4) {
						this.freezeIsUser();
					} else if (selectM == 5) {
						this.sale();
					} else if (selectM == 6) {
						this.saleNum();
					} else if (selectM == 7) {
						this.onSale();
					} else if (selectM == 8) {

					} else if (selectM == 9) {

					} else {
						this.v.println("请正确输入指令");
					}

				}
			} else {
				System.out.println("请输入正确指令");
			}
		}
	}

	// 员工登录
	private void employeeLoad() {

		int id = this.ui.getInt("请输入员工id:");
		String s = this.ui.getString("请输入员工密码:");
		String epassword = this.service.selectEmployee(id).getEpassword();
		String ename = this.service.selectEmployee(id).getEname();
		int eid = this.service.selectEmployee(id).getEid();
		// 判断是否成功 不成功显示账号密码不正确
		if (s.equals(epassword)) {
			System.out.println("欢迎员工" + ename + "登录");

		} else {
			System.out.println("id或密码输入不正确，请重新输入");
		}

	}

	// 输入用户信息
	private void tuser() {
		String tname = this.ui.getString("请输入客户姓名:");
		Tuser t = this.service.selectTuserName(tname);
		tuser = t;
		if (t != null) {
			System.out.println("欢迎客户" + t.getUname());
		} else {
			// 添加用户
			System.out.println("您第一次来我们店消费,需要添加您为我们的客户");

			System.out.println(this.service.addTuser(new Tuser(0, tname, 0, 1)));
			Tuser tt = this.service.selectTuserName(tname);
			System.out.println("您的ID为:" + tt.getUserid());
			tuser = tt;
		}

	}

	// 显示菜品的方法
	private void showGreens() {
		v.println("菜品信息如下");
		List<Greens> list = this.service.selectGreens();
		this.v.showGreen(list);
		/*
		 * for (Greens g : list) { System.out.println(g.getGid() + "\t\t" +
		 * g.getGname() + "\t\t" + g.getGprice() + "\t\t" + g.getGpriced() +
		 * "\t\t" + g.getGtypeid() + "\t\t" + g.getGvolume());
		 * 
		 * }
		 */
	}

	// 选择餐品并结账的方法
	private void chooseGreens() {
		int gid = 0;
		Greens g = null;
		String str = "";
		while (true) {
			gid = this.ui.getInt("请选择菜品id:");
			// 调用根据菜品id查询菜品信息的方法
			g = this.service.selectGreensById(gid);
			// 将选择的菜品添加进去
			System.out.println(this.ls.addGreens(g));
			// 询问是否继续点餐
			str = this.ui.getString("您是否继续点餐(y/n):");
			if (str.equals("y")) {
				gid = this.ui.getInt("请选择菜品id:");
				// 调用根据菜品id查询菜品信息的方法
				g = this.service.selectGreensById(gid);
				// 将选择的菜品添加进去
				System.out.println(this.ls.addGreens(g));
				str = this.ui.getString("您是否继续点餐(y/n):");
			} else if (str.equals("n")) {
				break;
			}
		}
		System.out.println("您的订单信息如下:");
		List<Shopping> list = this.ls.findGreens();
		System.out.println("菜品id\t\t菜品名称\t\t菜品价格\t\t菜品今日价格\t\t");
		double price = 0;
		for (Shopping s : list) {
			Greens gr = this.service.selectGreensById(s.getGid());
			System.out.println(g.getGname() + "\t\t" + g.getGprice() + "\t\t" + g.getGpriced());
			price += g.getGprice();
		}
		System.out.println("总价是:" + price);
		String ss = this.ui.getString("您是否去结账(y/n)");
		if ("y".equals(ss)) {
			System.out.println("结账方式如下:");
			this.v.showpaymethod();
			int i = this.ui.getInt("请选择:");
			if (i == 1) {
				// 现金
				double z = this.ui.getDouble("请输入您的交费金额:");
				System.out.println("您一共消费" + price);
				double change = z - price;
				System.out.println("找您" + change + "元");
				this.v.employeeG();
			} else if (i == 2) {
				pay: while (true) {
					this.v.showpaymethod2();
					int j = this.ui.getInt("请选择:");
					int mtype = 0;
					double bal = 0;
					if (j == 1) {
						// 判断该用户是否为普通会员
						mtype = tuser.getMtype();
						bal = this.service.selectBal(tuser.getUserid());
						if (mtype == 1 && bal >= price) {
							System.out.println("您为我店普通会员，可享受折扣");
							System.out.println("您卡中余额为\t" + bal + "\t元,本次消费\t" + price + "\t元,应扣除\t" + (price * dis)
									+ "\t元,卡内余额为\t" + (bal - price * dis) + "\t元");
						} else {
							System.out.println("您不是我店普通会员");
							this.v.showpaymethod2();
							break;
						}
					} else if (j == 2) {
						mtype = tuser.getMtype();
						bal = this.service.selectBal(tuser.getUserid());
						if (mtype == 2 && bal >= price) {
							System.out.println("您为我店超级会员，可享受折扣");
							System.out.println("您卡中余额为\t" + bal + "\t元,本次消费\t" + price + "\t元,应扣除\t" + (price * dis)
									+ "\t元,卡内余额为\t" + (bal - price * dis) + "\t元");
						} else {
							System.out.println("您不是我店超级会员");
							this.v.showpaymethod2();
							break;
						}
						// 价格*0.8

					} else if (j == 0) {

					}
				}
			}
		}
	}

	// 开卡
	private void openCard() {
		int uid = this.ui.getInt("请输入用户id:");
		String s = this.service.selectCard(uid);
		if (s.equals("您已经有卡了")) {
			System.out.println("您已经有卡，无需办卡");
		} else {
			String b = this.service.bopenCard(uid);
			System.out.println("开卡成功,请牢记您的卡号:" + this.service.selectCardId(uid) + "用户id为" + uid);

		}
	}

	// 充值
	private void top_up() {
		this.v.println("一次性充值300-500成为我店普通会员,500以上成为超级会员");

		int p = 1;
		int s = 2;
		int uid = this.ui.getInt("请输入您的id:");
		int money = this.ui.getInt("请输入您充值的金额:");
		// 是否充值成功
		System.out.println(this.service.bchangeCard(uid, money));
		if (money >= 300 && money < 500) {
			this.service.updateTuser(this.service.selectTuser(uid), 1);
			System.out.println("您已经成为普通会员");
			System.out.println("充值成功,卡里的余额为：" + this.service.selectBal(uid));
		} else if (money >= 500) {
			// 设置会员类型为2
			this.service.updateTuser(this.service.selectTuser(uid), 2);
			System.out.println("您已成为超级会员");
			System.out.println("充值成功,卡里余额为:" + this.service.selectBal(uid));
		} else {
			this.service.updateTuser(this.service.selectTuser(uid), 2);
			System.out.println("充值成功,卡中余额为" + this.service.selectBal(uid));
		}

	}

	// 挂失
	public void lossCard() {
		int uid = this.ui.getInt("请输入用户id");
		String bisloss = this.service.bisloss(uid);
		if (bisloss.equals("卡已经被挂失了！")) {
			System.out.println("您的卡已经挂失");
		} else {
			System.out.println(this.service.blossCard(uid));
		}
	}

	private void managerLoad() {
		// 经理登录
		while (true) {
			int m = this.ui.getInt("请输入经理id:");
			String mpassword = this.ui.getString("请输入经理密码:");
			String mpassword2 = this.service.selectManager(m);
			// 判断是否成功 不成功显示账号密码不正确
			if (mpassword.equals(mpassword2)) {
				System.out.println("欢迎经理登录");
				break;
			} else {
				System.out.println("账号密码输入错误,请重新输入");
			}
		}
	}
	// 登陆成功后显示经理功能

	// 管理员工的方法
	private void guanEmployee() {
		this.v.guanliEmployee();
		int i = this.ui.getInt("请选择:");
		int id = 0;
		String ename = "";
		Employee e = null;
		id = this.ui.getInt("请输入员工id:");
		ename = this.ui.getString("请输入员工姓名:");
		if (i == 1) {
			// 调用添加员工的方法判断员工id是否存在
			e = this.service.selectEmployee(id);
			if (e.getEid() == id) {
				System.out.println("该员工已存在");
			} else {
				this.service.addEmployee(new Employee(id, 1, ename, "0000"));
			}
		} else if (i == 2) {
			System.out.println(this.service.selectEmployee(id));
			String s = this.ui.getString("您确认删除此员工信息吗(y/n)");
			// 调用删除员工的方法
			if (s.equals("y")) {
				System.out.println(this.service.deleteEmployee(id));
			} else {
				System.out.println("取消删除");
			}
		} else if (i == 0) {
			this.v.managerG();
		}
	}

	// 管理菜品的方法
	private void guanGreens() {
		this.v.guanliGreens();
		int i = this.ui.getInt("请选择:");
		int id = 0;
		if (i == 1) {
			// 查询菜品是否存在
			Greens greens = this.service.selectGreensById(id);
			if (greens != null) {
				System.out.println("菜品已存在,请勿重复添加");
			} else {
				id = this.ui.getInt("请输入菜品id:");
				String gname = this.ui.getString("请输入菜品名称:");
				double price = this.ui.getDouble("请输入菜品价格:");
				double priced = this.ui.getDouble("请输入菜品今日价格:");
				int num = this.ui.getInt("请输入菜品销量:");
				int type = this.ui.getInt("请输入菜品类型:");
				int c = this.ui.getInt("请输入菜状态:");
				String str = this.service.addGreens(new Greens(id, gname, price, priced, num, type, c));
				System.out.println(str);
			}
		} else if (i == 2) {
			// 查询菜品是否存在
			int gid = this.ui.getInt("请输入菜品id:");
			double uprice = this.ui.getDouble("请输入修改的价格");
			Greens greens = this.service.selectGreensById(id);
			if (greens != null) {
				String str2 = this.service.updatePrice(gid, uprice);
				System.out.println(str2);
			} else {
				System.out.println("不存在该菜品");
			}
		} else if (i == 3) {
			System.out.println("菜品id\t\t菜名\t\t菜品价格\t\t菜品今日价格\t\t菜品销量\t\t菜品类型\t\t菜品状态");
			List<Greens> list = this.service.selectGreens();
			for (Greens g : list) {
				System.out.println(g.getGid() + "\t\t" + g.getGname() + "\t\t" + g.getGprice() + "\t\t" + g.getGprice()
						+ "\t\t" + g.getGpriced() + "\t\t" + g.getGvolume() + "\t\t" + g.getGtypeid() + "\t\t"
						+ g.getCdelete());
			}
		} else if (i == 4) {
			int gid = this.ui.getInt("请输入菜品id:");
			Greens greens = this.service.selectGreensById(gid);
			if (greens != null) {
				String delete = this.service.delete(gid);
				System.out.println(delete);
			} else {
				System.out.println("菜品不存在");
			}
		} else if (i == 0) {
			this.v.managerG();
		} else {
			System.out.println("指令无效");
		}
	}

	// 补卡激活
	private void aliveCard() {
		// 判断卡是否被挂失
		int uid = this.ui.getInt("请输入用户id:");
		String bisloss = this.service.bisloss(uid);
		if (bisloss.equals("卡没被挂失")) {
			System.out.println(this.service.baliveCard(uid));
		} else {
			System.out.println("您的卡未被挂失，不用激活");
		}
	}

	// 用户冻结
	private void freezeIsUser() {
		int uid = this.ui.getInt("请输入用户id:");
		String bisfreeze = this.service.bisfreeze(uid);
		if (bisfreeze.equals("账户没有被冻结！")) {
			System.out.println(this.service.bfreezeTuser(uid));
		} else {
			System.out.println("账户已被冻结！");
		}
	}

	// 销售金额
	private void sale() {
		System.out.println("亚惠餐厅各连锁店销售金额如下");
		List<CanTing> findCT = this.service.findCT();
		for (CanTing c : findCT) {
			System.out.println(c.getLoc() + "亚惠餐厅,总收入为:" + c.getZprice());
		}
	}

	// 销量排行
	private void saleNum() {
		System.out.println("菜品销量信息如下:");
		System.out.println("菜品id\t\t菜名\t\t菜品销量");
		List<Greens> w = this.service.welGreens();
		for (Greens g : w) {
			System.out.println(g.getGid() + "\t\t" + g.getGname() + "\t\t" + g.getGvolume());
		}
	}

	// 特价菜
	private void onSale() {
		// 销量最低的设置为特价菜
		int num = 0;
		int id = 0;
		List<Greens> w = this.service.welGreens();

	}

	// 会员优惠额度
	private void setDiscount() {
		int i = this.ui.getInt("请输入您想设置的会员类型:");
		int mtype = tuser.getMtype();
		if (i == 1 && tuser.getMtype() == 1) {
			dis = this.ui.getDouble("请设置普通会员的折扣(0-1):");
		} else if (i == 2 && tuser.getMtype() == 2) {
			dis = this.ui.getDouble("请设置超级会员的折扣(0-1):");
		}
	}
}
