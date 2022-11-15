package com.extensiblejava.bill;

import java.util.List;

public interface CustomerEntityLoader {
	Customer loadCustomer();
	List<Bill> loadBills();
}