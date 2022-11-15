package com.extensiblejava.bill;

import com.extensiblejava.bill.data.BillDataBean;
import com.extensiblejava.bill.data.BillDb;

public class DefaultBillEntityLoader implements BillEntityLoader {

	private final Integer billId;

	public DefaultBillEntityLoader(Integer billId) {
		this.billId = billId;
	}

	public Bill loadBill() {
		BillDataBean billBean = BillDb.getBill(this.billId);
		return new Bill(billBean);
	}
}