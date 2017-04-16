package request.response.example.invoice;

import request.response.example.RequestHandler;
import request.response.example.Status;
import request.response.example.invoice.service.InvoiceService;

public class InvoiceRequestHandler implements RequestHandler<InvoiceRequest, InvoiceResponse> {

	private InvoiceService invoiceService;

	public InvoiceResponse processRequest(InvoiceRequest request) {
		InvoiceDeatils invoiceDeatils = null;
		InvoiceResponse response = null;

		try {

			invoiceDeatils = invoiceService.searchInvoiceByNumber(request.getIncoiceNumber());
			response = new InvoiceResponse(invoiceDeatils, Status.SUCCESS);

		} catch (Exception e) {

			response = new InvoiceResponse(invoiceDeatils, Status.FAIL);

		}

		return response;
	}

}
