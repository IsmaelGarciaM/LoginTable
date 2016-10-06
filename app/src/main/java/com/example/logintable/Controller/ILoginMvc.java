package com.example.logintable.Controller;

/**
 * Created by usuario on 6/10/16.
 */

/**
 * Interface that connects the driver with the login
 */
public interface ILoginMvc {

    public int validateCredentials(String user, String passw);

}
