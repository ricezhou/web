package cn.jbit.houserent.entity;

import java.util.List;

public class PageInfo<T> {
	public static final int PAGESIZE = 3;
	private Integer count;// 总记录数
	private List<T> pageList;// 当前页的记录集合
	private Integer pageIndex;// 当前页号
	private Integer totalPages;// 总页数

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getTotalPages() {
		this.totalPages = this.count / this.PAGESIZE;
		if (this.count % this.PAGESIZE != 0)
			this.totalPages++;
		return this.totalPages;
	}

}
