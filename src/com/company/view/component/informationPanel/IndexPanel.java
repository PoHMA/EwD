package com.company.view.component.informationPanel;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class IndicePanel extends JPanel {
    private JTree serverTree;

    public IndicePanel(){
        init();
    }

    private void init(){
        setLayout(new BorderLayout());
        serverTree = new JTree(createTree());

        add(new JScrollPane(serverTree),BorderLayout.CENTER);
    }

    private DefaultMutableTreeNode createTree(){
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Servers");

        DefaultMutableTreeNode branch1 = new DefaultMutableTreeNode("USA");

        DefaultMutableTreeNode server1 = new DefaultMutableTreeNode("New");
        DefaultMutableTreeNode server2 = new DefaultMutableTreeNode("New1");

        branch1.add(server1);
        branch1.add(server2);


        DefaultMutableTreeNode branch2 = new DefaultMutableTreeNode("UK");

        DefaultMutableTreeNode server3 = new DefaultMutableTreeNode("New 12");
        DefaultMutableTreeNode server4 = new DefaultMutableTreeNode("New1 123");

        branch2.add(server3);
        branch2.add(server4);

        top.add(branch1);
        top.add(branch2);

        return top;
    }

}
