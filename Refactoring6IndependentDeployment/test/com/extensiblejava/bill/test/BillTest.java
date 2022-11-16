package com.extensiblejava.bill.test;

import com.extensiblejava.audit.AuditException;
import com.extensiblejava.audit.audit1.AuditFacade1;
import com.extensiblejava.audit.audit2.AuditFacade2;
import com.extensiblejava.bill.Bill;
import com.extensiblejava.bill.BillEntityLoader;
import com.extensiblejava.bill.BillPayer;
import com.extensiblejava.bill.Customer;
import com.extensiblejava.bill.DefaultCustomerEntityLoader;
import com.extensiblejava.bill.data.BillDataBean;
import junit.framework.TestCase;

import java.math.BigDecimal;

public class BillTest extends TestCase {

    final BillDataBean billDataBean1 = new BillDataBean(1, 1, "ONE", new BigDecimal("25.00"), null, null);

    final BillEntityLoader loaderForBillDataBean1 = () -> new Bill(billDataBean1);

    private static class BillPayerTestImpl implements BillPayer {
        private final Bill bill;
        public BillPayerTestImpl(Bill bill) {
            this.bill = bill;
        }

        public BigDecimal generateDraft(Bill bill) {
            return bill.getAmount();
        }

        public BigDecimal getAmount() {
            return this.bill.getAmount();
        }

        public BigDecimal getAuditedAmount() {
            return this.bill.getAuditedAmount();
        }
    };

    public void testCustomerLoader() {
        Customer cust = Customer.loadCustomer(new DefaultCustomerEntityLoader(1));
        assertNotNull(cust.getName());

        for (Bill bill : cust.getBills()) {
            assertNotNull(bill);
        }
    }

    public void testBillLoader() {
        Bill bill = Bill.loadBill(loaderForBillDataBean1);

        assertNotNull(bill);
    }

    public void testAudit1() throws AuditException {
        Bill bill = Bill.loadBill(loaderForBillDataBean1);
        bill.audit(new AuditFacade1());
        BigDecimal auditedAmount = bill.getAuditedAmount();

        assertEquals(new BigDecimal("18.75"), auditedAmount);
    }

    public void testAudit2() throws AuditException {
        Bill bill = Bill.loadBill(loaderForBillDataBean1);
        bill.audit(new AuditFacade2());
        BigDecimal auditedAmount = bill.getAuditedAmount();

        assertEquals(new BigDecimal("21.25"), auditedAmount);
    }

    //Here, I'm no longer testing the financial piece. That's done in the financial test cases. Instead,
    //I'm only testing the pay logic associated with Bill. This is evident when looking at BillPayerTest
    //above, since the generateDraft is degenerate.
    public void testPay() {
        Bill bill = Bill.loadBill(loaderForBillDataBean1);

        BillPayerTestImpl payer = new BillPayerTestImpl(bill);
        bill.pay(payer);

        assertEquals(bill.getPaidAmount(), bill.getAmount());
    }

    public void testAudit1AfterPay() throws AuditException {
        Bill bill = Bill.loadBill(loaderForBillDataBean1);

        BillPayerTestImpl payer = new BillPayerTestImpl(bill);
        bill.pay(payer);

        BigDecimal paidAmount = bill.getPaidAmount();
        bill.audit(new AuditFacade1());
        BigDecimal paidAmountAfter = bill.getPaidAmount();

        assertEquals(paidAmount, paidAmountAfter);
    }
}
