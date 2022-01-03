package Customer;

public class NormalCustomer extends Customer{	
	public NormalCustomer() {
		super();
		customerType = "Normal";
		discount = 0.1;
	}
	
	@Override
	public String toString() {
		return super.toString()+"|Khách hàng thường";
	}
	
	@Override
	public void output() {
		System.out.println(toString());
	}
}