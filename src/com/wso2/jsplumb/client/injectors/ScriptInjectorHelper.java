package com.wso2.jsplumb.client.injectors;

import com.google.gwt.core.client.ScriptInjector;

public class ScriptInjectorHelper {
	
	  public static void injectScript() {
	        ScriptInjector
	                .fromString(JsClientBundle.INSTANCE.jquerysource().getText())
	                .setWindow(ScriptInjector.TOP_WINDOW).inject();
	        ScriptInjector
	                .fromString(JsClientBundle.INSTANCE.jqueryuimin().getText())
	                .setWindow(ScriptInjector.TOP_WINDOW).inject();
	        ScriptInjector
	                .fromString(JsClientBundle.INSTANCE.jsplumbsource().getText())
	                .setWindow(ScriptInjector.TOP_WINDOW).inject();
	        ScriptInjector
	                .fromString(JsClientBundle.INSTANCE.gwtresource().getText())
	                .setWindow(ScriptInjector.TOP_WINDOW).inject();
	       

	    }

}
