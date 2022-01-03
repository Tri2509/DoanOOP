package Customer;

public class VIPCustomer extends Customer{
	public VIPCustomer() {
		super();
		customerType = "VIP";
		discount = 0.3;
	}
	@Override
	public String toString() {
		return super.toString()+"|Khách hàng VIP";
	}
	
	@Override
	public void output() {
		System.out.println(toString());
	}
}