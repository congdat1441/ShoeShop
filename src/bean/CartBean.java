package bean;

public class CartBean {
	private Integer quantity;
	private Long priceItem;
	public ShoeBean shoeBean;

	public CartBean() {
		super();
	}

	public CartBean(Integer quantity, Long priceItem, ShoeBean shoeBean) {
		super();
		this.quantity = quantity;
		this.priceItem = priceItem;
		this.shoeBean = shoeBean;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getPriceItem() {
		return priceItem;
	}
	public void setPriceItem(Long priceItem) {
		this.priceItem = priceItem;
	}
	public ShoeBean getShoeBean() {
		return shoeBean;
	}
	public void setShoeBean(ShoeBean shoeBean) {
		this.shoeBean = shoeBean;
	}

}
