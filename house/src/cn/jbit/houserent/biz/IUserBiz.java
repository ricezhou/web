package cn.jbit.houserent.biz;

import cn.jbit.houserent.entity.*;

public interface IUserBiz {
	/**
	 * 注册
	 */
	void register(Users user) throws Exception;
	/**
	 * 登录
	 */
	Users login(String name,String password) throws Exception;

}
