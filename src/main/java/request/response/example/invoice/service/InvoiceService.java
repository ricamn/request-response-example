package request.response.example.invoice.service;

import request.response.example.invoice.InvoiceDeatils;

public interface InvoiceService {

	InvoiceDeatils searchInvoiceByNumber(long invoiceNumber);
}
