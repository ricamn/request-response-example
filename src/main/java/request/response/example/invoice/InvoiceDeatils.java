package request.response.example.invoice;

public class InvoiceDeatils {

	public InvoiceDeatils(long number, double value) {
		this.number = number;
		this.value = value;
	}

	private long number;

	private double value;

	public long getNumber() {
		return number;
	}

	public double getValue() {
		return value;
	}

}
