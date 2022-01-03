package App;

import java.util.Scanner;
import Customer.Customer;
import Customer.NormalCustomer;
import Customer.VIPCustomer;


@SuppressWarnings("resource")
public class QuanLyKhachHang {
	private static int n = 0;
	private Customer[] customers = new Customer[99];

	public void edit() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("(------------------Danh sách chức năng------------------------)");
			System.out.println("1.Thêm khách hàng");
			System.out.println("2.Xóa khách hàng");
			System.out.println("3.Chỉnh sửa khách hàng");
			System.out.println("4.Tìm kiếm khách hàng");
			System.out.println("5.Danh sách khách hàng");
			System.out.println("6.Thoát");
			System.out.println("Mời bạn chọn chức năng:");
			choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				customers = addCustomer();
				break;
			}
			case 2: {
				customers = deleteCustomer();
				break;
			}
			case 3: {
				editCustomer();
				break;
			}
			case 4: {
				Customer a = searchCustomer();
				if (a==null)
					System.out.println("Không tìm thấy khách hàng");
				else a.output();		
				break;
			}
			case 5: {
				customerList(customers);
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

	Customer[] addCustomer() {
		Customer newArr[] = new Customer[n + 1];
		int k;
		for (int i = 0; i < n; i++)
			newArr[i] = customers[i];
		do {
			System.out.println("Chọn loại khách hàng:");
			System.out.println("1.Khách hàng VIP");
			System.out.println("2.Khách hàng thường");
			System.out.println("3.Khách hàng vãng lai");
			k = Integer.parseInt(new Scanner(System.in).nextLine());
			switch (k) {
			case 1:
				newArr[n] = new VIPCustomer();
				newArr[n].input();
				for(int i=0;i<n;i++)
					if(newArr[n].getCustomerID()==customers[i].getCustomerID()) {
						System.out.println("Trùng mã khách hàng: "+customers[i].getCustomerID());
						return customers;
					}
				n++;
				return newArr;
			case 2:
				newArr[n] = new NormalCustomer();
				newArr[n].input();
				for(int i=0;i<n;i++)
					if(newArr[n].getCustomerID()==customers[i].getCustomerID()) {
						System.out.println("Trùng mã khách hàng: "+customers[i].getCustomerID());
						return customers;
					}
				n++;
				return newArr;
			case 3:
				newArr[n] = new Customer();
				newArr[n].input();
				for(int i=0;i<n;i++)
					if(newArr[n].getCustomerID()==customers[i].getCustomerID()) {
						System.out.println("Trùng mã khách hàng: "+customers[i].getCustomerID());
						return customers;
					}
				n++;
				return newArr;
			default:
				throw new IllegalArgumentException("Nhập sai! Nhập lại");
			}
		} while (true);
	}

	private Customer[] deleteCustomer() {
		customerList(customers);
		System.out.println("Nhập mã khách hàng cần xóa: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (customers[i].getCustomerID() == temp)
				j = i;
		if (customers == null || j == -1) {
			System.out.println("Không tìm thấy khách hàng cần xóa");
			return customers;
		}
		Customer[] newArr = new Customer[n - 1];
		for (int i = 0, k = 0; i < n; i++) {
			if (i == j)
				continue;
			newArr[k++] = customers[i];
		}
		n--;
		return newArr;
	}

	private void editCustomer() {
		customerList(customers);
		System.out.println("Nhập mã khách hàng cần sửa: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (customers[i].getCustomerID() == temp)
				j = i;
		if (j == -1)
			System.out.println("Không tìm thấy khách hàng");
		else {
			customers[j].input();
		}
	}

	public Customer searchCustomer() {
		System.out.println("Nhập mã khách hàng cần tìm: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (customers[i].getCustomerID() == temp)
				j = i;
		if (j == -1)
			return null;
		else
			return customers[j];
	}

	private void customerList(Customer[] c) {
		System.out.println("-------Danh sách khách hàng------");
		for (int i = 0; i < c.length; i++) {
			System.out.printf((i + 1) + ".");
			c[i].output();
		}

	}
}