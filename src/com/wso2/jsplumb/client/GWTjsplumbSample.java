package com.wso2.jsplumb.client;

import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.wso2.jsplumb.client.controllers.CustomImageElementDropControler;
import com.wso2.jsplumb.client.controllers.CustomImageElementDragController;
import com.wso2.jsplumb.client.extendedpanels.ExtendedHorizontalPanel;
import com.wso2.jsplumb.client.injectors.ScriptInjectorHelper;

public class GWTjsplumbSample implements EntryPoint {

	public static HorizontalPanel backgroundPanel = new HorizontalPanel();
	public static VerticalPanel draggablePanel = new VerticalPanel();
	public static ExtendedHorizontalPanel droppablePanel = new ExtendedHorizontalPanel();

	FocusPanel wrapper = new FocusPanel();
	static Widget selectedWidget = new Widget();

	static String deletingWidgetId = "";
	static String widgetbeforeDeletingWidget = "";
	static String WidgetafterDeletingWdget = "";

	// public static HashMap<Integer, String> WidgetMap = new HashMap<>();

	public void onModuleLoad() {

		backgroundPanel.getElement().setId("background");
		draggablePanel.getElement().setId("draggablePanel");
		draggablePanel.setPixelSize(150, 1000);
		droppablePanel.getElement().setId("droppablePanel");

		draggablePanel.getElement().setClassName("window");
		droppablePanel.getElement().setClassName("window");
		droppablePanel.setPixelSize(1400, 1000);
		droppablePanel.getElement().getStyle().setProperty("position", "relative");

		Image logImage = MediatorCreator.getMediatorByName(Mediator.LOG, clickHandler);
		draggablePanel.add(logImage);

		Image propertyImage = MediatorCreator.getMediatorByName(Mediator.PROPERTY, clickHandler);
		draggablePanel.add(propertyImage);

		Image dropImage = MediatorCreator.getMediatorByName(Mediator.DROP, clickHandler);
		draggablePanel.add(dropImage);

		Image sendImage = MediatorCreator.getMediatorByName(Mediator.SEND,
				clickHandler);
		draggablePanel.add(sendImage);

		Image storeImage = MediatorCreator.getMediatorByName(Mediator.STORE,
				clickHandler);
		draggablePanel.add(storeImage);

		Image cloneImage = MediatorCreator.getMediatorByName(Mediator.CLONE,
				clickHandler);
		draggablePanel.add(cloneImage);

		// droppablePanel.addKeyDownHandler(keyDownHandler);

		backgroundPanel.add(draggablePanel);
		backgroundPanel.add(droppablePanel);

		RootPanel.get().add(backgroundPanel);

		// RootPanel.get("window2").setPixelSize(1000, 1100);

		/*
		 * DRAG AND DROP
		 */
		RootPanel.get("background").getElement().getStyle()
				.setProperty("position", "relative");

		CustomImageElementDragController dragController = new CustomImageElementDragController(
				RootPanel.get("background"), true);

		CustomImageElementDropControler widgetDropController = new CustomImageElementDropControler(
				backgroundPanel, this);
		dragController.registerDropController(widgetDropController);

		/*
		 * Trying to make droppable and draggable
		 */
		dragController.makeDraggable(logImage);
		dragController.makeDraggable(propertyImage);
		dragController.makeDraggable(sendImage);
		dragController.makeDraggable(cloneImage);
		dragController.makeDraggable(sendImage);
		dragController.makeDraggable(storeImage);

		ScriptInjectorHelper.injectScript();

		gwtjsPlumbDemo("you", "me", 0);

	}

	public static final ClickHandler clickHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			event.preventDefault();
			selectedWidget = (Widget) event.getSource();
		}
	};

	public static final KeyDownHandler keyDownHandler = new KeyDownHandler() {

		@Override
		public void onKeyDown(KeyDownEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_DELETE) {
				// myecho(selectedWidget.getElement().getId());
				// deletingWidgetId = selectedWidget.getElement().getId();
				// for(int i=0;i<WidgetMap.size();i++){
				// if(WidgetMap.get(i)==deletingWidgetId){
				// if(i!=0){
				// widgetbeforeDeletingWidget = WidgetMap.get(i-1);}
				// if(i!=WidgetMap.size()){
				// WidgetafterDeletingWdget = WidgetMap.get(i+1);}
				// }
				// }
				droppablePanel.remove(selectedWidget);
				if (WidgetafterDeletingWdget != null
						&& widgetbeforeDeletingWidget != null) {
					gwtjsPlumbDemo(widgetbeforeDeletingWidget,
							WidgetafterDeletingWdget, 2);
				}
			}
		}
	};

	public static native void gwtjsPlumbDemo(String prevElem, String currElem,
		int elementCount) /*-{
		if (elementCount > 1) {
			$wnd.gwtjsplumbdemo(prevElem, currElem);
		}
	}-*/;

}
