package com.extensiblejava.bill.test;

import com.extensiblejava.bill.Bill;
import com.extensiblejava.bill.BillEntityLoader;
import com.extensiblejava.bill.Customer;
import com.extensiblejava.bill.DefaultCustomerEntityLoader;
import com.extensiblejava.bill.data.BillDataBean;
import junit.framework.TestCase;

import java.math.BigDecimal;

public class BillTest extends TestCase
{
	public static void main(String[] args)
	{
		String[] testCaseName = { BillTest.class.getName() };

		junit.textui.TestRunner.main(testCaseName);
	}

	protected void setUp() {

	}

	static class DummyLoader implements BillEntityLoader {
		public Bill loadBill() {
			return new Bill(new BillDataBean(1, 1, "ONE", new BigDecimal("25.00"), null, null));
		}
	}

	public void testCustomerLoader() {
		Customer cust = Customer.loadCustomer(new DefaultCustomerEntityLoader(1));
		assertNotNull(cust.getName());

		for (Bill bill : cust.getBills()) {
			assertNotNull(bill);
		}
	}

	public void testBillLoader() {
		Bill bill = Bill.loadBill(new DummyLoader());
		assertNotNull(bill);
	}

	public void testAudit() {
		Bill bill = Bill.loadBill(new DummyLoader());
		bill.audit();
		BigDecimal auditedAmount = bill.getAuditedAmount();
		assertEquals(new BigDecimal("18.75"),auditedAmount);
	}

	public void testPay() {
		Bill bill = Bill.loadBill(new DummyLoader());
		bill.pay();
		assertEquals(bill.getPaidAmount(), bill.getAmount());
	}

	public void testAuditAfterPay() {
		Bill bill = Bill.loadBill(new DummyLoader());
		bill.pay();
		BigDecimal paidAmount = bill.getPaidAmount();
		bill.audit();
		BigDecimal paidAmountAfter = bill.getPaidAmount();
		assertEquals(paidAmount, paidAmountAfter);
	}
}
