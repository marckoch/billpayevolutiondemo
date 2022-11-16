package com.extensiblejava.bill;

import com.extensiblejava.audit.AuditException;
import com.extensiblejava.audit.AuditFacade;
import com.extensiblejava.audit.Auditable;
import com.extensiblejava.bill.data.BillDataBean;
import com.extensiblejava.bill.data.BillDb;
import com.extensiblejava.financial.Payable;
import com.extensiblejava.financial.Payment;

import java.math.BigDecimal;

public class Bill implements Payable, Auditable {

	private final BillDataBean billData;

	public static Bill loadBill(BillEntityLoader loader) {
		return loader.loadBill();
	}
	public Bill(BillDataBean billData) {
		this.billData = billData;
	}

	public String getBillId() {	return this.billData.getBillId().toString(); }
	public String getName() { return this.billData.getName(); }
	@Override
	public BigDecimal getAmount() { return this.billData.getAmount(); }
	@Override
	public BigDecimal getAuditedAmount() { return (this.billData.getAuditedAmount() == null ? null : this.billData.getAuditedAmount()); }
	public BigDecimal getPaidAmount() { return this.billData.getPaidAmount(); }
	public String getStatus() {
		if (this.billData.getPaidAmount() != null) {
			return "PAID";
		} else if (this.billData.getAuditedAmount() != null) {
			return "AUDITED";
		} else {
			return "NEW";
		}
	}

	public void audit(AuditFacade auditor) throws AuditException {
		this.billData.setAuditedAmount(auditor.audit(this));
		this.persist();
	}

	public void pay() {
		if (this.billData.getPaidAmount() == null) {
			Payment payer = new Payment();
			this.billData.setPaidAmount(payer.generateDraft(this));
			this.persist();
		}
	}

	private void persist() {
		BillDb.update(billData);
	}
}