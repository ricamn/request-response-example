package request.response.example.customer.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import request.response.example.customer.Customer;
import request.response.example.customer.CustomerRequest;
import request.response.example.customer.CustomerRequestHandler;
import request.response.example.customer.CustomerResponse;
import request.response.example.customer.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {

	private final Logger log = LoggerFactory.getLogger(CustomerTest.class);

	@Mock
	private CustomerService customerService;

	@InjectMocks
	private CustomerRequestHandler handler;

	@Test
	public void ShouldFindTheCustomerWhenTheCustomerIdIsFound() {

		CustomerRequest customerRequest = new CustomerRequest(100L);
		when(customerService.searchCustomer(anyLong())).thenReturn(new Customer(100L, "Customer Name"));
		CustomerResponse customerResponse = handler.processRequest(customerRequest);

		assertNotNull(customerResponse);
		assertEquals(100L, customerResponse.getCustomer().getCustomerId());
		log.info("Customer Id: {}", customerResponse.getCustomer().getCustomerId());
		assertEquals("Customer Name", customerResponse.getCustomer().getCustomerName());
		log.info("Customer Name: {}", customerResponse.getCustomer().getCustomerName());
	}
}
