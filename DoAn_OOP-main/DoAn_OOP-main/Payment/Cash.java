package Payment;

import java.util.Scanner;

public class Cash extends Payment{
	private float cash;
	
	public Cash() {
		super();
		paymentType="Tiền mặt";
	}

	public Cash(float cash) {
		super();
		this.cash = cash;
	}

	public float getCash() {
		return cash;
	}

	public void setCash(float cash) {
		this.cash = cash;
	}

	@SuppressWarnings("resource")
	public void input() {
		System.out.println("Đưa số tiền mặt: ");
		cash=Float.parseFloat(new Scanner(System.in).nextLine());
	}
	
	@Override
	public double authorized() {
		return cash-getMoneyammount();
	}
	
	@Override
	public String toString() {
		return "Nhận số tiền: "+cash+"Tiền dư: "+authorized();
	}
	
	@Override
	public void output() {
		if (authorized() < 0)
			System.out.println("Không đủ tiền");
		else
			System.out.println(toString());
	}
}