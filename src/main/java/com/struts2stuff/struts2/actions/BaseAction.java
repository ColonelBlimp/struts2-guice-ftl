package com.struts2stuff.struts2.actions;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ValidationAwareSupport;
import com.opensymphony.xwork2.interceptor.ValidationAware;

public class BaseAction implements Action, ValidationAware {

	private static final Logger log = LogManager.getLogger(BaseAction.class);

	private final ValidationAwareSupport validationAware = new ValidationAwareSupport();

	private String pageTitle;

	@Override
	public String execute() throws Exception {
		log.trace("called");
		return SUCCESS;
	}

	public String getPageTitle() {
		return this.pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	@Override
	public void setActionErrors(Collection<String> errorMessages) {
		this.setActionErrors(errorMessages);
	}

	@Override
	public Collection<String> getActionErrors() {
		return this.validationAware.getActionErrors();
	}

	@Override
	public void setActionMessages(Collection<String> messages) {
		this.validationAware.setActionMessages(messages);
	}

	@Override
	public Collection<String> getActionMessages() {
		return this.getActionMessages();
	}

	@Override
	public void setFieldErrors(Map<String, List<String>> errorMap) {
		this.validationAware.setFieldErrors(errorMap);
	}

	@Override
	public Map<String, List<String>> getFieldErrors() {
		return this.validationAware.getFieldErrors();
	}

	@Override
	public void addActionError(String anErrorMessage) {
		this.validationAware.addActionError(anErrorMessage);
	}

	@Override
	public void addActionMessage(String aMessage) {
		this.validationAware.addActionMessage(aMessage);
	}

	@Override
	public void addFieldError(String fieldName, String errorMessage) {
		this.validationAware.addFieldError(fieldName, errorMessage);
	}

	@Override
	public boolean hasActionErrors() {
		return this.validationAware.hasActionErrors();
	}

	@Override
	public boolean hasActionMessages() {
		return this.validationAware.hasActionMessages();
	}

	@Override
	public boolean hasErrors() {
		return this.validationAware.hasErrors();
	}

	@Override
	public boolean hasFieldErrors() {
		return this.validationAware.hasFieldErrors();
	}
}
