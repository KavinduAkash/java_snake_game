import com.swlc.javasnakegame.constant.GameConstant;
import com.swlc.javasnakegame.modal.Snake;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author kavindu
 */
public class SnakeTest {

    /**
     * Test case for test applying snake class to singleton design pattern
     */
    @Test
    public void testSnakeSingleton() {
        Snake snakeObj1 = Snake.getInstance();
        Snake snakeObj2 = Snake.getInstance();
        assertEquals(snakeObj1, snakeObj2);
    }

    /**
     * When reset snake X[0] should be 0
     */
    @Test
    public void testSnakeResetX() {
        Snake snakeObj1 = Snake.getInstance();
        snakeObj1.resetSnake();
        assertEquals(0, snakeObj1.getX()[0]);
    }


    /**
     * When reset snake Y[0] should be 0
     */
    @Test
    public void testSnakeResetY() {
        Snake snakeObj1 = Snake.getInstance();
        snakeObj1.resetSnake();
        assertEquals(0, snakeObj1.getY()[0]);
    }

    /**
     * When reset snake body parts should be 1
     */
    @Test
    public void testSnakeResetBodyParts() {
        Snake snakeObj1 = Snake.getInstance();
        snakeObj1.resetSnake();
        assertEquals(1, snakeObj1.getBodyParts());
    }

    /**
     * When reset snake direction should be 'R'
     */
    @Test
    public void testSnakeResetDirection() {
        Snake snakeObj1 = Snake.getInstance();
        snakeObj1.resetSnake();
        assertEquals('R', snakeObj1.getDirection());
    }

    /**
     * Snake move up
     */
    @Test
    public void testSnakeMoveUp() {
        Snake snakeObj1 = Snake.getInstance();
        int expectedY = snakeObj1.getY()[0] - GameConstant.UNIT_SIZE;
        snakeObj1.setDirection('U');
        snakeObj1.move();
        assertEquals(expectedY, snakeObj1.getY()[0]);
    }

    /**
     * Snake move down
     */
    @Test
    public void testSnakeMoveDown() {
        Snake snakeObj1 = Snake.getInstance();
        int expectedY = snakeObj1.getY()[0] + GameConstant.UNIT_SIZE;
        snakeObj1.setDirection('D');
        snakeObj1.move();
        assertEquals(expectedY, snakeObj1.getY()[0]);
    }

    /**
     * Snake move left
     */
    @Test
    public void testSnakeMoveLeft() {
        Snake snakeObj1 = Snake.getInstance();
        int expectedX = snakeObj1.getX()[0] - GameConstant.UNIT_SIZE;
        snakeObj1.setDirection('L');
        snakeObj1.move();
        assertEquals(expectedX, snakeObj1.getX()[0]);
    }

    /**
     * Snake move right
     */
    @Test
    public void testSnakeMoveRight() {
        Snake snakeObj1 = Snake.getInstance();
        int expectedX = snakeObj1.getX()[0] + GameConstant.UNIT_SIZE;
        snakeObj1.setDirection('R');
        snakeObj1.move();
        assertEquals(expectedX, snakeObj1.getX()[0]);
    }

}
