package bean;

import java.sql.Date;

public class BillBean {
	private String billId;
	private String userId;
	private Date date;
	private Boolean bought;
	public BillBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillBean(String billId, String userId, Date date, Boolean bought) {
		super();
		this.billId = billId;
		this.userId = userId;
		this.date = date;
		this.bought = bought;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getBought() {
		return bought;
	}
	public void setBought(Boolean bought) {
		this.bought = bought;
	}
	
	
}
