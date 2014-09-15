package com.wso2.jsplumb.client.injectors;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.resources.client.ClientBundle.Source;


public  interface JsClientBundle extends ClientBundle {
    JsClientBundle INSTANCE = GWT.create(JsClientBundle.class);

    @Source("com/wso2/jsplumb/client/scripts/jquery.min.js")
    TextResource jquerysource();

    @Source("com/wso2/jsplumb/client/scripts/jquery.ui.min.js")
    TextResource jqueryuimin();

    @Source("com/wso2/jsplumb/client/scripts/jquery.jsPlumb-1.6.2-min.js")
    TextResource jsplumbsource();

    @Source("com/wso2/jsplumb/client/scripts/gwtjsplumbdemo.js")
    TextResource gwtresource();

    @Source("icons/Call.gif")
    ImageResource CallImage();

    @Source("icons/CallTemplate.gif")
    ImageResource CalleTempImage();

    @Source("icons/Log.gif")
    ImageResource LogImage();

    @Source("icons/Drop.gif")
    ImageResource DropImage();

    @Source("icons/Clone.gif")
    ImageResource CloneImage();

    @Source("icons/Respond.gif")
    ImageResource RespondImage();

    @Source("icons/Property.gif")
    ImageResource PropertyImage();

    @Source("icons/PayloadFactory.gif")
    ImageResource PayloadFactoryImage();

    @Source("icons/Throttle.gif")
    ImageResource ThrottleImage();

    @Source("icons/Send.gif")
    ImageResource SendImage();

    @Source("icons/Store.gif")
    ImageResource StoreImage();

}
