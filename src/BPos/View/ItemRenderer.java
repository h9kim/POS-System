/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.View;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class ItemRenderer extends BasicComboBoxRenderer {

    public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

        if (value != null) {
            Data item = (Data) value;
            setText(item.getText());
        }

        if (index == -1) {
            Data item = (Data) value;
            setText("" + item.getText());
        }

        return this;
    }
}
