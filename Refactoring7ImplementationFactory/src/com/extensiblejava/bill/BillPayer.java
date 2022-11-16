package com.extensiblejava.bill;

import java.math.BigDecimal;

public interface BillPayer {
	BigDecimal generateDraft(Bill bill);
}