package bean;

public class HistoryBean {
	private int userId;
	private String fullName;
	private String nameShoe;
	private Long price;
	private int count;
	private Boolean bought;
	private Long billDID;
	public HistoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoryBean(int userId, String fullName, String nameShoe, Long price, int count, Boolean bought,
			Long billDID) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.nameShoe = nameShoe;
		this.price = price;
		this.count = count;
		this.bought = bought;
		this.billDID = billDID;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNameShoe() {
		return nameShoe;
	}
	public void setNameShoe(String nameShoe) {
		this.nameShoe = nameShoe;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Boolean getBought() {
		return bought;
	}
	public void setBought(Boolean bought) {
		this.bought = bought;
	}
	public Long getBillDID() {
		return billDID;
	}
	public void setBillDID(Long billDID) {
		this.billDID = billDID;
	}
	
	
}
