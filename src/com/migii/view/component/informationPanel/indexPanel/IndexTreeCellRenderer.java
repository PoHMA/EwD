package com.migii.view.component.informationPanel.indexPanel;

import com.migii.library.Utils;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class IndexTreeCellRenderer implements TreeCellRenderer {

    private JCheckBox leafRenderer;
    private DefaultTreeCellRenderer nonLeafRenderer;

    private Color textForeground;
    private Color textBackground;
    private Color selectionForeground;
    private Color selectionBackground;

    public IndexTreeCellRenderer (){
        leafRenderer = new JCheckBox();
        nonLeafRenderer = new DefaultTreeCellRenderer();

        nonLeafRenderer.setLeafIcon(Utils.createIcon("/com/migii/img/Server16.gif"));
        nonLeafRenderer.setOpenIcon(Utils.createIcon("/com/migii/img/WebComponent16.gif"));
        nonLeafRenderer.setClosedIcon(Utils.createIcon("/com/migii/img/WebComponentAdd16.gif"));

        textForeground = UIManager.getColor("Tree.textForeground");
        textBackground = UIManager.getColor("Tree.textBackground");
        selectionForeground = UIManager.getColor("Tree.selectionForeground");
        selectionBackground = UIManager.getColor("Tree.selectionBackground");

    }

    @Override
    public Component getTreeCellRendererComponent(JTree jTree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if(leaf){
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
            CellInfo info = (CellInfo) node.getUserObject();

            if(selected){
                leafRenderer.setForeground(selectionForeground);
                leafRenderer.setBackground(selectionBackground);
            } else {
                leafRenderer.setForeground(textForeground);
                leafRenderer.setBackground(textBackground);
            }
            leafRenderer.setText(info.toString());
            leafRenderer.setSelected(info.isChecked());
            return leafRenderer;
        } else {
            return nonLeafRenderer.getTreeCellRendererComponent(jTree,value,selected,expanded,leaf,row,hasFocus);
        }
    }
}
