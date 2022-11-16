package com.extensiblejava.audit.audit1;

import com.extensiblejava.audit.AuditException;
import com.extensiblejava.audit.AuditFacade;
import com.extensiblejava.audit.Auditable;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AuditFacade1 implements AuditFacade {
    @Override
    public BigDecimal audit(Auditable auditable) throws AuditException {
        BigDecimal amount = auditable.getAmount();
        BigDecimal auditedAmount = amount.multiply(new BigDecimal("0.75"));
        return auditedAmount.setScale(2, RoundingMode.UNNECESSARY);
    }
}