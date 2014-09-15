package com.wso2.jsplumb.client.controllers;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.drop.SimpleDropController;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.wso2.jsplumb.client.Mediator;
import com.wso2.jsplumb.client.MediatorCreator;

public class CustomImageElementDropControler extends SimpleDropController {

	private int elementCount = 1;
	private int xCoord = 50;
	private int yCoord = 200;

	public CustomImageElementDropControler(Widget dropTarget,
			EntryPoint newEntrypoint) {
		super(dropTarget);
	}

	@Override
	public void onDrop(DragContext context) {

		// jsAlert("OnDrop");
		xCoord += 100;
		String thisId = null;
		for (Widget widget : context.selectedWidgets) {

			// jsAlert("OnDrop Widget widget : context.selectedWidgets");
			if (widget != null) {
				thisId = widget.getElement().getId();

				Image newDroppedElem = new Image();
				newDroppedElem.getElement().setId("dragged" + elementCount);
				// newDroppedElem.getElement().setPropertyBoolean("draggable",
				// false);
				// newDroppedElem.addClickHandler(GWTjsplumbSample.clickHandler);
				if (RootPanel.get("draggablePanel") != null
						&& RootPanel.get("droppablePanel") != null) {

					if (thisId.equalsIgnoreCase("callMediator")) {
						newDroppedElem.setResource(MediatorCreator
								.getImage(Mediator.CALL));
					} else if (thisId.equalsIgnoreCase("logMediator")) {
						newDroppedElem.setResource(MediatorCreator
								.getImage(Mediator.LOG));
					} else if (thisId.equalsIgnoreCase("dropMediator")) {
						newDroppedElem.setResource(MediatorCreator
								.getImage(Mediator.DROP));
					} else if (thisId.equalsIgnoreCase("storeMediator")) {
						newDroppedElem.setResource(MediatorCreator
								.getImage(Mediator.STORE));
					} else if (thisId.equalsIgnoreCase("sendMediator")) {
						newDroppedElem.setResource(MediatorCreator
								.getImage(Mediator.SEND));
					}
					if (thisId.equalsIgnoreCase("cloneMediator")) {
						newDroppedElem.setResource(MediatorCreator
								.getImage(Mediator.CLONE));
					}

					RootPanel.get("draggablePanel").add(newDroppedElem);
					newDroppedElem = null;
					RootPanel.get("background").getAbsoluteLeft();
				} else {

				}
			}

			String newDroppedElemId = "dragged" + thisId + elementCount;
			widget.removeStyleName("gwt-Image dragdrop-draggable dragdrop-handle dragdrop-dragging");
			widget.addStyleName("gwt-Image dragdrop-draggable dragdrop-handle");
			widget.getElement().setId(newDroppedElemId);
			RootPanel.get("background").setWidgetPosition(widget, xCoord,
					yCoord);
		}

		// int PrevCount = ElementCount - 1;
		// String prevElem = GWTjsplumbSample.WidgetMap.get(PrevCount);
		// String currElem = GWTjsplumbSample.WidgetMap.get(ElementCount);
		// GWTjsplumbSample.gwtjsPlumbDemo(prevElem, currElem, ElementCount);
		elementCount++;
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

	public static native void jsAlert(String message) /*-{
		$wnd.alert("jsAlert " + message);
	}-*/;

}
