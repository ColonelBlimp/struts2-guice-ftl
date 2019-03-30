package com.struts2stuff.struts2.actions;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.struts2stuff.struts2.Facade;

public final class HomeAction extends BaseAction {

	private static final Logger log = LogManager.getLogger(HomeAction.class);

	private final List<String> textList;

	@Inject
	public HomeAction(Facade facade) {
		this.textList = facade.getTextList();
	}

	@Override
	public String execute() throws Exception {
		log.trace("called");
		return SUCCESS;
	}

	public List<String> getTextList() {
		return this.textList;
	}
}
