package com.migii.view.component.informationPanel.indexPanel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class IndexTreeCellEditor extends AbstractCellEditor implements TreeCellEditor {

    private IndexTreeCellRenderer renderer;
    private JCheckBox checkBox;
    private CellInfo info;

    public IndexTreeCellEditor(){
        renderer = new IndexTreeCellRenderer();
    }

    @Override
    public Component getTreeCellEditorComponent(JTree jTree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        Component component = renderer.getTreeCellRendererComponent(jTree,value,isSelected,expanded,leaf,row,true );
        if(leaf){
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)value;
            info = (CellInfo)treeNode.getUserObject();

            checkBox = (JCheckBox)component;

            ItemListener itemListener = new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent itemEvent) {
                    fireEditingStopped();
                    checkBox.removeItemListener(this);
                }
            };
            checkBox.addItemListener(itemListener);
        }
        return component;
    }

    @Override
    public Object getCellEditorValue() {
        info.setChecked(checkBox.isSelected());
        return info;
    }

    @Override
    public boolean isCellEditable(EventObject eventObject) {
        if (!(eventObject instanceof MouseEvent)) return false;
        MouseEvent mouseEvent = (MouseEvent)eventObject;
        JTree tree = (JTree)eventObject.getSource();

        TreePath path = tree.getPathForLocation(mouseEvent.getX(),mouseEvent.getY());

        if(path == null) return false;

        Object lastComponent = path.getLastPathComponent();

        if (lastComponent == null) return false;
        DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode)lastComponent;
        return treeNode.isLeaf();
    }
}
