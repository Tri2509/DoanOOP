package Payment;

public abstract class Payment {
	protected double moneyammount;
	protected String paymentType;
	
	public Payment() {
		
	}

	public Payment(float moneyammount,String paymentType) {

		this.paymentType = paymentType;
	}

	public double getMoneyammount() {
		return moneyammount;
	}

	public void setMoneyammount(double moneyammount) {	
		this.moneyammount = moneyammount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public abstract double authorized();
	
	public abstract void output();

	public abstract void input();
}