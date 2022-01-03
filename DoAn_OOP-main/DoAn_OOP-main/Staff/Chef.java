package Staff;

public class Chef extends Staff{
	public Chef() {
		super();
		jobType="Chef";
	}
	@Override
	public String toString() {
		return super.toString()+"|Công việc: Đầu bếp";
	}
	@Override
	public void output() {
		System.out.println(toString());
	}
	@Override
	public void jobDescription() {
		System.out.println("Nhiệm vụ: Nấu ăn cho khách hàng");
	}
}
