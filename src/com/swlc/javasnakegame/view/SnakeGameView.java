package com.swlc.javasnakegame.view;

import com.swlc.javasnakegame.controller.GameBoard;

import javax.swing.*;
import java.awt.*;

/**
 * @author hp
 */
public class SnakeGameView extends JFrame{
    public SnakeGameView() {
        super("Java Snake Game");
        viewBuild();
    }

    private void viewBuild() {
        add(new GameBoard());
        prepareWindow();
    }

    private void prepareWindow() {
        this.setTitle("Java Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
