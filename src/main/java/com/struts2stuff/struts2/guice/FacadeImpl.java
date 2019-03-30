package com.struts2stuff.struts2.guice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.inject.Singleton;

import com.struts2stuff.struts2.Facade;

@Singleton
final class FacadeImpl implements Facade {

	private final List<String> list;

	protected FacadeImpl() {
		this.list = new ArrayList<>();
		this.list.add("Default Entry");
	}

	@Override
	public void addToTextList(String text) {
		this.list.add(Objects.requireNonNull(text));
	}
	
	@Override
	public List<String> getTextList() {
		return Collections.unmodifiableList(this.list);
	}
}
