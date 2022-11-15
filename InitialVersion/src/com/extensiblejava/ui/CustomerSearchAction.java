package com.extensiblejava.ui;

import com.extensiblejava.bill.Customer;
import com.extensiblejava.bill.DefaultCustomerEntityLoader;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerSearchAction extends Action {
	public ActionForward perform(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws IOException, ServletException {
		CustomerSearchForm customerSearchForm = (CustomerSearchForm) form;

		Customer customer = Customer.loadCustomer(new DefaultCustomerEntityLoader(new Integer(customerSearchForm.getCustomerId())));

		CustomerSearchResultsBean bean = new CustomerSearchResultsBean(customer);
		request.setAttribute("customerbills",bean);
		return (mapping.findForward("success"));
	}

}