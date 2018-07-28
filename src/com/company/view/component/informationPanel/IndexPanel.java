package com.company.view.component.informationPanel;

import com.company.library.Utils;
import com.company.view.component.informationPanel.indexPanel.CellInfo;
import com.company.view.component.informationPanel.indexPanel.IndexTreeCellEditor;
import com.company.view.component.informationPanel.indexPanel.IndexTreeCellRenderer;
import com.company.view.component.informationPanel.indexPanel.MessageListener;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

public class IndexPanel extends JPanel {
    private JTree tree;
    private IndexTreeCellEditor treeCellEditor;
    private IndexTreeCellRenderer treeCellRenderer;

    private MessageListener listener;

    public IndexPanel(){
        init();
    }

    private void init(){
        setLayout(new BorderLayout());

        treeCellEditor = new IndexTreeCellEditor();
        treeCellRenderer = new IndexTreeCellRenderer();

        tree = new JTree(createTree());
        tree.setCellEditor(treeCellEditor);
        tree.setCellRenderer(treeCellRenderer);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        createListener();

        add(new JScrollPane(tree),BorderLayout.CENTER);
    }

    private void createListener() {
        treeCellEditor.addCellEditorListener(new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent changeEvent) {
                CellInfo info = (CellInfo)treeCellEditor.getCellEditorValue();
                listener.textEmitted(info.toString());
                //System.out.println(info+": "+info.getId()+"; "+info.isChecked());
            }

            @Override
            public void editingCanceled(ChangeEvent changeEvent) {

            }
        });
    }

    private DefaultMutableTreeNode createTree(){
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Estructuras de Datos");

        DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("Lineales");

        DefaultMutableTreeNode server1 = new DefaultMutableTreeNode(new CellInfo("Lista de Simple Enlace",0,true));
        DefaultMutableTreeNode server2 = new DefaultMutableTreeNode(new CellInfo("Lista Doble Enlace",1,false));

        branch1.add(server1);
        branch1.add(server2);

        DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("No Lineales");

        DefaultMutableTreeNode server3 = new DefaultMutableTreeNode(new CellInfo("Arbol Binario",3,false));
        DefaultMutableTreeNode server4 = new DefaultMutableTreeNode(new CellInfo("Arbol Ternario",4,true));

        branch2.add(server3);
        branch2.add(server4);

        top.add(branch1);
        top.add(branch2);

        return top;
    }

    public void addMessageListener(MessageListener listener){
        this.listener = listener;
    }

}
