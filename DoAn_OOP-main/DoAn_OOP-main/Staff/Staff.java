package Staff;

import java.util.Scanner;

public abstract class Staff {
	protected String staffName;
	protected int staffID;
	protected String jobType;

	public Staff() {

	}

	public Staff(String staffName, int staffID, String jobType) {
		this.staffName = staffName;
		this.staffID = staffID;
		this.jobType = jobType;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public abstract void jobDescription();

	@SuppressWarnings("resource")
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ten nhan vien: ");
		staffName = scanner.nextLine();
		System.out.println("Nhap ma nhan vien: ");
		staffID = Integer.parseInt(scanner.nextLine());
	}

	@Override
	public String toString() {
		return "Ten nhan vien: " + staffName + "|Ma nhan vien: " + staffID;
	}

	public void output() {
		System.out.println(toString());
	}
}
