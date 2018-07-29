/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.helper;

import java.awt.Container;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

/**
 *
 * @author mover
 */
public class ScrollBarOrientation {

    private static ScrollBarOrientation instance;
    public ScrollBarOrientation() {
    }
    
    public static ScrollBarOrientation getInstance(){
        if(instance == null){
            instance = new ScrollBarOrientation();
        }
        return instance;
    }
    
    

    public void initVerticalScrollBar(JScrollPane jScrollPane) {

        jScrollPane.setComponentZOrder(jScrollPane.getVerticalScrollBar(), 0);
        jScrollPane.setComponentZOrder(jScrollPane.getViewport(), 1);
        jScrollPane.getVerticalScrollBar().setOpaque(false);

        //jScrollPane1
        jScrollPane.setLayout(new ScrollPaneLayout() {
            @Override
            public void layoutContainer(Container parent) {
                JScrollPane scrollPane = (JScrollPane) parent;

                Rectangle availR = scrollPane.getBounds();
                availR.x = availR.y = 0;

                Insets parentInsets = parent.getInsets();
                availR.x = parentInsets.left;
                availR.y = parentInsets.top;
                availR.width -= parentInsets.left + parentInsets.right;
                availR.height -= parentInsets.top + parentInsets.bottom;

                Rectangle vsbR = new Rectangle();
                vsbR.width = 12;
                vsbR.height = availR.height;
                vsbR.x = availR.x + availR.width - vsbR.width;
                vsbR.y = availR.y;

                if (viewport != null) {
                    viewport.setBounds(availR);
                }
                if (vsb != null) {
                    vsb.setVisible(true);
                    vsb.setBounds(vsbR);
                }
            }
        });
        jScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI());

    }

}
