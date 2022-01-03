package Product;

import java.util.Scanner;

public class Drink extends Product {
	private String drinkType;
	public Drink() {
		super();
		productType="Drink";
	}
	
	public Drink(String drinkType) {
		super();
		this.drinkType = drinkType;
	}

	public String getdrinkType() {
		return drinkType;
	}

	public void setdrinkType(String drinkType) {
		this.drinkType = drinkType;
	}

	@SuppressWarnings("resource")
	@Override
	public void input() {
		super.input();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập loại đồ uống: ");
		drinkType=scanner.nextLine();
	}
	
	@Override
	public String toString() {
		return super.toString()+"|Loại đồ uống: "+drinkType;
	}
	
	public void output() {
		System.out.println(toString());
	}
}
