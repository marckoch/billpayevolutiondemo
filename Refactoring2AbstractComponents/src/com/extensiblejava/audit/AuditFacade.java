package com.extensiblejava.audit;

import com.extensiblejava.bill.Bill;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface AuditFacade {
	public BigDecimal audit(Bill bill);
}