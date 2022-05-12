
public class Main {

    public static void main(String[] args) {
        LoginTest login = new LoginTest();
        RegisterTest register = new RegisterTest();
        WishListTest wishList = new WishListTest();
        login.loginWithValidCredentialsTest();
        login.loginWithInvalidEmail();
        login.loginWithInvalidPasswordTest();
        login.loginWithoutCredentialsTest();
        register.validRegisterTest();
        register.registerWithInvalidEmail();
        register.registerWithBlankSpacesOnMandatoryFields();
        wishList.addToWishListTest();
    }

}
