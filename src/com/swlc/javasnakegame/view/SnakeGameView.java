package com.swlc.javasnakegame.view;

import com.swlc.javasnakegame.constant.GameConstant;
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

        snake = new Snake();
        food = new Food(snake);

        setLayout(new GridBagLayout());

        gameBoard = new GameBoard(this);
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


    public void check() {
        this.checkCollisions();
    }

    public void checkCollisions() {

        if(gameBoard!=null) {
            //head
            for(int i = snake.getBodyParts(); i<0; i--) {
                if((snake.getX()[0] == snake.getX()[i]) && (snake.getY()[0] == snake.getY()[i])) {
                    gameBoard.running = false;
                }
            }

            //left boarder
            if(snake.getX()[0] < 0) {
                gameBoard.running = false;
            }

            //right boarder
            if(snake.getX()[0] > GameConstant.SCREEN_WIDTH) {
                gameBoard.running = false;
            }

            //top boarder
            if(snake.getY()[0] < 0) {
                gameBoard.running = false;
            }

            //bottom boarder
            if(snake.getY()[0] > GameConstant.SCREEN_HEIGHT) {
                gameBoard.running = false;
            }

            if(!gameBoard.running) {
                gameBoard.running = false;
            }
        }
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }
}
