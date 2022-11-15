package com.extensiblejava.bill.test;

import com.extensiblejava.bill.data.BillDataBean;
import com.extensiblejava.bill.data.BillDb;
import com.extensiblejava.bill.data.CustomerDataBean;
import junit.framework.TestCase;

import java.util.Iterator;

public class BillDbTest extends TestCase {
    public void testCustomerLoad() {
        CustomerDataBean cust = BillDb.getCustomer(1);
        assertEquals(cust.getId(), new Integer(1));
    }

    public void testBillsLoad() {
        Iterator<BillDataBean> billBeans = BillDb.getBills(1).iterator();

        int i = 1;
        while (billBeans.hasNext()) {
            BillDataBean billBean = billBeans.next();
            assertEquals(billBean.getBillId(), new Integer(i));
            i++;
        }
    }
}
