package com.wso2.jsplumb.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.wso2.jsplumb.client.controllers.CustomImageElementDragController;
import com.wso2.jsplumb.client.controllers.CustomImageElementDropControler;
import com.wso2.jsplumb.client.extendedpanels.ExtendedHorizontalPanel;
import com.wso2.jsplumb.client.injectors.ScriptInjectorHelper;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTjsplumbSample implements EntryPoint {

	private static final String POSITION_RELATIVE = "relative";
	private static final int DROPPABLE_HEIGHT = 1000;
	private static final int DROPPABLE_WIDTH = 1400;
	private static final int DRAGGABLE_HEIGHT = 1000;
	private static final int DRAGGABLE_WIDTH = 150;
	private static final String STYLE_POSITION = "position";
	private static final String CSS_MAINWINDOW = "mainwindow";
	private static final String DROPPABLE_PANEL = "droppablePanel";
	private static final String DRAGGABLE_PANEL = "draggablePanel";
	private static final String BACKGROUND = "background";

	private static HorizontalPanel backgroundPanel = new HorizontalPanel();
	private static VerticalPanel draggablePanel = new VerticalPanel();
	private static ExtendedHorizontalPanel droppablePanel = new ExtendedHorizontalPanel();

	private ArrayList<Image> draggableWidgetList = new ArrayList<Image>();

	public void onModuleLoad() {

		backgroundPanel.getElement().setId(BACKGROUND);
		draggablePanel.getElement().setId(DRAGGABLE_PANEL);
		droppablePanel.getElement().setId(DROPPABLE_PANEL);

		draggablePanel.getElement().setClassName(CSS_MAINWINDOW);
		droppablePanel.getElement().setClassName(CSS_MAINWINDOW);
		draggablePanel.setPixelSize(DRAGGABLE_WIDTH, DRAGGABLE_HEIGHT);
		droppablePanel.setPixelSize(DROPPABLE_WIDTH, DROPPABLE_HEIGHT);
		draggablePanel.getElement().getStyle().setProperty(STYLE_POSITION, POSITION_RELATIVE);
		droppablePanel.getElement().getStyle().setProperty(STYLE_POSITION, POSITION_RELATIVE);

		/* Create the GWT widgets */

		Image logImage = MediatorCreator.getMediatorByName(Mediator.LOG);
		draggablePanel.add(logImage);
		draggableWidgetList.add(logImage);
		Image callImage = MediatorCreator.getMediatorByName(Mediator.CALL);
		draggablePanel.add(callImage);
		draggableWidgetList.add(callImage);
		Image dropImage = MediatorCreator.getMediatorByName(Mediator.DROP);
		draggablePanel.add(dropImage);
		draggableWidgetList.add(dropImage);
		Image callTempImage = MediatorCreator.getMediatorByName(Mediator.CALLTEMPLATE);
		draggablePanel.add(callTempImage);
		draggableWidgetList.add(callTempImage);
		Image storeImage = MediatorCreator.getMediatorByName(Mediator.STORE);
		draggablePanel.add(storeImage);
		draggableWidgetList.add(storeImage);
		Image throttleImage = MediatorCreator.getMediatorByName(Mediator.THROTTLE);
		draggablePanel.add(throttleImage);
		draggableWidgetList.add(throttleImage);
		Image sendImage = MediatorCreator.getMediatorByName(Mediator.SEND);
		draggablePanel.add(sendImage);
		draggableWidgetList.add(sendImage);
		Image payloadfacImage = MediatorCreator.getMediatorByName(Mediator.PAYLOADFACTORY);
		draggablePanel.add(payloadfacImage);
		draggableWidgetList.add(payloadfacImage);
		Image respondImage = MediatorCreator.getMediatorByName(Mediator.RESPOND);
		draggablePanel.add(respondImage);
		draggableWidgetList.add(respondImage);
		Image cloneImage = MediatorCreator.getMediatorByName(Mediator.CLONE);
		draggablePanel.add(cloneImage);
		draggableWidgetList.add(cloneImage);
		Image propertyImage = MediatorCreator.getMediatorByName(Mediator.PROPERTY);
		draggablePanel.add(propertyImage);
		draggableWidgetList.add(propertyImage);
		droppablePanel.addKeyDownHandler(CustomImageElementDropControler.keyDownHandler);

		backgroundPanel.add(draggablePanel);
		backgroundPanel.add(droppablePanel);

		RootPanel.get().add(backgroundPanel);

		/* DRAG AND DROP */
		RootPanel.get(BACKGROUND).getElement().getStyle()
				.setProperty(STYLE_POSITION, POSITION_RELATIVE);
		CustomImageElementDragController dragController = new CustomImageElementDragController(
				RootPanel.get(BACKGROUND), true);
		CustomImageElementDropControler widgetDropController = new CustomImageElementDropControler(
				backgroundPanel, this);
		dragController.registerDropController(widgetDropController);

		/*
		 * making the widgets draggable
		 */
		for (Image draggableImage : draggableWidgetList) {
			dragController.makeDraggable(draggableImage);
		}
		ScriptInjectorHelper.injectScript();

	}

	public static native void gwtjsPlumbDemo(String prevElem, String currElem, int ElemCount) /*-{
		if (ElemCount > 1) {
			$wnd.gwtjsplumbdemo(prevElem, currElem);
		}
	}-*/;

	public static native void gwtjsPlumbDemo(String prevElem, String currElem) /*-{
		$wnd.gwtjsplumbdemo(prevElem, currElem);

	}-*/;

}
