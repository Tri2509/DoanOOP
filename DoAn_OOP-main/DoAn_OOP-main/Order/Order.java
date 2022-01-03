package Order;

import java.util.Scanner;

import App.QuanLySanPham;
import Product.Product;

@SuppressWarnings("resource")
public class Order implements Tax{
	private OrderDetails orderlist[] = new OrderDetails[99];
	private static QuanLySanPham productlist = new QuanLySanPham();
	private static Product product[] = productlist.getProduct();
	private int n = 0;
	private int orderID;
	
	public Order() {
		
	}
	
	public Order(OrderDetails[] orderlist, int n, int orderID) {
		super();
		this.orderlist = orderlist;
		this.n = n;
		this.orderID = orderID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public void order() {
		int choice;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("----------Đặt hàng-----------");
			System.out.println("1.Thêm sản phẩm");
			System.out.println("2.Xóa sản phẩm");
			System.out.println("3.Xem giỏ hàng");
			System.out.println("4.Xem tổng giá tiền");
			System.out.println("5.Thoát");
			choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1: {
				orderlist = addItem();
				break;
			}
			case 2: {
				orderlist = deleteItem();
				break;
			}
			case 3:{
				orderlist();
				break;
			}
			case 4:{
				System.out.println("Số tiền phải thanh toán: "+calcTotal());
				break;
			}
			case 5:{
				break;
			}
			default:
				System.out.println("Nhập sai! Nhập lại");
			}
		} while (choice != 5);

	}
	
	private OrderDetails[] addItem() {
		ordermenu(product);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập mã sản phẩm muốn thêm: ");
		int productID = Integer.parseInt(scanner.nextLine());
		for(int i=0;i<n;i++) {
			if(productID==orderlist[i].getProductID()) {
				System.out.println("Trùng mã sản phẩm: "+orderlist[i].getProductID());
				return orderlist;
			}
		}
		Product p =null;
		for(int i = 0;i<product.length;i++)
			if(product[i].getProductID()==productID)
				p=product[i];
		if(p==null) {
			System.out.println("Nhập sai mã sản phẩm");
			return orderlist;
		}
		System.out.println("Nhập số lượng: ");
		int quantity = Integer.parseInt(scanner.nextLine());
		OrderDetails newArr[] = new OrderDetails[n + 1];
		for (int i = 0; i < n; i++)
			newArr[i] = orderlist[i];
		newArr[n] = new OrderDetails();
		newArr[n].setOrderID(orderID);
		newArr[n].setProductID(productID);
		newArr[n].setQuantity(quantity);
		newArr[n].setPrice(p.getPrice());
		newArr[n].setProductName(p.getProductName());
		n++;
		return newArr;
	}

	private OrderDetails[] deleteItem() {
		System.out.println("Nhập mã sản phẩm cần xóa");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (orderlist[i].getProductID() == temp)
				j = i;
		if (orderlist == null || j == -1) {
			System.out.println("Không tìm thấy đơn hàng cần xóa");
			return orderlist;
		}
		OrderDetails[] newArr = new OrderDetails[n - 1];
		for (int i = 0, k = 0; i < n; i++) {
			if (i == j)
				continue;
			newArr[k++] = orderlist[i];
		}
		n--;
		return newArr;
	}

	@Override
	public float calcTax(float x) {
		return x*tax;
	}
	
	public float calcTotal() {
		float sum=0;
		for(int i=0;i<n;i++)
			sum+=orderlist[i].getPrice()*orderlist[i].getQuantity();
		return sum+calcTax(sum);
	}

	private void ordermenu(Product[] p) {
		System.out.println("----Danh sách món ăn hiện có----");
		for(int i = 0;i<p.length;i++) {
			System.out.printf((i+1)+".");
			p[i].output();
		}
	}
	
	private void orderlist() {
		System.out.println("----Danh sách các vật phẩm trong giỏ hàng----");
		for(int i=0;i<orderlist.length;i++) {
			System.out.println((i+1)+"."+orderlist[i].getProductName());
		}
	}
}