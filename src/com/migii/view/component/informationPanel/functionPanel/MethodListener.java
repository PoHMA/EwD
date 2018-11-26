package com.migii.view.component.informationPanel.functionPanel;

import java.util.EventListener;

public interface MethodListener extends EventListener {
     void methodEventOccurred(MethodEvent e);
     void executeActionAddNodeLSE(MethodEvent e);
}
