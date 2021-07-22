package com.swlc.javasnakegame.util;

import java.awt.*;

/**
 * @author hp
 */

/**
 * this util class manage grid system and position of jpanels
 */
public class GridBagManager extends GridBagConstraints {
    public GridBagManager(int x, int y) {
        this.gridx = x;
        this.gridy = y;
    }

    public GridBagManager(int x, int y, int width, int height) {
        this(x, y);
        this.gridwidth = width;
        this.gridheight = height;
    }
}
