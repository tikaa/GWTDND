package com.wso2.jsplumb.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.wso2.jsplumb.client.controllers.CustomImageElementDropControler;
import com.wso2.jsplumb.client.injectors.JsClientBundle;

public class MediatorCreator {

	private static final String DRAGGABLE = "draggable"; //$NON-NLS-1$
	private static final String MEDIATOR = "Mediator"; //$NON-NLS-1$

	public static ImageResource getImage(Mediator mediator) {

		final Logger LOGGER = Logger.getLogger(CustomImageElementDropControler.class.getName());
		ImageResource imageResource = null;

		switch (mediator) {
		case LOG:
			imageResource = JsClientBundle.INSTANCE.LogImage();
			break;

		case CALL:
			imageResource = JsClientBundle.INSTANCE.CallImage();
			break;

		case PAYLOADFACTORY:
			imageResource = JsClientBundle.INSTANCE.PayloadFactoryImage();
			break;

		case SEND:
			imageResource = JsClientBundle.INSTANCE.SendImage();
			break;

		case RESPOND:
			imageResource = JsClientBundle.INSTANCE.RespondImage();
			break;

		case PROPERTY:
			imageResource = JsClientBundle.INSTANCE.PropertyImage();
			break;

		case CALLTEMPLATE:
			imageResource = JsClientBundle.INSTANCE.CalleTempImage();
			break;

		case THROTTLE:
			imageResource = JsClientBundle.INSTANCE.ThrottleImage();
			break;

		case STORE:
			imageResource = JsClientBundle.INSTANCE.StoreImage();
			break;

		case CLONE:
			imageResource = JsClientBundle.INSTANCE.CloneImage();
			break;

		case DROP:
			imageResource = JsClientBundle.INSTANCE.DropImage();
			break;

		default:
			imageResource = JsClientBundle.INSTANCE.LogImage();
			LOGGER.log(Level.WARNING,
					Messages.getString("MediatorCreator.2")); //$NON-NLS-1$
			break;

		}

		return imageResource;
	}

	public static Image getMediatorByName(Mediator mediator, ClickHandler clickHandler) {
		Image cloneimage = getMediatorByName(mediator);
		cloneimage.addClickHandler(clickHandler);
		cloneimage.getElement().setPropertyBoolean(DRAGGABLE, false);
		return cloneimage;
	}

	public static Image getMediatorByName(Mediator mediator) {
		Image cloneimage = new Image();
		ImageResource image = getImage(mediator);
		cloneimage.getElement().setId(mediator.toString().toLowerCase() + MEDIATOR);
		cloneimage.setResource(image);
		return cloneimage;
	}

}
