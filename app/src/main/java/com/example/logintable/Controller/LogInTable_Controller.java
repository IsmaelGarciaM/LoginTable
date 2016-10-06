package com.example.logintable.Controller;

import java.util.regex.Pattern;

/**
 * @autor: Ismael Garcia
 * @version: 1.0
 * Class that implements business rules
 * password must have more than eight characters
 * It must contain a capital letter and a tiny letter
 * It must contain a number
 */
public class LogInTable_Controller implements ILoginMvc{

    public static final int OK = 0;
    public static final int PASSWORD_DIGIT = 1;
    public static final int PASSWORD_CASE = 2;
    public static final int PASSWORD_LENGTH = 3;

    /**
     * Method to check the password
     * @param user
     * @param passw String to check if its a valid password
     */

    public int validateCredentials(String user, String passw) {

        if (passw.length() <= 7)
            return PASSWORD_LENGTH;

        if (!Pattern.matches(".*[0-9].*", passw))
            return PASSWORD_DIGIT;

        if (!Pattern.matches(".*[A-Z].*", passw) || !Pattern.matches(".*[a-z].*", passw))
            return PASSWORD_CASE;

        else
            return OK;
    }
}
