package Staff;

public class Cashier extends Staff{
	public Cashier() {
		super();
		jobType="Cashier";
	}
	@Override
	public String toString() {
		return super.toString()+"|Công việc: Thu ngân";
	}
	@Override
	public void output() {
		System.out.println(toString());
	}
	@Override
	public void jobDescription() {
		System.out.println("Nhiệm vụ: Giao dịch tiền với khách hàng");
	}
}