package com.swlc.javasnakegame.controller;

import com.swlc.javasnakegame.constant.GameConstant;
import com.swlc.javasnakegame.modal.Food;
import com.swlc.javasnakegame.modal.Snake;
import com.swlc.javasnakegame.view.SnakeGameView;

import javax.swing.*;
import java.awt.*;

/**
 * @author hp
 */
public class GameBoard extends JPanel implements Runnable {

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

        startGame();

        this.setPreferredSize(new Dimension(GameConstant.SCREEN_WIDTH, GameConstant.SCREEN_HEIGHT));
        this.setFocusable(true);
    }

    private void startGame() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        try {
            while (true) {
                s.move();
                if (!running) {
                    Thread.currentThread().interrupt();
                }
                if (!Thread.currentThread().isInterrupted()) {
                    repaint();
                }
                Thread.sleep(GameConstant.DELAY);
            }
        } catch (InterruptedException ex) {
            System.out.println("GAME OVER");

            repaint();

        }

    }

    public void paintComponent(java.awt.Graphics g) {

        super.paintComponent(g);

        if(running) {
            //apple
            g.setColor(Color.red);
            g.fillOval(f.getAppleX(), f.getAppleY(), GameConstant.UNIT_SIZE, GameConstant.UNIT_SIZE);

            //snake
            for(int i = 0; i < s.getBodyParts(); i++) {
                if(i==0) {
                    g.setColor(Color.orange);
                    g.fillRect(s.getX()[i], s.getY()[i], GameConstant.UNIT_SIZE, GameConstant.UNIT_SIZE);
                } else {
                    g.setColor(Color.YELLOW);
                    g.fillRect(s.getX()[i], s.getY()[i], GameConstant.UNIT_SIZE, GameConstant.UNIT_SIZE);
                }
            }
        }
    }

}
