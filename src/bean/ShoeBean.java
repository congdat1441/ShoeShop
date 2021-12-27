package bean;

public class ShoeBean {
	private String shoeID;
	private String nameShoe;
	private Long count;
	private	Long price;
	private String cateID;
	private String photo;
	public ShoeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoeBean(String shoeID, String nameShoe, Long count, Long price, String cateID, String photo) {
		super();
		this.shoeID = shoeID;
		this.nameShoe = nameShoe;
		this.count = count;
		this.price = price;
		this.cateID = cateID;
		this.photo = photo;
	}
	public String getShoeID() {
		return shoeID;
	}
	public void setShoeID(String shoeID) {
		this.shoeID = shoeID;
	}
	public String getNameShoe() {
		return nameShoe;
	}
	public void setNameShoe(String nameShoe) {
		this.nameShoe = nameShoe;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getCateID() {
		return cateID;
	}
	public void setCateID(String cateID) {
		this.cateID = cateID;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
