package com.extensiblejava.audit.audit2;

import com.extensiblejava.audit.AuditFacade;
import com.extensiblejava.audit.Auditable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AuditFacade2 implements AuditFacade {
    public BigDecimal audit(Auditable auditable) {
        BigDecimal amount = auditable.getAmount();
        BigDecimal auditedAmount = amount.multiply(new BigDecimal("0.85"));
        return auditedAmount.setScale(2, RoundingMode.UNNECESSARY);
    }
}