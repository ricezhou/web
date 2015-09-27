package cn.jbit.houserent.biz.impl;

import java.util.List;

import cn.jbit.houserent.biz.IHouseBiz;
import cn.jbit.houserent.dao.IHouseDao;
import cn.jbit.houserent.dao.impl.HouseDaoImpl;
import cn.jbit.houserent.entity.*;

public class HouseBizImpl implements IHouseBiz {
	private IHouseDao houseDao = new HouseDaoImpl();

	@Override
	public List<Info> find1(Integer price) throws Exception {
		return this.houseDao.select1(price);
	}

	@Override
	public List<Info> find2(Short typeId, Integer price) throws Exception {
		return this.houseDao.select2(typeId, price);
	}

	@Override
	public List<Street> find3(Long count) throws Exception {
		return this.houseDao.select3(count);
	}
	@Override
	public PageInfo<House> search(PageInfo<House> pageInfo,
			HouseCondition condition) throws Exception {
		return this.houseDao.selectHouse(pageInfo, condition);
	}
}
