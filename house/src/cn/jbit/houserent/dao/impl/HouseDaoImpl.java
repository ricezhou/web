package cn.jbit.houserent.dao.impl;

import java.util.List;

import org.hibernate.Session;

import cn.jbit.houserent.dao.HibernateUtil;
import cn.jbit.houserent.dao.IHouseDao;
import cn.jbit.houserent.entity.*;

public class HouseDaoImpl implements IHouseDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Info> select1(Integer price) throws Exception {
		Session session = HibernateUtil.currentSession();
		String hql = "select new cn.jbit.houserent.entity.Info(h.street.name,count(h)) from House h where h.price>:price group by h.street.name";
		return session.createQuery(hql).setParameter("price", price).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Info> select2(Short typeId, Integer price) throws Exception {
		Session session = HibernateUtil.currentSession();
		String hql = "select new cn.jbit.houserent.entity.Info(h.street.name,count(h)) from House h where h.price<:price and h.types.id=:type group by h.street.name";
		return session.createQuery(hql).setParameter("price", price)
				.setParameter("type", typeId).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Street> select3(Long count) throws Exception {
		Session session = HibernateUtil.currentSession();
		String hql = "from Street s where :count<(select count(h) from s.houses h)";
		return session.createQuery(hql).setParameter("count", count).list();
	}

	/**
	 * 按房屋租金、标题、发布日期以及联系人查询房屋信息，并分页显示房屋信息。
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<House> selectHouse(PageInfo<House> pageInfo,
			HouseCondition condition) throws Exception {
		StringBuilder hql = new StringBuilder("from House where 1=1");
		if (null != condition.getStartPrice())
			hql.append(" and price>:startPrice");
		if (null != condition.getEndPrice())
			hql.append(" and price<:endPrice");
		if (null != condition.getTitle())
			hql.append(" and title like :title");
		if (null != condition.getStartPubdate())
			hql.append(" and pubdate>:startPubdate");
		if (null != condition.getEndPubdate())
			hql.append(" and pubdate<:endPubdate");
		Session session = HibernateUtil.currentSession();
		hql.append(" order by pubdate desc");
		// 查询符合条件的总记录数
		String countHQL = "select count(*)  " + hql.toString();
		Long count = (Long) session.createQuery(countHQL)
				.setProperties(condition).uniqueResult();
		pageInfo.setCount(count.intValue());// 设置总记录数
		pageInfo.setPageList(session
				.createQuery(hql.toString())
				.setProperties(condition)
				.setFirstResult(
						(pageInfo.getPageIndex() - 1) * PageInfo.PAGESIZE)
				.setMaxResults(PageInfo.PAGESIZE).list());// 设置当前页显示记录集合
		return pageInfo;
	}
}
