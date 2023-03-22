public class Register {
    public Boolean CheckBlank(String firstname, String lastname, String dateOfbirth, String password, String email, String phone) {
        if (firstname.isEmpty() || lastname.isEmpty() || dateOfbirth.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean CheckExistUser(String firstname, String lastname, String dateOfbirth, String password, String email, String phone) {
        if (firstname.equals("Lê Quốc") || lastname.equals("Bảo") || dateOfbirth.equals("07/06/1997")
                || password.equals("lequocbao") || email.equals("bao0761997@gmail.com") || phone.equals("0981644378")) {
            return false;
        }
        return true;
    }

    public boolean IsPasswordTooShort(String password) {
        if (password.length() < 5) {
            System.out.println("Mật khẩu quá ngắn (tối thiểu 5 ký tự).");
            return false;
        }
        return true;
    }
}
