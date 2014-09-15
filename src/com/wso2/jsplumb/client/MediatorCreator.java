package com.wso2.jsplumb.client;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.wso2.jsplumb.client.injectors.jsClientBundle;

public class MediatorCreator {

	public static ImageResource getImage(Mediator mediator) {

		ImageResource image = null;

		switch (mediator) {
		case LOG:
			image = jsClientBundle.INSTANCE.LogImage();
			break;

		case CALL:
			image = jsClientBundle.INSTANCE.CallImage();
			break;

		case PROPERTY:
			image = jsClientBundle.INSTANCE.PropertyImage();
			break;

		case SEND:
			image = jsClientBundle.INSTANCE.SendImage();
			break;

		case DROP:
			image = jsClientBundle.INSTANCE.DropImage();
			break;

		default:
			// Need to set a error icon for this
			image = jsClientBundle.INSTANCE.LogImage();
			break;

		}
		
		return image;
	}
	
	public static Image getMediatorByName(Mediator mediator, ClickHandler clickHandler) {
		Image cloneimage = new Image();
		ImageResource image = getImage(mediator);
		cloneimage.getElement().setId(mediator.toString().toLowerCase() + "Mediator"); //"cloneMediator" TODO move to constant
		cloneimage.setResource(image);
		cloneimage.addClickHandler(clickHandler);
		return cloneimage;
	}
	
	
	
}
