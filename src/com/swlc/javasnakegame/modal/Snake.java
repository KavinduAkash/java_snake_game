package com.swlc.javasnakegame.modal;

import com.swlc.javasnakegame.constant.GameConstant;

/**
 * @author hp
 */

/**
 * This class responsible for handle snake
 */
public class Snake {

    static final int GAME_UNITS = (GameConstant.SCREEN_HEIGHT * GameConstant.SCREEN_HEIGHT)/GameConstant.UNIT_SIZE;

    int x[] = new int[GAME_UNITS];
    int y[] = new int[GAME_UNITS];

    int bodyParts = 1;
    char direction = 'R';

    /**
     * This method use to handle snake direction and moving
     *
     * Direction keys
     * U = up
     * D = down
     * L = left
     * R = right
     */
    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
            switch (direction) {
                case 'U':
                    y[0] = y[0] - GameConstant.UNIT_SIZE;
                    break;
                case 'D':
                    y[0] = y[0] + GameConstant.UNIT_SIZE;
                    break;
                case 'L':
                    x[0] = x[0] - GameConstant.UNIT_SIZE;
                    break;
                case 'R':
                    x[0] = x[0] + GameConstant.UNIT_SIZE;
                    break;
            }
    }

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }

    public int getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(int bodyParts) {
        this.bodyParts = bodyParts;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    /**
     * This method use to reset snake values when play again
     */
    public void resetSnake() {
        x[0] = 0;
        y[0] = 0;
        bodyParts = 1;
        direction = 'R';
    }

}
