package com.extensiblejava.mediator;

import com.extensiblejava.bill.Bill;
import com.extensiblejava.bill.BillPayer;
import com.extensiblejava.financial.Payable;
import com.extensiblejava.financial.Payment;

import java.math.BigDecimal;

//Escalate the dependency upon financial to BillPayerAdapter.
public class BillPayerAdapter implements BillPayer, Payable {
	private final Bill bill;
	public BillPayerAdapter(Bill bill) {
		this.bill = bill;
	}

	@Override
	public BigDecimal generateDraft(Bill bill) {
		Payment payer = new Payment();
		return payer.generateDraft(this);
	}

	@Override
	public BigDecimal getAmount() {
		return this.bill.getAmount();
	}

	@Override
	public BigDecimal getAuditedAmount() {
		return this.bill.getAuditedAmount();
	}
}