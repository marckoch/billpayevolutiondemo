package com.extensiblejava.audit1.test;

import com.extensiblejava.audit.AuditException;
import com.extensiblejava.audit.audit1.AuditFacade1;
import junit.framework.TestCase;

import java.math.BigDecimal;

public class AuditFacade1Test extends TestCase {
    public void testAudit() throws AuditException {
        AuditFacade1 a1 = new AuditFacade1();
        BigDecimal amount = a1.audit(() -> new BigDecimal("100.00"));

        assertEquals(amount, new BigDecimal("75.00"));
    }
}
