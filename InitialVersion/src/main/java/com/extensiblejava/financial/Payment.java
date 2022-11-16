package com.extensiblejava.financial;

import com.extensiblejava.bill.Bill;

import java.math.BigDecimal;

public class Payment {
	public BigDecimal generateDraft(Bill bill) {
		if (bill.getAuditedAmount() == null) {
			return bill.getAmount();
		} else {
			return bill.getAuditedAmount();
		}
	}
}