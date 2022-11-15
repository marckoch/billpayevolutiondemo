package com.extensiblejava.ui;

import com.extensiblejava.bill.Bill;
import com.extensiblejava.bill.DefaultBillEntityLoader;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuditAction extends Action {
	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {

		BillDetailForm billDetailForm = (BillDetailForm) form;
		Bill bill = Bill.loadBill(new DefaultBillEntityLoader(new Integer(billDetailForm.getBillId())));

		bill.audit();
		request.setAttribute("bill",bill);
		return (mapping.findForward("success"));
	}

}