package bean;

public class CateBean {
	private String cateID;
	private String cateName;
	public CateBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CateBean(String cateID, String cateName) {
		super();
		this.cateID = cateID;
		this.cateName = cateName;
	}
	public String getCateID() {
		return cateID;
	}
	public void setCateID(String cateID) {
		this.cateID = cateID;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
		
}
