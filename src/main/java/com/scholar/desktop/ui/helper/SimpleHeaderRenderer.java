/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.scholar.desktop.ui.helper;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mover
 */
public class SimpleHeaderRenderer extends JLabel implements TableCellRenderer {

    public SimpleHeaderRenderer() {
        setPreferredSize(new Dimension(100, 30));
        
        setBorder(BorderFactory.createEmptyBorder());
        setOpaque(true);
         
        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText("  "+value.toString());
        return this;
    }
}
