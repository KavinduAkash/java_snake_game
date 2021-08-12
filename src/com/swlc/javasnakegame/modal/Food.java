package com.swlc.javasnakegame.modal;

import com.swlc.javasnakegame.constant.GameConstant;

import java.util.Random;

/**
 * @author hp
 */

/**
 * This class responsible for handle food
 */
public class Food {
    private int appleX;
    private int appleY;
    private static Food food =  new Food();

    private Food() {
    }

    public static Food getInstance() {
        food.newFood();
        return food;
    }

    /**
     * This method use to generate new food and set food location
     * Also, restrict show apple on snake
     */
    public void newFood() {
        Snake snake = Snake.getInstance();
        boolean onSnake = true;
        while(onSnake) {
            onSnake = false;

            Random random = new Random();

            appleX = random.nextInt((int)(GameConstant.SCREEN_WIDTH/GameConstant.UNIT_SIZE)) * GameConstant.UNIT_SIZE;
            appleY = random.nextInt((int)(GameConstant.SCREEN_HEIGHT/GameConstant.UNIT_SIZE)) * GameConstant.UNIT_SIZE;

            for(int i = 0; i<snake.getX().length; i++) {
                if(snake.getX()[i] == appleX && snake.getY()[i] == appleY) {
                    onSnake = true;
                }
            }

        }
    }

    public int getAppleX() {
        return appleX;
    }

    public void setAppleX(int appleX) {
        this.appleX = appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public void setAppleY(int appleY) {
        this.appleY = appleY;
    }
}
