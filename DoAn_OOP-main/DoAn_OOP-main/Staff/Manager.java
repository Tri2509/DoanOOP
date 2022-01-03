package Staff;

public class Manager extends Staff {
	private String password;

	public Manager() {
		super();
		jobType = "Manager";
	}
	
	public Manager(String password) {
		super();
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void jobDescription() {
		System.out.println("Quản lý nhân viên");
	}
}
