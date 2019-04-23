package com.msm.msmclient.control;

import java.util.List;

import com.msm.domain.Bill;
import com.msm.domain.CanTing;
import com.msm.domain.Employee;
import com.msm.domain.Greens;
import com.msm.domain.Tuser;

public interface Service {

	// 添加小票
	public String addBill(Bill b);

	// 获取小票 某个用户所有的小票
	public List<Bill> selectBill(int userid);

	// 获取餐厅消费排行榜
	public List<CanTing> findCT();

	// 开卡
	public String bopenCard(int userid);

	// 查询余额
	public double selectBal(int userid);

	// 查看是否有卡(开卡前判断)
	public String selectCard(int userid);

	// 查询卡号
	public int selectCardId(int userid);

	// 挂失
	public String blossCard(int userid);

	// 激活
	public String baliveCard(int userid);

	// 充值
	public String bchangeCard(int userid, int cardbal);

	// 判断卡是否被挂失
	public String bisloss(int userid);

	// 增加员工
	public String addEmployee(Employee e);

	// 删除员工
	public String deleteEmployee(int eid);

	// 获取员工
	public Employee selectEmployee(int eid);

	// 获取经理
	public String selectManager(int mgr);

	// 获取工作地点
	public String selectLoc(int eid);

	// 增加菜品
	public String addGreens(Greens g);

	// 修改菜品价格
	public String updatePrice(int gid, double uprice);

	// 修改今日价格
	public String updatePriced(int gid, int priced);

	// 删除菜品
	public String delete(int gid);

	// 最受欢迎的菜
	public List<Greens> welGreens();

	// 查询所有菜品
	public List<Greens> selectGreens();

	// 根据菜品ID查询菜品
	public Greens selectGreensById(int gid);

	// 添加用户
	public String addTuser(Tuser t);

	// 修改用户会员
	public String updateTuser(Tuser t, int mtype);

	// 冻结用户
	public String bfreezeTuser(int userid);

	// 查找用户 id
	public Tuser selectTuser(int userid);

	// 查找用户 姓名
	public Tuser selectTuserName(String uname);

	// 判断用户是否被冻结
	public String bisfreeze(int userid);
}
