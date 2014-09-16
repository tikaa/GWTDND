package com.wso2.jsplumb.client;

import com.google.gwt.core.client.EntryPoint;

import java.util.HashMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.wso2.jsplumb.client.controllers.CustomImageElementDragController;
import com.wso2.jsplumb.client.controllers.CustomImageElementDropControler;
import com.wso2.jsplumb.client.controllers.NoInsertAtEndIndexedDropController;
import com.wso2.jsplumb.client.extendedpanels.ExtendedHorizontalPanel;
import com.wso2.jsplumb.client.injectors.ScriptInjectorHelper;
import com.wso2.jsplumb.client.injectors.JsClientBundle;

//import static com.google.gwt.query.client.GQuery.$;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTjsplumbSample implements EntryPoint {

	private ImageResource CallImage = JsClientBundle.INSTANCE.CallImage();
	private ImageResource CallTempImage = JsClientBundle.INSTANCE.CalleTempImage();
	private ImageResource LogImage = JsClientBundle.INSTANCE.LogImage();
	private ImageResource DropImage = JsClientBundle.INSTANCE.DropImage();
	private ImageResource StoreImage = JsClientBundle.INSTANCE.StoreImage();
	private ImageResource ThrottleImage = JsClientBundle.INSTANCE.ThrottleImage();
	private ImageResource SendImage = JsClientBundle.INSTANCE.SendImage();
	private ImageResource PayloadFactoryImage = JsClientBundle.INSTANCE.PayloadFactoryImage();
	private ImageResource RespondImage = JsClientBundle.INSTANCE.RespondImage();
	private ImageResource CloneImage = JsClientBundle.INSTANCE.CloneImage();
	private ImageResource PropertyImage = JsClientBundle.INSTANCE.PropertyImage();
	public static HorizontalPanel backgroundPanel = new HorizontalPanel();

	public static VerticalPanel draggablePanel = new VerticalPanel();
	public static ExtendedHorizontalPanel droppablePanel = new ExtendedHorizontalPanel();

	FocusPanel wrapper = new FocusPanel();
	static Widget selectedWidget = new Widget();

	static String deletingWidgetId = "";
	static String widgetbeforeDeletingWidget = "";
	static String WidgetafterDeletingWdget = "";

	public static HashMap<Integer, String> WidgetMap = new HashMap<>();

	private Image callimage = new Image();
	private Image dropimage = new Image();
	private Image calltempimage = new Image();
	private Image logimage = new Image();
	private Image storeimage = new Image();
	private Image throttleimage = new Image();
	private Image sendimage = new Image();
	private Image payloadfactoryimage = new Image();
	private Image respondimage = new Image();
	private Image cloneimage = new Image();
	private Image propertyimage = new Image();

	public void onModuleLoad() {

		/* Create the GWT widgets */

		backgroundPanel.getElement().setId("background");
		draggablePanel.getElement().setId("draggablePanel");
		draggablePanel.setPixelSize(150, 1000);
		droppablePanel.getElement().setId("droppablePanel");

		draggablePanel.getElement().setClassName("mainwindow");
		droppablePanel.getElement().setClassName("mainwindow");
		droppablePanel.setPixelSize(1400, 1000);
		droppablePanel.getElement().getStyle().setProperty("position", "relative");
		draggablePanel.getElement().getStyle().setProperty("position", "relative");

		callimage.getElement().setId("callMediator");
		callimage.setResource(CallImage);
		callimage.addClickHandler(clickHandler);
		draggablePanel.add(callimage);

		dropimage.getElement().setId("dropMediator");
		dropimage.setResource(DropImage);
		dropimage.addClickHandler(clickHandler);
		draggablePanel.add(dropimage);

		calltempimage.getElement().setId("callTemplateMediator");
		calltempimage.setResource(CallTempImage);
		calltempimage.addClickHandler(clickHandler);
		draggablePanel.add(calltempimage);

		logimage.getElement().setId("logMediator");
		logimage.setResource(LogImage);
		logimage.addClickHandler(clickHandler);
		draggablePanel.add(logimage);

		storeimage.getElement().setId("storeMediator");
		storeimage.setResource(StoreImage);
		storeimage.addClickHandler(clickHandler);
		draggablePanel.add(storeimage);

		sendimage.getElement().setId("sendMediator");
		sendimage.setResource(SendImage);
		sendimage.addClickHandler(clickHandler);
		draggablePanel.add(sendimage);

		throttleimage.getElement().setId("throttleMediator");
		throttleimage.setResource(ThrottleImage);
		throttleimage.addClickHandler(clickHandler);
		draggablePanel.add(throttleimage);

		payloadfactoryimage.getElement().setId("paylfacMediator");
		payloadfactoryimage.setResource(PayloadFactoryImage);
		payloadfactoryimage.addClickHandler(clickHandler);
		draggablePanel.add(payloadfactoryimage);

		respondimage.getElement().setId("respondMediator");
		respondimage.setResource(RespondImage);
		respondimage.addClickHandler(clickHandler);
		draggablePanel.add(respondimage);

		cloneimage.getElement().setId("cloneMediator");
		cloneimage.setResource(CloneImage);
		cloneimage.addClickHandler(clickHandler);
		draggablePanel.add(cloneimage);
		// droppablePanel.addKeyDownHandler(keyDownHandler);
		propertyimage.getElement().setId("propertyMediator");
		propertyimage.setResource(PropertyImage);
		propertyimage.addClickHandler(clickHandler);
		draggablePanel.add(propertyimage);

		backgroundPanel.add(draggablePanel);
		backgroundPanel.add(droppablePanel);

		RootPanel.get().add(backgroundPanel);

		/*
		 * DRAG AND DROP
		 */
		RootPanel.get("background").getElement().getStyle().setProperty("position", "relative");

		CustomImageElementDragController dragController = new CustomImageElementDragController(
				RootPanel.get("droppablePanel"), true);

		CustomImageElementDropControler widgetDropController = new CustomImageElementDropControler(
				droppablePanel, this);
		dragController.registerDropController(widgetDropController);

		/*
		 * making the widgets droppable and draggable
		 */
		dragController.makeDraggable(callimage);
		dragController.makeDraggable(calltempimage);
		dragController.makeDraggable(logimage);
		dragController.makeDraggable(dropimage);
		dragController.makeDraggable(sendimage);
		dragController.makeDraggable(storeimage);
		dragController.makeDraggable(respondimage);
		dragController.makeDraggable(propertyimage);
		dragController.makeDraggable(throttleimage);
		dragController.makeDraggable(payloadfactoryimage);
		dragController.makeDraggable(cloneimage);

		ScriptInjectorHelper.injectScript();

		gwtjsPlumbDemo("you", "me", 0);

	}

	public static final ClickHandler clickHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			event.preventDefault();
			selectedWidget = (Widget) event.getSource();
			myecho(selectedWidget.getElement().getId());

		}
	};

	public static final KeyDownHandler keyDownHandler = new KeyDownHandler() {

		@Override
		public void onKeyDown(KeyDownEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_DELETE) {
				myecho(selectedWidget.getElement().getId());
				deletingWidgetId = selectedWidget.getElement().getId();
				for (int i = 0; i < WidgetMap.size(); i++) {
					if (WidgetMap.get(i) == deletingWidgetId) {
						if (i != 0) {
							widgetbeforeDeletingWidget = WidgetMap.get(i - 1);
						}
						if (i != WidgetMap.size()) {
							WidgetafterDeletingWdget = WidgetMap.get(i + 1);
						}
					}
				}
				droppablePanel.remove(selectedWidget);
				if (WidgetafterDeletingWdget != null && widgetbeforeDeletingWidget != null) {
					gwtjsPlumbDemo(widgetbeforeDeletingWidget, WidgetafterDeletingWdget, 2);
				}
			}
		}
	};

	public static native void gwtjsPlumbDemo(String prevElem, String currElem, int ElemCount) /*-{
		//var countElem =this.@com.wso2.jsplumb.client.NoInsertAtEndIndexedDropController::ElementCount;
		$wnd.alert(prevElem);
		$wnd.alert(currElem);
		if (ElemCount > 1) {
			$wnd.gwtjsplumbdemo(prevElem, currElem);
		}
	}-*/;

	public static native void myecho(String selectedWid) /*-{
		$wnd.alert(selectedWid);

	}-*/;

}
