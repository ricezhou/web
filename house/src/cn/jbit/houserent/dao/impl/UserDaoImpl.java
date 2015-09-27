package cn.jbit.houserent.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.jbit.houserent.dao.HibernateUtil;
import cn.jbit.houserent.dao.IUserDao;
import cn.jbit.houserent.entity.Users;

public class UserDaoImpl implements IUserDao {
	/**
	 * 注册
	 */
	@Override
	public void insert(Users user) throws Exception {
		try {
			Session session = HibernateUtil.currentSession();
			session.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 登录
	 */
	@Override
	public Users select(String name, String password) throws Exception {
		Users user = null;
		Session session = HibernateUtil.currentSession();
		user = (Users) session
				.createQuery(
						"from Users where name=:name and password=:password")
				.setString("name", name).setString("password", password)
				.setMaxResults(1).uniqueResult();
		return user;
	}

}
