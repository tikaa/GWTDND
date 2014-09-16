package com.wso2.jsplumb.client.controllers;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.drop.SimpleDropController;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.wso2.jsplumb.client.GWTjsplumbSample;
import com.wso2.jsplumb.client.Mediator;
import com.wso2.jsplumb.client.MediatorCreator;

public class CustomImageElementDropControler extends SimpleDropController {

	private static final String DROPPABLE_PANEL = "droppablePanel"; //$NON-NLS-1$
	private static final String DRAGGABLE_PANEL = "draggablePanel"; //$NON-NLS-1$
	private static final String PAYLFAC_MEDIATOR = "paylfacMediator"; //$NON-NLS-1$
	private static final String PROPERTY_MEDIATOR = "propertyMediator"; //$NON-NLS-1$
	private static final String RESPOND_MEDIATOR = "respondMediator"; //$NON-NLS-1$
	private static final String THROTTLE_MEDIATOR = "throttleMediator"; //$NON-NLS-1$
	private static final String CLONE_MEDIATOR = "cloneMediator"; //$NON-NLS-1$
	private static final String SEND_MEDIATOR = "sendMediator"; //$NON-NLS-1$
	private static final String STORE_MEDIATOR = "storeMediator"; //$NON-NLS-1$
	private static final String DROP_MEDIATOR = "dropMediator"; //$NON-NLS-1$
	private static final String LOG_MEDIATOR = "logMediator"; //$NON-NLS-1$
	private static final String CALL_TEMPLATE_MEDIATOR = "callTemplateMediator"; //$NON-NLS-1$
	private static final String CALL_MEDIATOR = "callMediator"; //$NON-NLS-1$
	private static final String BACKGROUND = "background"; //$NON-NLS-1$
	private static final String DRAGGED = "dragged"; //$NON-NLS-1$

	private static final String DROPPABLE_IMAGE_STYLE = "gwt-Image dragdrop-draggable dragdrop-handle"; //$NON-NLS-1$
	private static final String DROPPING_IMAGE_STYLE = "gwt-Image dragdrop-draggable dragdrop-handle dragdrop-dragging"; //$NON-NLS-1$

	private final static Logger LOGGER = Logger.getLogger(CustomImageElementDropControler.class
			.getName());

	int ElementCount = 1;
	int xCoord = 50;
	int yCoord = 100;

	public Image newDroppedElem;
	static Widget selectedWidget = new Widget();
	public static HashMap<Integer, String> widgetMap = new HashMap<>();

	static String deletingWidgetId = null;
	static String widgetbeforeDeletingWidget = null;
	static String widgetafterDeletingWdget = null;

	public CustomImageElementDropControler(Widget dropTarget, EntryPoint newEntrypoint) {
		super(dropTarget);
	}

	@Override
	public void onDrop(DragContext context) {

		
		String thisId = null;
		for (Widget widget : context.selectedWidgets) {

			if (widget != null) {

				thisId = widget.getElement().getId();
				String newDroppedElemId = DRAGGED + thisId + ElementCount;

				widget.removeStyleName(DROPPING_IMAGE_STYLE);
				widget.addStyleName(DROPPABLE_IMAGE_STYLE);
				RootPanel.get(DRAGGABLE_PANEL).add(widget);
				RootPanel.get(DROPPABLE_PANEL).remove(widget);

				if (RootPanel.get(DRAGGABLE_PANEL) != null
						&& RootPanel.get(DROPPABLE_PANEL) != null) {

					if (thisId.equalsIgnoreCase(CALL_MEDIATOR)) {
						newDroppedElem = MediatorCreator.getMediatorByName(Mediator.CALL,
								clickHandler);
					}
					if (thisId.equalsIgnoreCase(CALL_TEMPLATE_MEDIATOR)) {
						newDroppedElem = MediatorCreator.getMediatorByName(Mediator.CALLTEMPLATE,
								clickHandler);
					}
					if (thisId.equalsIgnoreCase(LOG_MEDIATOR)) {
						newDroppedElem = MediatorCreator.getMediatorByName(Mediator.LOG,
								clickHandler);
					}
					if (thisId.equalsIgnoreCase(DROP_MEDIATOR)) {
						newDroppedElem = MediatorCreator.getMediatorByName(Mediator.DROP,
								clickHandler);
					}
					if (thisId.equalsIgnoreCase(STORE_MEDIATOR)) {
						newDroppedElem = MediatorCreator.getMediatorByName(Mediator.STORE,
								clickHandler);
					}
					if (thisId.equalsIgnoreCase(SEND_MEDIATOR)) {
						newDroppedElem = MediatorCreator.getMediatorByName(Mediator.SEND,
								clickHandler);
					}
					if (thisId.equalsIgnoreCase(CLONE_MEDIATOR)) {
						newDroppedElem = MediatorCreator.getMediatorByName(Mediator.CLONE,
								clickHandler);
					}
					if (thisId.equalsIgnoreCase(THROTTLE_MEDIATOR)) {
						newDroppedElem = MediatorCreator.getMediatorByName(Mediator.THROTTLE,
								clickHandler);
					}
					if (thisId.equalsIgnoreCase(RESPOND_MEDIATOR)) {
						newDroppedElem = MediatorCreator.getMediatorByName(Mediator.RESPOND,
								clickHandler);
					}
					if (thisId.equalsIgnoreCase(PROPERTY_MEDIATOR)) {
						newDroppedElem = MediatorCreator.getMediatorByName(Mediator.PROPERTY,
								clickHandler);
					}
					if (thisId.equalsIgnoreCase(PAYLFAC_MEDIATOR)) {
						newDroppedElem = MediatorCreator.getMediatorByName(Mediator.PAYLOADFACTORY,
								clickHandler);
					}
					newDroppedElem.getElement().setId(newDroppedElemId);
					RootPanel.get(DROPPABLE_PANEL).add(newDroppedElem);
					RootPanel.get(DROPPABLE_PANEL)
							.setWidgetPosition(newDroppedElem, xCoord, yCoord);
					widgetMap.put(ElementCount, newDroppedElem.getElement().getId());
					newDroppedElem = null;
					RootPanel.get(BACKGROUND).getAbsoluteLeft();
				} else {
					LOGGER.log(Level.INFO, Messages.getString("CustomImageElementDropControler.0")); //$NON-NLS-1$
				}
			} else {
				LOGGER.log(Level.INFO, Messages.getString("CustomImageElementDropControler.18")); //$NON-NLS-1$
			}

		}

		int PrevCount = ElementCount - 1;
		String prevElem = widgetMap.get(PrevCount);
		String currElem = widgetMap.get(ElementCount);
		GWTjsplumbSample.gwtjsPlumbDemo(prevElem, currElem, ElementCount);
		ElementCount++;
		
		xCoord += 100;
		
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

	public static final ClickHandler clickHandler = new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			event.preventDefault();
			selectedWidget = (Widget) event.getSource();
			myecho(selectedWidget.getElement().getId());
		}
	};
	
	public static native void myecho(String selectedWid) /*-{
		$wnd.alert(selectedWid);

	}-*/;


	public static final KeyDownHandler keyDownHandler = new KeyDownHandler() {

		@Override
		public void onKeyDown(KeyDownEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_DELETE) {

				deletingWidgetId = selectedWidget.getElement().getId();
				for (int i = 0; i < widgetMap.size(); i++) {
					if (widgetMap.get(i) == deletingWidgetId) {
						if (i != 0) {
							widgetbeforeDeletingWidget = widgetMap.get(i - 1);
						}
						if (i != widgetMap.size()) {
							widgetafterDeletingWdget = widgetMap.get(i + 1);
						}
					}
				}
				RootPanel.get(DROPPABLE_PANEL).remove(selectedWidget);
				if (widgetafterDeletingWdget != null && widgetbeforeDeletingWidget != null) {
					GWTjsplumbSample.gwtjsPlumbDemo(widgetbeforeDeletingWidget,
							widgetafterDeletingWdget);
				}
			}
		}
	};

}
