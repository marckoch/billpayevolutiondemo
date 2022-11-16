package com.extensiblejava.ui;

import com.extensiblejava.bill.Bill;
import com.extensiblejava.bill.Customer;

import java.util.List;

public class CustomerSearchResultsBean {
	private final String name;
	private final List<Bill> bills;
	public CustomerSearchResultsBean(Customer customer) {
		this.name = customer.getName().getFullName();
		this.bills = customer.getBills();
	}

	public String getName() { return this.name; }
	public List<Bill> getBills() { return this.bills; }
}