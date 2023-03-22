import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestRegister {
    Register register = new Register();

    @Test
    public void testBlank1() {
        boolean result = register.CheckBlank("", "Bảo", "07/06/1997", "lequocbao", "bao0761997@gmail.com", "0981644378");
        assertFalse(result);
    }

    @Test
    public void testBlank2() {
        boolean result = register.CheckBlank("Lê Quốc", "Bảo", "07/06/1997", "lequocbao", "bao0761997@gmail.com", "0981644378");
        assertTrue(result);
    }

    @Test
    public void testBlank3() {
        boolean result = register.CheckBlank("Lê Quốc", "", "07/06/1997", "lequocbao", "bao0761997@gmail.com", "0981644378");
        assertFalse(result);
    }

    @Test
    public void testBlank4() {
        boolean result = register.CheckBlank("Lê Quốc", "Bảo", "", "lequocbao", "bao0761997@gmail.com", "0981644378");
        assertFalse(result);
    }

    @Test
    public void testBlank5() {
        boolean result = register.CheckBlank("Lê Quốc", "Bảo", "07/06/1997", "", "bao0761997@gmail.com", "0981644378");
        assertFalse(result);
    }

    @Test
    public void testBlank6() {
        boolean result = register.CheckBlank("Lê Quốc", "Bảo", "07/06/1997", "lequocbao", "", "0981644378");
        assertFalse(result);
    }

    @Test
    public void testBlank7() {
        boolean result = register.CheckBlank("Lê Quốc", "Bảo", "07/06/1997", "lequocbao", "bao0761997@gmail.com", "");
        assertFalse(result);
    }

    @Test
    public void testExist1() {
        boolean result = register.CheckExistUser("Lê Quốc", "Bảo", "07/06/1997", "lequocbao", "bao0761997@gmail.com", "0981644389");
        assertFalse(result);
    }

    @Test
    public void testExist2() {
        boolean result = register.CheckExistUser("Lê", "Bảo", "07/06/1998", "lequoc", "bao0761998@gmail.com", "09123231312");
        assertFalse(result);
    }

    @Test
    public void testExist3() {
        boolean result = register.CheckExistUser("Lê", "Ân", "07/06/1998", "lequocan", "bao0761998@gmail.com", "0321321321");
        assertTrue(result);
    }

    @Test
    public void testExist4() {
        boolean result = register.CheckExistUser("Lê Quốc", "Ân", "07/06/1997", "lequocbao", "bao0761997@gmail.com", "3231321312");
        assertFalse(result);
    }

    @Test
    public void testExist5() {
        boolean result = register.CheckExistUser("Lê ", "Ân", "07/06/1997", "lequocbao", "bao0761997@gmail.com", "023323111");
        assertFalse(result);
    }

    @Test
    public void testIsPasswordTooShort1() {
        boolean result = register.IsPasswordTooShort("123456");
        assertTrue(result);
    }

    @Test
    public void testIsPasswordTooShort2() {
        boolean result = register.IsPasswordTooShort("123");
        System.out.println("Mật khẩu quá ngắn (tối thiểu 5 ký tự).");
        assertFalse(result);
    }
}