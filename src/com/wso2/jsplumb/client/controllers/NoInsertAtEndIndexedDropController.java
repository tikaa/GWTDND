package com.wso2.jsplumb.client.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.drop.SimpleDropController;
import com.google.appengine.api.log.LogService.LogLevel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.MouseMoveEvent;
//import com.google.gwt.core.client.GWT;
//import com.google.gwt.core.client.ScriptInjector;
//import com.google.gwt.dom.client.Style.Unit;
//import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.HorizontalPanel;
//import com.google.gwt.resources.client.TextResource;
//import com.google.gwt.resources.client.ClientBundle.Source;
//import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.wso2.jsplumb.client.GWTjsplumbSample;
import com.wso2.jsplumb.client.extendedpanels.ExtendedHorizontalPanel;
import com.wso2.jsplumb.client.injectors.jsClientBundle;

public class NoInsertAtEndIndexedDropController extends SimpleDropController {

	private final static Logger LOGGER = Logger
			.getLogger(NoInsertAtEndIndexedDropController.class.getName());

	private Widget dropTarget;
	private EntryPoint mainEntryPOint;

	static MouseMoveEvent mouseEvent;
	static int mouseX = 0;
	static int mouseY = 0;
	// DroppableOptions options = new DroppableOptions();

	// String id1 = null;
	// String id2 = null;

	private ImageResource DropCallImage = jsClientBundle.INSTANCE.CallImage();
	private ImageResource DropCallTempImage = jsClientBundle.INSTANCE
			.CalleTempImage();
	private ImageResource DropLogImage = jsClientBundle.INSTANCE.LogImage();
	private ImageResource DropDropImage = jsClientBundle.INSTANCE.DropImage();
	private ImageResource DropStoreImage = jsClientBundle.INSTANCE.StoreImage();
	private ImageResource DropThrottleImage = jsClientBundle.INSTANCE
			.ThrottleImage();
	private ImageResource DropSendImage = jsClientBundle.INSTANCE.SendImage();
	private ImageResource DropPayloadFactoryImage = jsClientBundle.INSTANCE
			.PayloadFactoryImage();
	private ImageResource DropRespondImage = jsClientBundle.INSTANCE
			.RespondImage();
	private ImageResource DropCloneImage = jsClientBundle.INSTANCE.CloneImage();
	private ImageResource DropPropertyImage = jsClientBundle.INSTANCE
			.PropertyImage();

	int ElementCount = 1;
	int xCoord = 50;
	int yCoord = 200;

	public NoInsertAtEndIndexedDropController(Widget dropTarget,
			EntryPoint newEntrypoint) {
		super(dropTarget);
		this.dropTarget = dropTarget;
		// this.mainEntryPOint = newEntrypoint;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onDrop(DragContext context) {

		xCoord += 100;
		for (Widget widget : context.selectedWidgets) {

			/*
			 * if (widget != null) {
			 * GWTjsplumbSample.myecho("wdgettruecameinside"); Image
			 * newDroppedElem = new Image();
			 * newDroppedElem.getElement().setId("dragged" + ElementCount);
			 * newDroppedElem.getElement().setPropertyBoolean("draggable",
			 * false);
			 * newDroppedElem.addClickHandler(GWTjsplumbSample.clickHandler);
			 * GWTjsplumbSample.myecho("newImageCreated");
			 * widget.removeStyleName
			 * ("gwt-Image dragdrop-draggable dragdrop-handle dragdrop-dragging"
			 * );
			 * widget.addStyleName("gwt-Image dragdrop-draggable dragdrop-handle"
			 * ); GWTjsplumbSample.myecho("stylesChanges");
			 * RootPanel.get("draggablePanel").add(widget);
			 * GWTjsplumbSample.myecho
			 * ("panelswere taken and not niull"+RootPanel
			 * .get("droppablePanel").getWidgetCount()); if
			 * (RootPanel.get("draggablePanel") != null &&
			 * RootPanel.get("droppablePanel") != null) {
			 * GWTjsplumbSample.myecho
			 * ("panelswere taken and not niull"+RootPanel
			 * .get("droppablePanel").getWidgetCount());
			 * RootPanel.get("draggablePanel").add(widget);
			 * RootPanel.get("droppablePanel").remove(widget); String thisId =
			 * widget.getElement().getId(); GWTjsplumbSample.myecho(thisId); if
			 * (thisId.equalsIgnoreCase("callMediator")) {
			 * newDroppedElem.setResource(DropCallImage); } if
			 * (thisId.equalsIgnoreCase("callTemplateMediator")) {
			 * newDroppedElem.setResource(DropCallTempImage); } if
			 * (thisId.equalsIgnoreCase("logMediator")) {
			 * newDroppedElem.setResource(DropLogImage); } if
			 * (thisId.equalsIgnoreCase("dropMediator")) {
			 * newDroppedElem.setResource(DropDropImage); } if
			 * (thisId.equalsIgnoreCase("storeMediator")) {
			 * newDroppedElem.setResource(DropStoreImage); } if
			 * (thisId.equalsIgnoreCase("sendMediator")) {
			 * newDroppedElem.setResource(DropSendImage); } if
			 * (thisId.equalsIgnoreCase("cloneMediator")) {
			 * newDroppedElem.setResource(DropCloneImage); } if
			 * (thisId.equalsIgnoreCase("throttleMediator")) {
			 * newDroppedElem.setResource(DropThrottleImage); } if
			 * (thisId.equalsIgnoreCase("respondMediator")) {
			 * newDroppedElem.setResource(DropRespondImage); } if
			 * (thisId.equalsIgnoreCase("propertyMediator")) {
			 * newDroppedElem.setResource(DropPropertyImage); } if
			 * (thisId.equalsIgnoreCase("paylfacMediator")) {
			 * newDroppedElem.setResource(DropPayloadFactoryImage); }
			 * GWTjsplumbSample.WidgetMap.put(ElementCount, newDroppedElem
			 * .getElement().getId());
			 * 
			 * RootPanel.get("background").add(newDroppedElem);
			 * RootPanel.get("background").setWidgetPosition( newDroppedElem,
			 * xCoord, yCoord);
			 * GWTjsplumbSample.myecho("Added element successfully!!");
			 * newDroppedElem = null;
			 * RootPanel.get("background").getAbsoluteLeft(); } else{
			 * GWTjsplumbSample.myecho("panelswere null hence didnt go in"); } }
			 * else { LOGGER.log(Level.INFO,
			 * "no widget selected, widget is null");
			 * GWTjsplumbSample.myecho("widget was null"); }
			 */
			widget.removeStyleName("gwt-Image dragdrop-draggable dragdrop-handle dragdrop-dragging");
			widget.addStyleName("gwt-Image dragdrop-draggable dragdrop-handle");
			String thisId = widget.getElement().getId();
			widget.getElement().setId("dragged" + thisId + ElementCount);
			RootPanel.get("background").setWidgetPosition( widget,
					  xCoord, yCoord);
			GWTjsplumbSample.WidgetMap.put(ElementCount, widget
					  .getElement().getId());

		}
		// setMouseEvent(null);

		int PrevCount = ElementCount - 1;
		String prevElem = "dragged" + PrevCount;
		String currElem = "dragged" + ElementCount;
		GWTjsplumbSample.gwtjsPlumbDemo(prevElem, currElem, ElementCount);
		ElementCount++;
		super.onDrop(context);

	}

	@Override
	public void onEnter(DragContext context) {
		super.onEnter(context);
		for (Widget widget : context.selectedWidgets) {

		}

	}

	@Override
	public void onLeave(DragContext context) {
		for (Widget widget : context.selectedWidgets) {

		}

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
