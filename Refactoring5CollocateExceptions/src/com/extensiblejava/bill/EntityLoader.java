package com.extensiblejava.bill;

import java.util.List;

public interface EntityLoader {
	Customer loadCustomer();
	List<Bill> loadBills();
}