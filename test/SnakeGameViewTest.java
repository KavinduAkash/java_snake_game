import com.swlc.javasnakegame.constant.GameConstant;
import com.swlc.javasnakegame.modal.Food;
import com.swlc.javasnakegame.modal.Snake;
import com.swlc.javasnakegame.view.SnakeGameView;
import org.junit.Test;

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

}
