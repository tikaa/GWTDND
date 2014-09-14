package com.wso2.jsplumb.client.extendedpanels;

import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ExtendedHorizontalPanel extends Composite implements HasWidgets, HasAllKeyHandlers {

    private VerticalPanel fVerticalPanel;
    private FocusPanel fFocusPanel;

    public ExtendedHorizontalPanel() {
        fVerticalPanel = new VerticalPanel();
        fFocusPanel = new FocusPanel();
        fFocusPanel.setWidget(fVerticalPanel);
        initWidget(fFocusPanel);
    }

    @Override
    public void add(Widget w) {
        fVerticalPanel.add(w);
    }

    @Override
    public void clear() {
        fVerticalPanel.clear();
    }


    @Override
    public boolean remove(Widget w) {
        return fVerticalPanel.remove(w);
    }


    @Override
    public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
        return fFocusPanel.addKeyDownHandler(handler);
    }

    @Override
    public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
        return fFocusPanel.addKeyPressHandler(handler);
    }

    @Override
    public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        // TODO Auto-generated method stub

    }

    @Override
    public java.util.Iterator<Widget> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}