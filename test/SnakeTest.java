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

}
