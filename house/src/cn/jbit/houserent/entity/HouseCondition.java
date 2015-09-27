package cn.jbit.houserent.entity;

import java.util.Date;

public class HouseCondition {
    private String title;
    private Integer startPrice;
    private Integer endPrice;
    private Date startPubdate;
    private Date endPubdate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(Integer startPrice) {
		this.startPrice = startPrice;
	}
	public Integer getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(Integer endPrice) {
		this.endPrice = endPrice;
	}
	public Date getStartPubdate() {
		return startPubdate;
	}
	public void setStartPubdate(Date startPubdate) {
		this.startPubdate = startPubdate;
	}
	public Date getEndPubdate() {
		return endPubdate;
	}
	public void setEndPubdate(Date endPubdate) {
		this.endPubdate = endPubdate;
	}
    
}
