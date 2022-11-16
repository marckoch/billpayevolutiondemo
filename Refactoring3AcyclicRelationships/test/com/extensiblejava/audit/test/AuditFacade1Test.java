package com.extensiblejava.audit.test;

import com.extensiblejava.audit.AuditFacade1;
import com.extensiblejava.audit.Auditable;
import junit.framework.TestCase;

import java.math.BigDecimal;

public class AuditFacade1Test extends TestCase {
    public void testAudit() {
        AuditFacade1 a1 = new AuditFacade1();
        BigDecimal amount = a1.audit(() -> new BigDecimal("100.00"));

        assertEquals(amount, new BigDecimal("75.00"));
    }
}
