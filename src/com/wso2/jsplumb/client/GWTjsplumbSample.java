/* Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wso2.jsplumb.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.wso2.jsplumb.client.controllers.CustomImageElementDragController;
import com.wso2.jsplumb.client.controllers.CustomImageElementDropControler;
import com.wso2.jsplumb.client.extendedpanels.ExtendedHorizontalPanel;
import com.wso2.jsplumb.client.injectors.ScriptInjectorHelper;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTjsplumbSample implements EntryPoint {

	private static final String CSS_MAINWINDOW = "mainwindow";
	private static final String DROPPABLE_PANEL = "droppablePanel";
	private static final String DRAGGABLE_PANEL = "draggablePanel";
	private static final String BACKGROUND = "background";
	
	private static final int DROPPABLE_HEIGHT = 1000;
	private static final int DROPPABLE_WIDTH = 1400;
	private static final int DRAGGABLE_HEIGHT = 1000;
	private static final int DRAGGABLE_WIDTH = 150;
	
	private static final String STYLE_POSITION = "position";
	private static final String POSITION_RELATIVE = "relative";

	private HorizontalPanel backgroundPanel;
	private VerticalPanel draggablePanel;
	private ExtendedHorizontalPanel droppablePanel;

	private List<Image> draggableWidgetList = new ArrayList<Image>();

	public void onModuleLoad() {
		
		//initializing the panels
		backgroundPanel = new HorizontalPanel(); //background panel in the view, has its child elements horizontally aligned
		draggablePanel = new VerticalPanel();  // left corner droppable widget holding panel, has its child elements vertically aligned
		droppablePanel = new ExtendedHorizontalPanel(); // droppable panel for widgets, has its elements horizontally aligned, extended to add additional capabilities
		
		//setting new to panels
		createNewPanel(backgroundPanel, BACKGROUND, CSS_MAINWINDOW);
		createNewPanel(draggablePanel, DRAGGABLE_PANEL, CSS_MAINWINDOW, DRAGGABLE_WIDTH, DRAGGABLE_HEIGHT, POSITION_RELATIVE );
		createNewPanel(droppablePanel, DROPPABLE_PANEL, CSS_MAINWINDOW, DROPPABLE_WIDTH, DROPPABLE_HEIGHT, POSITION_RELATIVE );
		
		// Create the GWT widgets 
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

		backgroundPanel.add(draggablePanel);//add droppable panel to background panel
		backgroundPanel.add(droppablePanel);//add draggable panel to background panel

		RootPanel.get().add(backgroundPanel);// add the background panel to rootpanel in the view

		//enabling drag and drop
		RootPanel.get(BACKGROUND).getElement().getStyle()
				.setProperty(STYLE_POSITION, POSITION_RELATIVE);
		CustomImageElementDragController dragController = new CustomImageElementDragController(
				RootPanel.get(BACKGROUND), true);
		CustomImageElementDropControler widgetDropController = new CustomImageElementDropControler(
				backgroundPanel, this);
		dragController.registerDropController(widgetDropController);

		// making the widgets draggable 
		for (Image draggableImage : draggableWidgetList) {
			dragController.makeDraggable(draggableImage);
		}
		ScriptInjectorHelper.injectScript();

	}
	
	//JSNI native methods in GWT to call javascript methods in java
	public static native void gwtjsPlumbDemo(String prevElem, String currElem, int elemCount) /*-{
		if (elemCount > 0) {
			$wnd.gwtjsplumbdemo(prevElem, currElem);
		}
	}-*/;

	//JSNI native methods in GWT to call javascript methods in java
	public static native void gwtjsPlumbDemo(String prevElem, String currElem) /*-{
		$wnd.gwtjsplumbdemo(prevElem, currElem);

	}-*/;
	
	private void createNewPanel ( Widget panel, String panelID, String paneltStyle, int panelWidth, int panelHeight, String stylePosition){
		createNewPanel(panel, panelID, paneltStyle);
		panel.setPixelSize(panelWidth, panelHeight);
		panel.getElement().getStyle().setProperty(STYLE_POSITION, stylePosition);
		
	}
	
	private void createNewPanel(Widget panel, String panelID, String paneltStyle){
		panel.getElement().setClassName(paneltStyle);
		panel.getElement().setId(panelID);
		
	}

}
