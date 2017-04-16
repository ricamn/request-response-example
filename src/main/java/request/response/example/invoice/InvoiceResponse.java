package request.response.example.invoice;

import request.response.example.ResponseData;
import request.response.example.Status;

public class InvoiceResponse implements ResponseData {

	private Status status;

	private InvoiceDeatils invoiceDeatils;

	public InvoiceResponse(InvoiceDeatils invoiceDetails, Status status) {
		this.status = status;
		this.invoiceDeatils = invoiceDetails;
	}

	public Status getStatus() {
		return status;
	}

	public InvoiceDeatils getInvoiceDeatils() {
		return invoiceDeatils;
	}

}
