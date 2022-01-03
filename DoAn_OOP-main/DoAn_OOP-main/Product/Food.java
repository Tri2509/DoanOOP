package Product;

import java.util.Scanner;

public class Food extends Product {	
	private String foodDescription;
	public Food() {
		super();
		productType="Food";
	}

	public Food(String foodName, int foodPrice, String foodDescription) {
		super();
		this.foodDescription = foodDescription;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}
	
	@SuppressWarnings("resource")
	@Override
	public void input() {
		super.input();
		System.out.println("Nhập miêu tả món ăn: ");
		foodDescription=new Scanner(System.in).nextLine();
	}
	
	@Override
	public String toString() {
		return super.toString()+"|Miêu tả: "+foodDescription;
	}
	
	public void output() {
		System.out.println(toString());
	}
}