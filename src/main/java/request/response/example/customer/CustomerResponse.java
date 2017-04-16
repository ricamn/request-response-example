package request.response.example.customer;

import request.response.example.ResponseData;
import request.response.example.Status;

public class CustomerResponse implements ResponseData {

	private Customer customer;
	private Status status;

	public CustomerResponse(Customer customer, Status status) {
		this.customer = customer;
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Status getStatus() {
		return status;
	}

}
