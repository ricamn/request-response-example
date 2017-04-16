package request.response.example.customer;

import request.response.example.RequestHandler;
import request.response.example.Status;
import request.response.example.customer.service.CustomerService;

public class CustomerRequestHandler implements RequestHandler<CustomerRequest, CustomerResponse> {

	private CustomerService customerService;

	public CustomerRequestHandler(CustomerService customerService) {
		this.customerService = customerService;
	}

	public CustomerResponse processRequest(CustomerRequest request) {
		Customer customer = null;
		CustomerResponse response = null;
		try {
			customer = customerService.searchCustomer(request.getCustomerId());
			response = new CustomerResponse(customer, Status.SUCCESS);
		} catch (Exception e) {
			response = new CustomerResponse(customer, Status.FAIL);
		}
		return response;
	}

}
