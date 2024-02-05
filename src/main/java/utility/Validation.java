package utility;

public class Validation {

    public static boolean isValidName(String name) {
        String pattern = "[a-zA-Z]+";
        return name.matches(pattern);

    }


    public static boolean isValidPassword(String password) {
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#!%&*])[A-Za-z0-9@#!%&*]{8,10}$";
        return password.matches(pattern);
    }

    public static boolean isValidEmail(String email) {
        String pattern = "^(.+)@(\\S+)$";
        return email.matches(pattern);
    }

    public static boolean isValidUsername(String username) {
        String pattern = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        return username.matches(pattern);
    }

    public static boolean isValidnatioalCode(String nationalCode) {

        String pattern = "[0-9]{10}";
        return nationalCode.matches(pattern);

    }


}


