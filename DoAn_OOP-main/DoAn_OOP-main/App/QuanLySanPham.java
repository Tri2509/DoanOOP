package App;

import java.util.Scanner;
import Product.*;

@SuppressWarnings("resource")
public class QuanLySanPham {
	private static int n = 0;
	private static Product[] products = new Product[99];

	public void edit() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("(------------------Danh sách chức năng------------------------)");
			System.out.println("1.Thêm sản phẩm");
			System.out.println("2.Xóa sản phẩm");
			System.out.println("3.Chỉnh sửa sản phẩm");
			System.out.println("4.Tìm kiếm sản phẩm");
			System.out.println("5.Danh sách sản phẩm");
			System.out.println("6.Thoát");
			System.out.println("Mời bạn chọn chức năng:");
			choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				products = addProduct();
				break;
			}
			case 2: {
				products = deleteProduct();
				break;
			}
			case 3: {
				editProduct();
				break;
			}
			case 4: {
				searchProduct();
				break;
			}
			case 5: {
				productlist(products);
				break;
			}
			case 6: {
				break;
			}
			default:
				System.out.println("Nhập sai! Nhập lại");
			}
		} while (choice != 6);
	}

	private Product[] addProduct() {
		Product newArr[] = new Product[n + 1];
		int k;
		for (int i = 0; i < n; i++)
			newArr[i] = products[i];
		do {
			System.out.println("Chọn loại sản phẩm: 1.Thức ăn 2.Đồ uống");
			k = Integer.parseInt(new Scanner(System.in).nextLine());
			switch (k) {
			case 1:
				newArr[n] = new Food();
				newArr[n].input();
				for(int i=0;i<n;i++)
					if(newArr[n].getProductID()==products[i].getProductID()) {
						System.out.println("Trùng mã sản phẩm: "+products[i].getProductID());
						return products;
					}
				n++;
				return newArr;
			case 2:
				newArr[n] = new Drink();
				newArr[n].input();
				for(int i=0;i<n;i++)
					if(newArr[n].getProductID()==products[i].getProductID()) {
						System.out.println("Trùng mã sản phẩm: "+products[i].getProductID());
						return products;
					}
				n++;
				return newArr;
			default:
				throw new IllegalArgumentException("Nhập sai! Nhập lại");
			}
		} while (true);
	}

	private Product[] deleteProduct() {
		productlist(products);
		System.out.println("Nhập mã sản phẩm cần xóa: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (products[i].getProductID() == temp)
				j = i;
		if (products == null || j == -1) {
			System.out.println("Không có phần tử để xóa");
			return products;
		}
		Product[] newArr = new Product[n - 1];
		for (int i = 0, k = 0; i < n; i++) {
			if (i == j)
				continue;
			newArr[k++] = products[i];
		}
		n--;
		return newArr;
	}

	private void editProduct() {
		productlist(products);
		System.out.println("Nhập mã sản phẩm cần sửa: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (products[i].getProductID() == temp)
				j = i;
		if (j == -1)
			System.out.println("Không tìm thấy sản phẩm");
		else {
			products[j].input();
		}
	}

	public void searchProduct() {
		System.out.println("Nhập mã sản phẩm cần tìm: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (products[i].getProductID() == temp)
				j = i;
		if (j == -1)
			System.out.println("Không tìm thấy sản phẩm");
		else
			products[j].output();

	}

	public void productlist(Product[] p) {
		System.out.println("--------Danh sách sản phẩm--------");
		for (int i = 0; i < p.length; i++) {
			System.out.printf((i + 1) + ".");
			p[i].output();
		}
	}

	public Product[] getProduct() {
		return products.clone();
	}
}