package com.company.view.component.informationPanel.methodPanel;

import java.util.EventListener;

public interface MethodListener extends EventListener {
     void methodEventOccurred(MethodEvent e);
     void executeActionAddNodeLSE(MethodEvent e);
}
