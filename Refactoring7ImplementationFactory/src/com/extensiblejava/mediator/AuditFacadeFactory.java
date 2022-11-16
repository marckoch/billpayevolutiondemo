package com.extensiblejava.mediator;

import com.extensiblejava.audit.AuditFacade;
import com.extensiblejava.audit.audit1.AuditFacade1;

//If I put this class in the same component as Bill, I've logically decoupled Bill from
//AuditFacade implementations, but have not physically decoupled them. If I put it in the UI
//I limit ability to use it in batch. Putting it in billpay.jar (ie. mediator) works well.
public class AuditFacadeFactory {
	public static AuditFacade getAuditFacade() {
		return new AuditFacade1();
		//return new RestAuditFacade();
	}
}