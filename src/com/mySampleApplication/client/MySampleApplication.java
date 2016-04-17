package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

    /**
     * This is the entry point method.
     */
    VerticalPanel buttonsPanel;
    public void onModuleLoad() {
        VerticalPanel root = new VerticalPanel();
        root.setSize("900","1810");

        HorizontalPanel toolbar = new HorizontalPanel();
        toolbar.setHeight("50px");
        toolbar.addStyleName("toolbar");

        root.add(toolbar);

        buttonsPanel = new VerticalPanel();
        Button engagePopup = new Button("\\/");
        buttonsPanel.add(engagePopup);

        engagePopup.addClickHandler(new ClickHandler() {
            PopupPanel popupPanel;
            @Override
            public void onClick(ClickEvent event) {
                if(popupPanel == null) {
                    popupPanel = new PopupPanel();
                    VerticalPanel innerPanel = new VerticalPanel();

                    for (int i = 0; i < 10; i++) {
                        innerPanel.add(new Button(String.valueOf(i) + "//////////////"));
                    }
                    popupPanel.add(innerPanel);
                    popupPanel.show();
                    buttonsPanel.add(popupPanel);
                }else if (popupPanel.isVisible()){
                    popupPanel.setVisible(false);
                    buttonsPanel.remove(popupPanel);
                }
                else {
                    popupPanel.setVisible(true);
                    buttonsPanel.add(popupPanel);
                }
            }
        });
        toolbar.add(buttonsPanel);

        HorizontalPanel table = new HorizontalPanel();
        table.setHeight("1750px");
        table.addStyleName("table");

        Button button = new Button("test");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {

            }
        });

        root.add(table);

        RootPanel.get("slot1").add(root);
    }
}
