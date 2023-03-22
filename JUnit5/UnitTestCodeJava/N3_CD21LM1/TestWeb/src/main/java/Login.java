public class Login {
    public boolean emptyLogin(String username, String password) {
        //Kiểm tra không được để trống
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean existUser(String username) {
        //Kiểm tra tồn tại của user
        //username : an123
        if (username != "an123") {
            return false;
        }
        return true;
    }

    boolean checkPassword(String username, String password) {
        //Kiểm tra sai mật khẩu
        //username : ani11
        //password : 123456
        if (username.equals("an911") && password.equals("123456")) {
            return true;
        }
        return false;
    }
}
