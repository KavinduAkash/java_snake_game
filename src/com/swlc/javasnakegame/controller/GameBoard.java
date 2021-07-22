package com.swlc.javasnakegame.controller;

import com.swlc.javasnakegame.constant.GameConstant;
import com.swlc.javasnakegame.modal.Food;
import com.swlc.javasnakegame.modal.Snake;
import com.swlc.javasnakegame.view.SnakeGameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author hp
 */
public class GameBoard extends JPanel {

    private Snake s;
    private Food f;
    private SnakeGameView sv;
    private Thread thread;
    public boolean running;

    public GameBoard(SnakeGameView g) {

        sv = g;
        s = g.getSnake();
        f = g.getFood();

        setBackground(Color.darkGray);
        setBorder(BorderFactory.createMatteBorder(
                2, 2, 2, 2, Color.black));

        this.setPreferredSize(new Dimension(GameConstant.SCREEN_WIDTH, GameConstant.SCREEN_HEIGHT));
        this.setFocusable(true);
    }
}
