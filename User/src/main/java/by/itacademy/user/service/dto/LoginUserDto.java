package by.itacademy.user.service.dto;

public class LoginUserDto {
    private String mail;
    private String password;

    public LoginUserDto() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
