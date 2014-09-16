package com.wso2.jsplumb.client.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.drop.SimpleDropController;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.MouseMoveEvent;
//import com.google.gwt.core.client.GWT;
//import com.google.gwt.core.client.ScriptInjector;
//import com.google.gwt.dom.client.Style.Unit;
//import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
//import com.google.gwt.resources.client.TextResource;
//import com.google.gwt.resources.client.ClientBundle.Source;
//import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.wso2.jsplumb.client.GWTjsplumbSample;
import com.wso2.jsplumb.client.injectors.jsClientBundle;

public class NoInsertAtEndIndexedDropController extends SimpleDropController {

	private final static Logger LOGGER = Logger.getLogger(NoInsertAtEndIndexedDropController.class
			.getName());

	

	static MouseMoveEvent mouseEvent;
	static int mouseX = 0;
	static int mouseY = 0;
	

	private ImageResource DropCallImage = jsClientBundle.INSTANCE.CallImage();
	private ImageResource DropCallTempImage = jsClientBundle.INSTANCE.CalleTempImage();
	private ImageResource DropLogImage = jsClientBundle.INSTANCE.LogImage();
	private ImageResource DropDropImage = jsClientBundle.INSTANCE.DropImage();
	private ImageResource DropStoreImage = jsClientBundle.INSTANCE.StoreImage();
	private ImageResource DropThrottleImage = jsClientBundle.INSTANCE.ThrottleImage();
	private ImageResource DropSendImage = jsClientBundle.INSTANCE.SendImage();
	private ImageResource DropPayloadFactoryImage = jsClientBundle.INSTANCE.PayloadFactoryImage();
	private ImageResource DropRespondImage = jsClientBundle.INSTANCE.RespondImage();
	private ImageResource DropCloneImage = jsClientBundle.INSTANCE.CloneImage();
	private ImageResource DropPropertyImage = jsClientBundle.INSTANCE.PropertyImage();

	int ElementCount = 1;
	int xCoord = 50;
	int yCoord = 200;

	public Image newDroppedElem;

	public NoInsertAtEndIndexedDropController(Widget dropTarget, EntryPoint newEntrypoint) {
		super(dropTarget);
	}

	@Override
	public void onDrop(DragContext context) {

		xCoord += 100;
		String thisId = null;
		for (Widget widget : context.selectedWidgets) {

			if (widget != null) {
				
				thisId = widget.getElement().getId();
				Image newDroppedElem = new Image();
				newDroppedElem.getElement().setId("dragged" + ElementCount);
				newDroppedElem.getElement().setPropertyBoolean("draggable", false);
				newDroppedElem.addClickHandler(GWTjsplumbSample.clickHandler);
				widget.removeStyleName("gwt-Image dragdrop-draggable dragdrop-handle dragdrop-dragging");
				widget.addStyleName("gwt-Image dragdrop-draggable dragdrop-handle");
				RootPanel.get("draggablePanel").add(widget);
				RootPanel.get("droppablePanel").remove(widget);
				
				if (RootPanel.get("draggablePanel") != null && RootPanel.get("droppablePanel") != null) {

					if (thisId.equalsIgnoreCase("callMediator")) {
						newDroppedElem.setResource(DropCallImage);
					}
					if (thisId.equalsIgnoreCase("callTemplateMediator")) {
						newDroppedElem.setResource(DropCallTempImage);
					}
					if (thisId.equalsIgnoreCase("logMediator")) {
						newDroppedElem.setResource(DropLogImage);
					}
					if (thisId.equalsIgnoreCase("dropMediator")) {
						newDroppedElem.setResource(DropDropImage);
					}
					if (thisId.equalsIgnoreCase("storeMediator")) {
						newDroppedElem.setResource(DropStoreImage);
					}
					if (thisId.equalsIgnoreCase("sendMediator")) {
						newDroppedElem.setResource(DropSendImage);
					}
					if (thisId.equalsIgnoreCase("cloneMediator")) {
						newDroppedElem.setResource(DropCloneImage);
					}
					if (thisId.equalsIgnoreCase("throttleMediator")) {
						newDroppedElem.setResource(DropThrottleImage);
					}
					if (thisId.equalsIgnoreCase("respondMediator")) {
						newDroppedElem.setResource(DropRespondImage);
					}
					if (thisId.equalsIgnoreCase("propertyMediator")) {
						newDroppedElem.setResource(DropPropertyImage);
					}
					if (thisId.equalsIgnoreCase("paylfacMediator")) {
						newDroppedElem.setResource(DropPayloadFactoryImage);
					}
					String newDroppedElemId = "dragged" + thisId + ElementCount;
					newDroppedElem.getElement().setId(newDroppedElemId);					
					GWTjsplumbSample.WidgetMap.put(ElementCount, newDroppedElem.getElement()
							.getId());
					RootPanel.get("droppablePanel").add(newDroppedElem);
					RootPanel.get("droppablePanel").setWidgetPosition(newDroppedElem, xCoord, yCoord);
					newDroppedElem = null;
					RootPanel.get("background").getAbsoluteLeft();
				} else {
					LOGGER.log(Level.INFO, "the draggable and droppable panels returned null");
				}
			} else {
				LOGGER.log(Level.INFO, "no widget selected, widget is null");
				
			}

		}

		int PrevCount = ElementCount - 1;
		String prevElem = GWTjsplumbSample.WidgetMap.get(PrevCount);
		String currElem = GWTjsplumbSample.WidgetMap.get(ElementCount);
		GWTjsplumbSample.gwtjsPlumbDemo(prevElem, currElem, ElementCount);
		ElementCount++;
		super.onDrop(context);

	}

	@Override
	public void onEnter(DragContext context) {
		super.onEnter(context);
	}

	@Override
	public void onLeave(DragContext context) {
		super.onLeave(context);
	}

	public static void setMouseEvent(MouseMoveEvent e) {
		mouseEvent = e;
		mouseX = mouseEvent.getX();
		mouseY = mouseEvent.getY();
	}

	// var val1 =
	// this.@com.wso2.jsplumb.client.NoInsertAtEndIndexedDropController::idval(Ljava/lang/String;)(a);
	// var val2 =
	// this.@com.wso2.jsplumb.client.NoInsertAtEndIndexedDropController::idval(Ljava/lang/String;)(b);

}
