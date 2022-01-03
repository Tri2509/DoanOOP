package App;

import java.util.Scanner;

import Customer.Customer;
import Order.Order;
import Payment.*;

public class App {
	private static QuanLyNhanVien dsNhanVien = new QuanLyNhanVien();
	private static QuanLyKhachHang dsKhachHang = new QuanLyKhachHang();
	private static QuanLySanPham dsSanPham = new QuanLySanPham();
	private static QuanLyDonHang dsMuaHang = new QuanLyDonHang();

	public static void menu() {
		System.out.println("------------------Danh sách mục------------------------");
		System.out.println("1.Khách hàng");
		System.out.println("2.Nhân viên");
		System.out.println("3.Sản phẩm");
		System.out.println("4.Đặt hàng");
		System.out.println("5.Thanh toán");
		System.out.println("6.Thoát");
		System.out.println("Mời bạn chọn mục:");
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int key;
		do {
			menu();
			key = Integer.parseInt(scanner.nextLine());
			switch (key) {
			case 1: {
				dsKhachHang.edit();
				break;
			}
			case 2: {
				dsNhanVien.edit();
				break;
			}
			case 3: {
				dsSanPham.edit();
				break;
			}
			case 4: {
				dsMuaHang.edit();
				break;
			}
			case 5: {
				int k=0;
				Customer temp = null;
				Order tempOrder = null;
				do {
					temp = dsKhachHang.searchCustomer();
					if(temp==null) {
						System.out.println("Không tìm thấy khách hàng! Mời chọn:");
						System.out.println("1.Nhập lại mã khách hàng|2.Thêm khách hàng");
						k = Integer.parseInt(new Scanner(System.in).nextLine());
						switch (k) {
						case 1: {
							break;
						}
						case 2: {
							dsKhachHang.addCustomer();
							break;
						}
						case 3:{
							break;
						}
						default:
							throw new IllegalArgumentException("Giá trị không hợp lệ: " + k);
						}
					}
				} while (temp==null);
				k = 0;
				do {
					tempOrder = dsMuaHang.searchBills();
					if(tempOrder==null) {
						System.out.println("Không tìm thấy đơn hàng! Mời chọn:");
						System.out.println("1.Nhập lại mã đơn hàng|2.Thêm đơn hàng");
						switch (k) {
						case 1: {
							break;
						}
						case 2: {
							dsMuaHang.addBills();
						}
						default:
							throw new IllegalArgumentException("Giá trị không hợp lệ: " + k);
						}
					}
				} while (tempOrder==null);
				Payment payment = new Cash();
				payment.setMoneyammount(tempOrder.calcTotal()-temp.getDiscount()*tempOrder.calcTotal());
				payment.input();
				payment.output();
				break;
			}
			case 6:
				break;
			default:
				System.out.println("Nhập sai! Nhập lại");
			}
		} while (key != 6);
		System.out.println("Cảm ơn bạn đã sử dụng!");
	}
}