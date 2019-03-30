package com.struts2stuff.struts2.actions;

import java.util.Objects;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.Validateable;
import com.struts2stuff.struts2.Facade;
import com.struts2stuff.struts2.beans.ListElementBean;

public final class AddAction extends BaseAction implements Validateable {

	private static final Logger log = LogManager.getLogger(AddAction.class);

	private String submitValue;
	private ListElementBean bean;

	private final Facade facade;

	@Inject
	public AddAction(Facade facade) {
		this.facade = Objects.requireNonNull(facade, "Guice has not been able to inject the Facade.");
	}

	@Override
	public String execute() throws Exception {
		log.trace("called");

		if (this.submitValue == null) {
			log.trace("Submit is null, do INPUT");
			this.bean = new ListElementBean();
			return INPUT;
		}

		if ("Cancel".equals(this.submitValue)) {
			log.trace("Cancel submit");
			return SUCCESS;
		}
		
		if ("Add".equals(this.submitValue)) {
			log.trace("Add submit");
			this.facade.addToTextList(this.bean.getText());
			log.debug("Added the text: {}", this.bean.getText());
		}

		return SUCCESS;
	}

	@Override
	public void validate() {
		log.trace("called");

		if (this.submitValue == null) {
			log.trace("Submit is null, return early.");
			return;
		}

		if ("Cancel".equals(this.submitValue)) {
			log.trace("Submit is Cancel, return early.");
			return;
		}

		if ("".equals(this.bean.getText())) {
			log.trace("No text entered, so back to the user.");
			this.addFieldError("bean.text", "Please add some text.");
		}
	}

	public String getSubmitValue() {
		return this.submitValue;
	}

	public void setSubmitValue(String submitValue) {
		this.submitValue = submitValue;
	}

	public ListElementBean getBean() {
		return this.bean;
	}

	public void setBean(ListElementBean bean) {
		this.bean = bean;
	}
}
