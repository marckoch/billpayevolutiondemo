package com.extensiblejava.mediator.test;

import com.extensiblejava.bill.Bill;
import com.extensiblejava.bill.BillEntityLoader;
import com.extensiblejava.bill.data.BillDataBean;
import com.extensiblejava.mediator.BillPayerAdapter;
import junit.framework.TestCase;

import java.math.BigDecimal;

public class BillPayerAdapterTest extends TestCase {

    //Test the complete payment piece with BillPayerAdapter.
    public void testPay() {

        Bill bill = Bill.loadBill(new BillEntityLoader() {
            public Bill loadBill() {
                return new Bill(new BillDataBean(1, 1, "ONE", new BigDecimal("25.00"), null, null));
            }
        });
        BillPayerAdapter payer = new BillPayerAdapter(bill);
        bill.pay(payer);
        assertEquals(bill.getPaidAmount(), bill.getAmount());
    }
}
