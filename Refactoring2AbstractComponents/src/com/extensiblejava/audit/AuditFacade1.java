package com.extensiblejava.audit;

import com.extensiblejava.bill.Bill;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AuditFacade1 implements AuditFacade {
    public BigDecimal audit(Bill bill) {
        BigDecimal amount = bill.getAmount();
        BigDecimal auditedAmount = amount.multiply(new BigDecimal("0.75"));
        return auditedAmount.setScale(2, RoundingMode.UNNECESSARY);
    }
}