package cn.jbit.houserent.biz.impl;

import cn.jbit.houserent.biz.IUserBiz;
import cn.jbit.houserent.dao.IUserDao;
import cn.jbit.houserent.dao.impl.UserDaoImpl;
import cn.jbit.houserent.entity.Users;

public class UserBizImpl implements IUserBiz {
	private IUserDao userdao = new UserDaoImpl();

	/**
	 * 注册
	 */
	@Override
	public void register(Users user) throws Exception {
		this.userdao.insert(user);
	}

	/**
	 * 登录
	 */
	@Override
	public Users login(String name, String password) throws Exception {
		return this.userdao.select(name, password);
	}

}
