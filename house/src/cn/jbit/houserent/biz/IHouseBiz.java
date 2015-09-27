package cn.jbit.houserent.biz;

import java.util.List;

import cn.jbit.houserent.entity.House;
import cn.jbit.houserent.entity.HouseCondition;
import cn.jbit.houserent.entity.Info;
import cn.jbit.houserent.entity.PageInfo;
import cn.jbit.houserent.entity.Street;

public interface IHouseBiz {
	/**
	 * 统计各个街道房屋的租金高于3000元的房屋信息的条数。
	 */
	List<Info> find1(Integer price) throws Exception;

	/**
	 * 统计各个街道一室一厅、租金低于2000元的房屋信息的条数。
	 */
	List<Info> find2(Short typeId, Integer price) throws Exception;

	/**
	 * 列出房屋信息条数大于50条的所有街道。
	 */
	List<Street> find3(Long count) throws Exception;	/**
	
	 * 按房屋租金、标题、发布日期以及联系人查询房屋信息，并分页显示房屋信息
	 */
	PageInfo<House> search(PageInfo<House> pageInfo, HouseCondition condition)
			throws Exception;
}
