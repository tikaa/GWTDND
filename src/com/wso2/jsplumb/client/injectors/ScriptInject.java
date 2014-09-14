package com.wso2.jsplumb.client.injectors;

import com.google.gwt.core.client.ScriptInjector;

public class ScriptInject {
	
	  public static void injectScript() {
	        ScriptInjector
	                .fromString(jsClientBundle.INSTANCE.jquerysource().getText())
	                .setWindow(ScriptInjector.TOP_WINDOW).inject();
	        ScriptInjector
	                .fromString(jsClientBundle.INSTANCE.jqueryuimin().getText())
	                .setWindow(ScriptInjector.TOP_WINDOW).inject();
	        ScriptInjector
	                .fromString(jsClientBundle.INSTANCE.jsplumbsource().getText())
	                .setWindow(ScriptInjector.TOP_WINDOW).inject();
	        ScriptInjector
	                .fromString(jsClientBundle.INSTANCE.gwtresource().getText())
	                .setWindow(ScriptInjector.TOP_WINDOW).inject();
	       

	    }

}
