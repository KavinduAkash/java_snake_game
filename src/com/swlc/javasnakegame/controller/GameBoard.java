package com.swlc.javasnakegame.controller;

import com.swlc.javasnakegame.constant.GameConstant;
import com.swlc.javasnakegame.modal.Food;
import com.swlc.javasnakegame.modal.Snake;
import com.swlc.javasnakegame.view.SnakeGameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author hp
 */
public class GameBoard extends JPanel implements Runnable, ActionListener {

    private Snake s;
    private Food f;
    private SnakeGameView sv;
    private Thread thread;
    private boolean running;

    public GameBoard(SnakeGameView g) {

        sv = g;
        s = g.getSnake();
        f = g.getFood();

        setBackground(Color.darkGray);
        setBorder(BorderFactory.createMatteBorder(
                2, 2, 2, 2, Color.black));

        startGame();

        this.setPreferredSize(new Dimension(GameConstant.SCREEN_WIDTH, GameConstant.SCREEN_HEIGHT));
        this.addKeyListener(g);
        this.addKeyListener(new GameBoard.MyKeyAdapter());
        this.setFocusTraversalKeysEnabled(false);
        this.setFocusable(true);
    }

    public void startGame() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        try {
            while (true) {
                s.move();
                sv.check();
                if (!running) {
                    thread.currentThread().interrupt();
                }
                if (!thread.currentThread().isInterrupted()) {
                    repaint();
                }
                thread.sleep(GameConstant.DELAY);
            }
        } catch (InterruptedException ex) {
            repaint();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s.move();
        sv.check();
        repaint();
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
        } else {
            gameOver(g);
        }
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(s.getDirection() != 'R') {
//                        direction = 'L';
                        s.setDirection('L');
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(s.getDirection() != 'L') {
//                        direction = 'R';
                        s.setDirection('R');
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(s.getDirection() != 'D') {
//                        direction = 'U';
                        s.setDirection('U');
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(s.getDirection() != 'U') {
//                        direction = 'D';
                        s.setDirection('D');
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    if(!running) {
                        s.resetSnake();
                        sv.getScorePanel().reset();
                        running = true;
                        startGame();
                    }
                    break;
            }
        }
    }

    public void gameOver(Graphics g) {

        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman", Font.BOLD, 70));
        FontMetrics metrics2 =  getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (GameConstant.SCREEN_WIDTH - metrics2.stringWidth("GAME OVER"))/2, GameConstant.SCREEN_HEIGHT/2);


        ImageIcon icon1 = new ImageIcon("src/com/swlc/javasnakegame/assets/snake2.png");
        ImageIcon icon2 = new ImageIcon(icon1.getImage().getScaledInstance(150, 80, Image.SCALE_DEFAULT));
        icon2.paintIcon(this, g, 200, 100);

        g.setColor(Color.white);
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));
        FontMetrics metrics3 =  getFontMetrics(g.getFont());
        g.drawString("Press enter to play again!", (GameConstant.SCREEN_WIDTH - metrics3.stringWidth("GAME OVER"))/2 - 50, GameConstant.SCREEN_HEIGHT/2 + 50);

    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
