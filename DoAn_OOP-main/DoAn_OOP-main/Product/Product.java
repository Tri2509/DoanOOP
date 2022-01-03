package Product;

import java.util.Scanner;

public abstract class Product {
	protected String productName;
	protected int productID;
	protected int amount;
	protected int price;
	protected String productType;

	public Product() {

	}

	public Product(String productName, int productID, int amount, int price, String productType) {
		this.productName = productName;
		this.productID = productID;
		this.amount = amount;
		this.price = price;
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@SuppressWarnings("resource")
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập tên hàng hóa: ");
		productName=scanner.nextLine();
		System.out.println("Nhập mã hàng hóa: ");
		productID = Integer.parseInt(scanner.nextLine());
		System.out.println("Nhập số lượng hàng hóa: ");
		amount = Integer.parseInt(scanner.nextLine());
		System.out.println("Nhập giá tiền: ");
		price = Integer.parseInt(scanner.nextLine());
	}

	@Override
	public String toString() {
		return  "Tên sản phẩm: "+ productName +"|Mã sản phẩm: " + productID+"|Số lượng hàng hóa: " + amount + "|Giá tiền: " + price;
	}

	public void output() {
		System.out.println(toString());
	}
}