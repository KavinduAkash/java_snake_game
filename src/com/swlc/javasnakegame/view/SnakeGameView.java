package com.swlc.javasnakegame.view;

import com.swlc.javasnakegame.controller.GameBoard;
import com.swlc.javasnakegame.controller.ScorePanel;
import com.swlc.javasnakegame.modal.Food;
import com.swlc.javasnakegame.modal.Snake;
import com.swlc.javasnakegame.util.GridBagManager;

import javax.swing.*;
import java.awt.*;

/**
 * @author hp
 */
public class SnakeGameView extends JFrame{

    private Snake snake;
    private Food food;
    private GameBoard gameBoard;
    private ScorePanel scorePanel;

    public SnakeGameView() {
        super("Java Snake Game");
        viewBuild();
    }

    private void viewBuild() {

        setLayout(new GridBagLayout());

        gameBoard = new GameBoard();
        scorePanel = new ScorePanel();

        add(gameBoard, new GridBagManager(0, 10, 8, 8));
        add(scorePanel, new GridBagManager(0, 0, 8, 1));

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
