package com.extensiblejava.mediator.test;

import com.extensiblejava.audit.AuditFacade;
import com.extensiblejava.audit.audit1.AuditFacade1;
import com.extensiblejava.mediator.AuditFacadeFactory;
import junit.framework.TestCase;

public class AuditFacadeFactoryTest extends TestCase {
	//Test the complete payment piece with BillPayerAdapter.
	public void testAuditFacadeFactory() {
		AuditFacade auditor = AuditFacadeFactory.getAuditFacade();
		assertTrue(auditor instanceof AuditFacade1);
	}
}
