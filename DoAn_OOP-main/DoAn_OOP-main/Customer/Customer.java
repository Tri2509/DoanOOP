package Customer;

import java.util.Scanner;

public class Customer {
	protected String name;
	protected int customerID;
	protected int age;
	protected int phonenumber;
	protected String customerType;
	protected double discount = 0;

	public Customer() {

	}

	public Customer(String name, int customerID, int age, int phonenumber, String customerType, double discount) {
		this.name = name;
		this.customerID = customerID;
		this.age = age;
		this.phonenumber = phonenumber;
		this.customerType = customerType;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@SuppressWarnings("resource")
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập tên khách hàng: ");
		name = scanner.nextLine();
		System.out.println("Nhập mã khách hàng: ");
		customerID = Integer.parseInt(scanner.nextLine());
		System.out.println("Nhập tuổi khách hàng: ");
		age = Integer.parseInt(scanner.nextLine());
		System.out.println("Nhập số điện thoại: ");
		phonenumber = Integer.parseInt(scanner.nextLine());
	}

	@Override
	public String toString() {
		return "Tên khách hàng: " + name + "|Mã khách hàng: " + customerID + "|Tuổi: " + age + "|SĐT: " + phonenumber;
	}

	public void output() {
		System.out.println(toString());
	}
}