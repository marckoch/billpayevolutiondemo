package com.extensiblejava.bill;

import com.extensiblejava.bill.data.BillDb;
import com.extensiblejava.bill.data.CustomerDataBean;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultCustomerEntityLoader implements CustomerEntityLoader {
	private final Integer custId;

	public DefaultCustomerEntityLoader(Integer custId) {
		this.custId = custId;
	}
	public Customer loadCustomer() {
		CustomerDataBean customer = BillDb.getCustomer(custId);
		return new Customer(this.custId, new Name(customer.getFirstName(), customer.getLastName()), this);
	}

	public List<Bill> loadBills() {
		return BillDb.getBills(this.custId)
				.stream()
				.map(Bill::new)
				.collect(Collectors.toList());
	}
}