package com.extensiblejava.ui;

import org.apache.struts.action.ActionForm;

public class CustomerSearchForm extends ActionForm {

	private String customerId;

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerId() {
		return this.customerId;
	}

}