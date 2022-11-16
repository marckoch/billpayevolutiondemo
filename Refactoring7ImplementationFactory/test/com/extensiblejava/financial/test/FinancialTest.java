package com.extensiblejava.financial.test;

import com.extensiblejava.financial.Payable;
import com.extensiblejava.financial.Payment;
import junit.framework.TestCase;

import java.math.BigDecimal;

public class FinancialTest extends TestCase {

    public void testPayment() {
        Payment payment = new Payment();
        BigDecimal paidAmount = payment.generateDraft(new Payable() {
            public BigDecimal getAuditedAmount() {
                return null;
            }

            public BigDecimal getAmount() {
                return new BigDecimal("100.00");
            }
        });

        assertEquals(paidAmount, new BigDecimal("100.00"));
    }
}
