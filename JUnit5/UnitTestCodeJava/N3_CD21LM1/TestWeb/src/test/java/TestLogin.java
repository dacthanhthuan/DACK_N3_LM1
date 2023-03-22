
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestLogin {
    Login lg = new Login();


    @Test
    public void TestingLogin1() {
        //Empty password
        boolean result = lg.emptyLogin("ann", "");
        assertFalse(result);
    }

    @Test
    public void TestingLogin2() {
        //Empty user
        boolean result = lg.emptyLogin("", "123");
        assertFalse(result);
    }

    @Test
    public void TestingLogin3() {
        boolean result = lg.emptyLogin("an", "123");
        assertTrue(result);
    }

    @Test
    public void TestingLogin4() {
        //user not exist
        boolean result = lg.existUser("an1");
        assertFalse(result);
    }

    @Test
    public void TestingLogin5() {
        //user existed
        boolean result = lg.existUser("an123");
        assertTrue(result);
    }

    @Test
    public void TestingLogin6() {
        //check wrong password
        boolean result = lg.checkPassword("an911", "123");
        assertFalse(result);
    }

    @Test
    public void TestingLogin7() {
        //check correct password
        boolean result = lg.checkPassword("an911", "123456");
        assertTrue(result);
    }

}
