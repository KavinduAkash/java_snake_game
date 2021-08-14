import com.swlc.javasnakegame.constant.GameConstant;
import com.swlc.javasnakegame.modal.Food;
import com.swlc.javasnakegame.modal.Snake;
import com.swlc.javasnakegame.view.SnakeGameView;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * @author hp
 */
public class SnakeGameViewTest {

    /**
     * test game initializing
     */
    @Test
    public void testInitSnakeGame() {
        new SnakeGameView();
    }

    /**
     * test snakes body parts when ate food
     */
    @Test
    public void testCheckAppleSnakeBodyParts() {
        SnakeGameView snakeGameView = new SnakeGameView();
        Snake.getInstance().setBodyParts(1);
        Food.getInstance().setAppleX(GameConstant.UNIT_SIZE);
        Food.getInstance().setAppleY(GameConstant.UNIT_SIZE);
        snakeGameView.checkApple();
        assertNotSame(2, Snake.getInstance().getBodyParts());
    }

    /**
     * test food appearance location after ate
     */
    @Test
    public void testCheckAppleNewApple() {
        SnakeGameView snakeGameView = new SnakeGameView();
        Food.getInstance().setAppleX(GameConstant.UNIT_SIZE);
        Food.getInstance().setAppleY(GameConstant.UNIT_SIZE);
        snakeGameView.checkApple();
        assertNotSame(Snake.getInstance().getX()[0], Food.getInstance().getAppleX());
    }

    /**
     * test snake body collision
     */
    @Test
    public void testSnakeCollision() {
        SnakeGameView snakeGameView = new SnakeGameView();
        Snake instance = Snake.getInstance();

        // body part 1
        instance.getX()[0] = 200;
        instance.getY()[0] = 100;

        // body part 2
        instance.getX()[1] = 225;
        instance.getY()[1] = 100;

        // body part 3
        instance.getX()[2] = 250;
        instance.getY()[2] = 100;

        // body part 4
        instance.getX()[3] = 250;
        instance.getY()[3] = 125;

        // body part 5
        instance.getX()[4] = 225;
        instance.getY()[4] = 125;

        // body part 6
        instance.getX()[5] = 200;
        instance.getY()[5] = 125;

        // body part 7
        instance.getX()[6] = 200;
        instance.getY()[6] = 100;

        instance.setBodyParts(7);

        snakeGameView.check();

        assertEquals(false, snakeGameView.getGameBoard().isRunning());

    }

}
