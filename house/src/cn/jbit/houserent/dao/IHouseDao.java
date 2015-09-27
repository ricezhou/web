package cn.jbit.houserent.dao;

import java.util.List;

import cn.jbit.houserent.entity.*;

public interface IHouseDao {
	/**
	 * 统计各个街道房屋的租金高于3000元的房屋信息的条数。
	 */
	List<Info> select1(Integer price) throws Exception;

	/**
	 * 统计各个街道一室一厅、租金低于2000元的房屋信息的条数。
	 */
	List<Info> select2(Short typeId, Integer price) throws Exception;

	/**
	 * 列出房屋信息条数大于50条的所有街道。
	 */
	List<Street> select3(Long count) throws Exception;
	/**
	 * 按房屋租金、标题、发布日期以及联系人查询房屋信息，并分页显示房屋信息。
	 * PageInfo类用来封装分页信息。
	 * HouseCondition类用来封装查询条件
	 */
	PageInfo<House> selectHouse(PageInfo<House> pageInfo,
			HouseCondition condition) throws Exception;
}
