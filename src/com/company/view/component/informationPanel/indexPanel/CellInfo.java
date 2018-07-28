package com.company.view.component.informationPanel.indexPanel;

public class CellInfo {
    private String name;
    private int id;
    private boolean checked;

    public CellInfo(String name, int id, boolean checked){
        this.name = name;
        this.id = id;
        this.checked = checked;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
