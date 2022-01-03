package Staff;

public class Waiter extends Staff{
	public Waiter() {
		super();
		jobType="Waiter";
	}
	@Override
	public String toString() {
		return super.toString()+"|Công việc: Phục vụ";
	}
	@Override
	public void output() {
		System.out.println(toString());
	}
	@Override
	public void jobDescription() {
		System.out.println("Nhiệm vụ: Phục vụ thức ăn, nước uống cho khách hàng");
	}
}
