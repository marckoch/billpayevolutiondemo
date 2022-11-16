package com.extensiblejava.financial;

import java.math.BigDecimal;

public interface Payable {
    BigDecimal getAmount();
    BigDecimal getAuditedAmount();
}