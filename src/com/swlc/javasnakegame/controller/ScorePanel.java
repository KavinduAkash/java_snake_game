package com.swlc.javasnakegame.controller;

import com.swlc.javasnakegame.constant.GameConstant;

import javax.swing.*;
import java.awt.*;

/**
 * @author hp
 */

/**
 * This class manage score and score panel
 */
public class ScorePanel extends JPanel {
    private final String SCORE_LABEL = "SCORE: ";
    private String score;

    public ScorePanel() {
        setPreferredSize(new Dimension(GameConstant.SCREEN_WIDTH, GameConstant.SCORE_PANEL_HEIGHT));
        setBackground(Color.GRAY);
        score = "0";
    }

    /**
     * this method add points to score
     * @param scorePoints
     */
    public void addPoints(int scorePoints) {
        int old = Integer.parseInt(score);
        old += scorePoints;
        score = old + "";
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Arial Black", Font.BOLD, 20));
        g2.setPaint(new Color(255, 255, 255));
        g2.drawString(SCORE_LABEL, 15, 40);
        g2.setPaint(new Color(51, 51, 48));
        g2.drawString(" " + score, 105, 40);
        g2.setPaint(new Color(51, 51, 48));
        g2.drawString("SNAKE", 180, 40);
        g2.setPaint(new Color(226, 179, 6));
        g2.setFont(new Font("Arial Black", Font.BOLD, 30));
        g2.drawString("GAME", 265, 40);
        ImageIcon icon1 = new ImageIcon("src/com/swlc/javasnakegame/assets/snake1.png");
        ImageIcon icon2 = new ImageIcon(icon1.getImage().getScaledInstance(150, 80, Image.SCALE_DEFAULT));
        icon2.paintIcon(this, g2, 385, 0);
    }

    /**
     * this method reset score panel
     */
    public void reset() {
        score = "0";
        repaint();
    }
}
