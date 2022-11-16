package com.extensiblejava.ui;

import com.extensiblejava.audit.AuditException;
import com.extensiblejava.bill.Bill;
import com.extensiblejava.bill.DefaultBillEntityLoader;
import com.extensiblejava.mediator.AuditFacadeFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuditAction extends Action {
	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response) throws ServletException {

		BillDetailForm billDetailForm = (BillDetailForm) form;
		Bill bill = Bill.loadBill(new DefaultBillEntityLoader(new Integer(billDetailForm.getBillId())));

		try {
			bill.audit(AuditFacadeFactory.getAuditFacade());
			request.setAttribute("bill", bill);
			return (mapping.findForward("success"));
		} catch (AuditException e) {
			throw new ServletException(e);
		}
	}

}