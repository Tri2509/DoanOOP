package App;

import java.util.Scanner;
import Staff.*;

@SuppressWarnings("resource")
public class QuanLyNhanVien {
	private Manager manager = new Manager("secret");
	private static int n = 0;
	private Staff[] staffs = new Staff[99];

	public void edit() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập password:");
		String tempString = scanner.nextLine();
		if (!tempString.equals(manager.getPassword())) {
			System.out.println("Sai password!");
			return;
		}
		int choice;
		do {
			System.out.println("(------------------Danh sách chức năng------------------------)");
			System.out.println("1.Thêm nhân viên");
			System.out.println("2.Xóa nhân viên");
			System.out.println("3.Chỉnh sửa nhân viên");
			System.out.println("4.Tìm kiếm nhân viên");
			System.out.println("5.Danh sách nhân viên");
			System.out.println("6.Thoát");
			System.out.println("Mời bạn chọn chức năng:");
			choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				staffs = addStaff();
				break;
			}
			case 2: {
				staffs = deleteStaff();
				break;
			}
			case 3: {
				editStaff();
				break;
			}
			case 4: {
				searchStaff();
				break;
			}
			case 5: {
				stafflist(staffs);
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

	private Staff[] addStaff() {
		Staff newArr[] = new Staff[n + 1];
		int k;
		for (int i = 0; i < n; i++)
			newArr[i] = staffs[i];
		do {
			System.out.println("Chọn nghề nghiệp: 1.Phục vụ 2.Thu ngân 3.Đầu bếp");
			k = Integer.parseInt(new Scanner(System.in).nextLine());
			switch (k) {
			case 1:
				newArr[n] = new Waiter();
				newArr[n].input();
				for (int i = 0; i < n; i++) {
					if (newArr[n].getStaffID() == staffs[i].getStaffID()) {
						System.out.println("Trùng mã nhân viên: " + staffs[i].getStaffID());
						return staffs;
					}
				}
				newArr[n].jobDescription();
				n++;
				return newArr;
			case 2:
				newArr[n] = new Cashier();
				newArr[n].input();
				for (int i = 0; i < n; i++) {
					if (newArr[n].getStaffID() == staffs[i].getStaffID()) {
						System.out.println("Trùng mã nhân viên: " + staffs[i].getStaffID());
						return staffs;
					}
				}
				newArr[n].jobDescription();
				n++;
				return newArr;
			case 3:
				newArr[n] = new Chef();
				newArr[n].input();
				for (int i = 0; i < n; i++) {
					if (newArr[n].getStaffID() == staffs[i].getStaffID()) {
						System.out.println("Trùng mã nhân viên: " + staffs[i].getStaffID());
						return staffs;
					}
				}
				newArr[n].jobDescription();
				n++;
				return newArr;
			default:
				throw new IllegalArgumentException("Nhập sai! Nhập lại");
			}
		} while (true);
	}

	private Staff[] deleteStaff() {
		stafflist(staffs);
		System.out.println("Nhập mã nhân viên cần xóa: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (staffs[i].getStaffID() == temp)
				j = i;
		if (staffs == null || j == -1) {
			System.out.println("Không có phần tử để xóa");
			return staffs;
		}
		Staff[] newArr = new Staff[n - 1];
		for (int i = 0, k = 0; i < n; i++) {
			if (i == j)
				continue;
			newArr[k++] = staffs[i];
		}
		n--;
		return newArr;
	}

	private void editStaff() {
		stafflist(staffs);
		System.out.println("Nhập mã nhân viên cần sửa: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (staffs[i].getStaffID() == temp)
				j = i;
		if (j == -1)
			System.out.println("Không tìm thấy nhân viên");
		else {
			staffs[j].input();
			}	
	}

	private void searchStaff() {
		System.out.println("Nhập mã nhân viên cần tìm: ");
		int temp = Integer.parseInt(new Scanner(System.in).nextLine());
		int j = -1;
		for (int i = 0; i < n; i++)
			if (staffs[i].getStaffID() == temp)
				j = i;
		if (j == -1)
			System.out.println("Không tìm thấy nhân viên");
		else {
			staffs[j].output();
			staffs[j].jobDescription();
		}
	}

	private void stafflist(Staff[] s) {
		System.out.println("-------Danh sách nhân viên------");
		for (int i = 0; i < s.length; i++) {
			System.out.println((i + 1) + ".");
			s[i].output();
		}
	}
}