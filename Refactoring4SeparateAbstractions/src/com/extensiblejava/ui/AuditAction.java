package com.extensiblejava.ui;

import com.extensiblejava.audit.audit1.AuditFacade1;
import com.extensiblejava.bill.Bill;
import com.extensiblejava.bill.DefaultBillEntityLoader;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuditAction extends Action {
	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response) {

		BillDetailForm billDetailForm = (BillDetailForm) form;
		Bill bill = Bill.loadBill(new DefaultBillEntityLoader(new Integer(billDetailForm.getBillId())));

		bill.audit(new AuditFacade1());
		request.setAttribute("bill",bill);
		return (mapping.findForward("success"));
	}

}