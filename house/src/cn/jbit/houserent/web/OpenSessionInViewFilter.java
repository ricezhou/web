package cn.jbit.houserent.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.jbit.houserent.dao.HibernateUtil;

public class OpenSessionInViewFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		Session session = null;
		Transaction tx = null;
		try {
			// 请求到达时，打开Session并启动事务
			session = HibernateUtil.currentSession();
			tx = session.beginTransaction();
			// 执行请求处理链
			arg2.doFilter(arg0, arg1);
			// 返回响应时，提交事务
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			// 关闭session
			HibernateUtil.closeSession();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
