package com.swlc.javasnakegame.view;

import com.swlc.javasnakegame.constant.GameConstant;
import com.swlc.javasnakegame.controller.GameBoard;
import com.swlc.javasnakegame.controller.ScorePanel;
import com.swlc.javasnakegame.modal.Food;
import com.swlc.javasnakegame.modal.Snake;
import com.swlc.javasnakegame.util.GridBagManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author hp
 */
public class SnakeGameView extends JFrame implements KeyListener {

    private Snake snake;
    private Food food;
    private GameBoard gameBoard;
    private ScorePanel scorePanel;

    public SnakeGameView() {
        super("Java Snake Game");
        viewBuild();
    }

    private void viewBuild() {

        snake = Snake.getInstance();
        food = Food.getInstance();

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
        this.checkApple();
        this.snakeCollision();
        this.checkCollisions();
        this.checkApple();
    }

    public void checkApple() {
        if((snake.getX()[0] == food.getAppleX()) && (snake.getY()[0] == food.getAppleY())) {
            int bodyParts = snake.getBodyParts();
            snake.setBodyParts(bodyParts+1);
            scorePanel.addPoints(1);
            food.newFood();
        }
    }

    private void snakeCollision() {
        for (int i = snake.getBodyParts(); i > 0; i--) {
            if (i > 4
                    && snake.getX()[0] == snake.getX()[i]
                    && snake.getY()[0] == snake.getY()[i]) {

//                gameBoard.running = false;
                this.gameRunningController(false);
            }
        }
    }


    public void checkCollisions() {

        if(gameBoard!=null) {
            //head
            for(int i = snake.getBodyParts(); i<0; i--) {
                if((snake.getX()[0] == snake.getX()[i]) && (snake.getY()[0] == snake.getY()[i])) {
//                    gameBoard.setRunning(false);
                    this.gameRunningController(false);
                }
            }

            //left boarder
            if(snake.getX()[0] < 0) {
//                gameBoard.setRunning(false);
                this.gameRunningController(false);
            }

            //right boarder
            if(snake.getX()[0] >= GameConstant.SCREEN_WIDTH) {
//                gameBoard.running = false;
                this.gameRunningController(false);
            }

            //top boarder
            if(snake.getY()[0] < 0) {
//                gameBoard.running = false;
                this.gameRunningController(false);
            }

            //bottom boarder
            if(snake.getY()[0] >= GameConstant.SCREEN_HEIGHT) {
//                gameBoard.running = false;
                this.gameRunningController(false);
            }

            if(!gameBoard.isRunning()) {
//                gameBoard.running = false;
                this.gameRunningController(false);
            }
        }
    }

    private void gameRunningController(boolean isRunning) {
        gameBoard.setRunning(isRunning);
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public ScorePanel getScorePanel() {
        return scorePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }
}
