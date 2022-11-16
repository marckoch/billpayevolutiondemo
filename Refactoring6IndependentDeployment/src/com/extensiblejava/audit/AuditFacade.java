package com.extensiblejava.audit;

import java.math.BigDecimal;

public interface AuditFacade {
	BigDecimal audit(Auditable auditable) throws AuditException;
}