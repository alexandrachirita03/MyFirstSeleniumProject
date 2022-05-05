
public class Main {

    public static void main(String[] args) {
        LoginTest login = new LoginTest();
        RegisterTest register = new RegisterTest();
        login.loginWithValidCredentialsTest();
        login.loginWithInvalidEmail();
        login.loginWithInvalidPasswordTest();
        login.loginWithoutCredentialsTest();
        register.validRegisterTest();
    }

}
