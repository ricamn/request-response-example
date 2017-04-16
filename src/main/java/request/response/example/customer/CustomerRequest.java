package request.response.example.customer;

import request.response.example.RequestData;

public class CustomerRequest implements RequestData<CustomerResponse> {

	private long customerId;

	public CustomerRequest(long customerId) {
		this.customerId = customerId;
	}

	public long getCustomerId() {
		return customerId;
	}

}
