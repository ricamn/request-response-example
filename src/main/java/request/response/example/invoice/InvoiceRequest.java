package request.response.example.invoice;

import request.response.example.RequestData;

public class InvoiceRequest implements RequestData<InvoiceResponse> {

	private long incoiceNumber;

	public InvoiceRequest(long invoiceNumber) {
		this.incoiceNumber = invoiceNumber;
	}

	public long getIncoiceNumber() {
		return incoiceNumber;
	}

}
