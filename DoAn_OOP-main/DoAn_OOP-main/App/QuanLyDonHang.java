package App;

import java.util.Scanner;
import Order.Order;

@SuppressWarnings("resource")
public class QuanLyDonHang {
	private static int n = 0;
	private Order[] listBills = new Order[99];

	public void edit() {
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("-----------Danh sách chức năng-----------");
			System.out.println("1.Thêm đơn hàng");
			System.out.println("2.Xóa đơn hàng");
			System.out.println("3.Chỉnh sửa mã đơn hàng");
			System.out.println("4.Điều chỉnh đơn hàng");
			System.out.println("5.Danh sách đơn hàng");
			System.out.println("6.Thoát");
			System.out.println("Mời bạn chọn chức năng: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				listBills = addBills();
				break;
			}
			case 2: {
				listBills = deleteBills();
				break;
			}
			case 3: {
				editBillsID();
				break;
			}
			case 4: {
				editBills();
				break;
			}
			case 5: {
				billslist(listBills);
				break;
			}
			case 6: {
				break;
			}
			default:
				throw new IllegalArgumentException("Nhập sai! Nhập lại");
			}
		} while (choice != 6);
	}

	Order[] addBills() {
		Order newArr[] = new Order[n + 1];
		for (int i = 0; i < n; i++)
			newArr[i] = listBills[i];
		newArr[n] = new Order();
		System.out.println("Nhập mã đơn hàng: ");
		int id = Integer.parseInt(new Scanner(System.in).nextLine());
		for (int i = 0; i < n; i++) {
			if (newArr[n].getOrderID() == listBills[i].getOrderID()) {
				System.out.println("Trùng mã đơn hàng: " + listBills[i].getOrderID());
				return listBills;
			}
		}
		newArr[n].setOrderID(id);
		newArr[n].order();
		n++;
		return newArr;
	}

	private Order[] deleteBills() {
		billslist(listBills);
		System.out.println("Nhập mã đơn hàng cần xóa: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (listBills[i].getOrderID() == temp)
				j = i;
		if (listBills == null || j == -1) {
			System.out.println("Không có phần tử để xóa");
			return listBills;
		}
		Order newArr[] = new Order[n - 1];
		for (int i = 0, k = 0; i < n; i++) {
			if (i == j)
				continue;
			newArr[k++] = listBills[i];
		}
		n--;
		return newArr;
	}

	private void editBillsID() {
		billslist(listBills);
		System.out.println("Nhập mã đơn hàng cần sửa: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (listBills[i].getOrderID() == temp)
				j = i;
		if(j==-1)
			System.out.println("Không tìm thấy đơn hàng");
		else {
			System.out.println("Nhập mã đơn hàng mới : ");
			int id = Integer.parseInt(new Scanner(System.in).nextLine());
			listBills[j].setOrderID(id);
		}
	}
	
	private void editBills() {
		billslist(listBills);
		System.out.println("Nhập mã đơn hàng cần điều chỉnh: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (listBills[i].getOrderID() == temp)
				j = i;
		if(j==-1)
			System.out.println("Không tìm thấy đơn hàng");
		else {
			listBills[j].order();
		}
	}
	
	private void billslist(Order[] orders) {
		System.out.println("------Danh sách đơn hàng------");
		for (int i = 0; i < orders.length; i++) {
			System.out.println((i + 1) + ".Mã: "+orders[i].getOrderID());
		}
	}
	
	public Order searchBills() {
		System.out.println("Nhập mã đơn hàng: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (listBills[i].getOrderID() == temp)
				j = i;
		if (j == -1)
			return null;
		else
			return listBills[j];
	}
}