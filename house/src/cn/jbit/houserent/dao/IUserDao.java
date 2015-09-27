package cn.jbit.houserent.dao;

import cn.jbit.houserent.entity.Users;

public interface IUserDao {
	/**
	 * 注册
	 */
	void insert(Users user) throws Exception;
	/**
	 * 登录
	 */
	Users select(String name,String password) throws Exception;
	

}
