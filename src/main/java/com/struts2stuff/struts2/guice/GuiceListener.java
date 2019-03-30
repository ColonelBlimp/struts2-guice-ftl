package com.struts2stuff.struts2.guice;

import javax.inject.Singleton;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.struts2.Struts2GuicePluginModule;
import com.struts2stuff.struts2.Facade;

public final class GuiceListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(
			new Struts2GuicePluginModule(),
			new ServletModule() {

				@Override
				protected void configureServlets() {
					// Struts2
                    bind(StrutsPrepareAndExecuteFilter.class).in(Singleton.class);
                    filter("/*").through(StrutsPrepareAndExecuteFilter.class);

                    // Application
                    bind(Facade.class).to(FacadeImpl.class);
				}
			}
		);
	}
}
