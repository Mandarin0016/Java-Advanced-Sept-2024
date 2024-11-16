package entities.user;

import static common.SystemErrors.INVALID_PASSWORD;
import static common.SystemErrors.INVALID_USERNAME;

public class UserValidator {

    //Username must be 5 or above characters long and contains at least 1 digit.
    //In case of invalid username, throw IllegalArgumentException with message: Error: Invalid username, make sure the length is bigger than 4 and contains at least 1 digit.
    //Password  must be exactly 6 characters long and contains only digits.
    //In case of invalid password, throw IllegalArgumentException with message: Error: Invalid password, make sure the length is exactly 6 and contains only digits.

    public static void validateUsername(String username) {

        if (username.isBlank() || username.length() < 5 || username.chars().noneMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INVALID_USERNAME);
        }
    }

    // "       "
    // null
    public static void validatePassword(String password) {

        if (password.isBlank() || password.length() != 6 || password.chars().anyMatch(Character::isLetter)) {
            throw new IllegalArgumentException(INVALID_PASSWORD);
        }
    }
}
