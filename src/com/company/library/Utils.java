package com.company.library;

import javax.swing.*;
import java.net.URL;

public class Utils {
    public static ImageIcon createIcon(String path) {
        URL url = System.class.getResource(path);

        if(url == null) {
            System.err.println("Unable to load image: " + path);
        }

        ImageIcon icon = new ImageIcon(url);

        return icon;
    }
}
