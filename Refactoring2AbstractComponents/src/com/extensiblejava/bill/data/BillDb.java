package com.extensiblejava.bill.data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.TreeMap;

public class BillDb {

	private static final CustomerDataBean custBean;
	private static final TreeMap<Integer, BillDataBean> billBeans;

	static {
		custBean = new CustomerDataBean(1, "Sue", "Smith");

		BillDataBean billBean1 = new BillDataBean(1, 1, "ONE", new BigDecimal("25.00"), null, null);
		BillDataBean billBean2 = new BillDataBean(2, 1, "TWO", new BigDecimal("50.00"), null, null);
		BillDataBean billBean3 = new BillDataBean(3, 1, "THREE", new BigDecimal("75.00"), null, null);
		BillDataBean billBean4 = new BillDataBean(4, 1, "FOUR", new BigDecimal("100.00"), null, null);
		BillDataBean billBean5 = new BillDataBean(5, 1, "FIVE", new BigDecimal("1000.00"), null, null);

		billBeans = new TreeMap<>();
		billBeans.put(billBean1.getBillId(), billBean1);
		billBeans.put(billBean2.getBillId(), billBean2);
		billBeans.put(billBean3.getBillId(), billBean3);
		billBeans.put(billBean4.getBillId(), billBean4);
		billBeans.put(billBean5.getBillId(), billBean5);
	}

	public static CustomerDataBean getCustomer(Integer custId) {
		return custBean;
	}

	public static Collection<BillDataBean> getBills(Integer custId) {
		return billBeans.values();
	}

	public static BillDataBean getBill(Integer billId) {
		return billBeans.get(billId);
	}

	public static void update(BillDataBean bean) {
		billBeans.put(bean.getBillId(), bean);
	}

}