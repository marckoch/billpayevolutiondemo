package com.extensiblejava.ui;

import org.apache.struts.action.ActionForm;

public class BillDetailForm extends ActionForm {

	private String billId;

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getBillId() {
		return this.billId;
	}

}