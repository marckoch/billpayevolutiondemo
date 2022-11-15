package com.extensiblejava.bill.test;

import com.extensiblejava.audit.AuditFacade1;
import com.extensiblejava.bill.Bill;
import com.extensiblejava.bill.BillEntityLoader;
import com.extensiblejava.bill.Customer;
import com.extensiblejava.bill.DefaultCustomerEntityLoader;
import com.extensiblejava.bill.data.BillDataBean;
import junit.framework.TestCase;

import java.math.BigDecimal;

public class BillTest extends TestCase {

    final BillDataBean billDataBean1 = new BillDataBean(1, 1, "ONE", new BigDecimal("25.00"), null, null);

    final BillEntityLoader loaderForBillDataBean1 = () -> new Bill(billDataBean1);

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

    public void testAudit() {
        Bill bill = Bill.loadBill(loaderForBillDataBean1);
        bill.audit(new AuditFacade1());
        BigDecimal auditedAmount = bill.getAuditedAmount();

        assertEquals(new BigDecimal("18.75"), auditedAmount);
    }

    public void testPay() {
        Bill bill = Bill.loadBill(loaderForBillDataBean1);
        bill.pay();

        assertEquals(bill.getPaidAmount(), bill.getAmount());
    }

    public void testAuditAfterPay() {
        Bill bill = Bill.loadBill(loaderForBillDataBean1);
        bill.pay();
        BigDecimal paidAmount = bill.getPaidAmount();
        bill.audit(new AuditFacade1());
        BigDecimal paidAmountAfter = bill.getPaidAmount();

        assertEquals(paidAmount, paidAmountAfter);
    }
}
