package com.swlc.javasnakegame.controller;

import com.swlc.javasnakegame.constant.GameConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author hp
 */
public class GameBoard extends JPanel {
    public GameBoard() {
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createMatteBorder(
                2, 2, 2, 2, Color.black));

        this.setPreferredSize(new Dimension(GameConstant.SCREEN_WIDTH, GameConstant.SCREEN_HEIGHT));
        this.setFocusable(true);
    }
}
