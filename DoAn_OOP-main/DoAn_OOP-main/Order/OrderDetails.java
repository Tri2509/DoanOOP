package Order;

public class OrderDetails{
	private int orderID;
	private int ProductID;
	private String ProductName;
	private int quantity;
	private int price;
	
	
	public OrderDetails() {
	}


	public OrderDetails(int orderID, int productID, int quantity, int price,String ProductName) {
		this.orderID = orderID;
		this.ProductID = productID;
		this.quantity = quantity;
		this.price = price;
		this.ProductName = ProductName;
	}

	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public int getProductID() {
		return ProductID;
	}


	public void setProductID(int productID) {
		this.ProductID = productID;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getProductName() {
		return ProductName;
	}


	public void setProductName(String productName) {
		ProductName = productName;
	}
	
	
}