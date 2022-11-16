package com.extensiblejava.audit2.test;

import com.extensiblejava.audit.audit2.AuditFacade2;
import junit.framework.TestCase;

import java.math.BigDecimal;

public class AuditFacade2Test extends TestCase {
    public void testAudit() {
        AuditFacade2 a1 = new AuditFacade2();
        BigDecimal amount = a1.audit(() -> new BigDecimal("100.00"));

        assertEquals(amount, new BigDecimal("85.00"));
    }
}
