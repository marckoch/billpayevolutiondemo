package com.extensiblejava.bill;

import java.util.List;

public class Customer {
	private final CustomerEntityLoader loader;
	private final Integer custId;
	private final Name name;
	private List<Bill> bills;

	public static Customer loadCustomer(CustomerEntityLoader loader) {
		return loader.loadCustomer();
	}

	public Customer(Integer custId, Name name, CustomerEntityLoader loader) {
		this.custId = custId;
		this.name = name;
		this.loader = loader;
	}

	public List<Bill> getBills() {
		if (this.bills == null) {
			this.bills = loader.loadBills();
		}
		return this.bills;
	}

	public Name getName() { return this.name; }
}