package request.response.example.invoice.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import request.response.example.Status;
import request.response.example.invoice.InvoiceDeatils;
import request.response.example.invoice.InvoiceRequest;
import request.response.example.invoice.InvoiceRequestHandler;
import request.response.example.invoice.InvoiceResponse;
import request.response.example.invoice.service.InvoiceService;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceTest {

	@Mock
	private InvoiceService invoiceService;

	@InjectMocks
	private InvoiceRequestHandler handler;

	@Test
	public void ShouldReturnnInvoiceDetailWhenTheInvoiceIsFound() {

		InvoiceDeatils invoiceDeatils = new InvoiceDeatils(200L, 300.00);
		when(invoiceService.searchInvoiceByNumber(anyLong())).thenReturn(invoiceDeatils);
		InvoiceRequest request = new InvoiceRequest(200L);
		InvoiceResponse response = handler.processRequest(request);

		assertEquals(Status.SUCCESS, response.getStatus());
		assertNotNull(response.getInvoiceDeatils());
		assertEquals(200L, response.getInvoiceDeatils().getNumber());
		assertEquals(300.0, response.getInvoiceDeatils().getValue(), 0);
	}

	@Test
	public void ShouldFailWhenInvoiceServiceThrowAnException() {
		when(invoiceService.searchInvoiceByNumber(200L)).thenThrow(new RuntimeException());
		InvoiceRequest request = new InvoiceRequest(200L);
		InvoiceResponse response = handler.processRequest(request);

		assertEquals(Status.FAIL, response.getStatus());
		assertEquals(null, response.getInvoiceDeatils());
	}
}
