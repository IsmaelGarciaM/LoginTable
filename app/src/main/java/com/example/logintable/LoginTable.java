package com.example.logintable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.logintable.Controller.ILoginMvc;
import com.example.logintable.Controller.LogInTable_Controller;

/**
 * @autor: Ismael Garcia
 * @version: 1.0
 * Class that checks a login with specific business rules
 */
public class LoginTable extends AppCompatActivity {

    private ILoginMvc loginMvc;
    //private LogInTable_Controller LogInTableControler;
    private EditText edtUser;
    private EditText edtPass;
    private Button btnOk;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_table);

        loginMvc = new LogInTable_Controller();
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnOk = (Button) findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String passw = edtPass.getText().toString();

                //Check if password or user is null or empty
                if(user.isEmpty() || passw.isEmpty())
                    Toast.makeText(LoginTable.this, getResources().getString(R.string.dataEmpty), Toast.LENGTH_LONG);

                else{
                    //Check if password meets business rules
                    int result = loginMvc.validateCredentials(user, passw);
                    switch (result){
                        case LogInTable_Controller.PASSWORD_DIGIT:
                            Toast.makeText(LoginTable.this, getResources().getString(R.string.passwordDigit), Toast.LENGTH_SHORT).show();
                            break;
                        case LogInTable_Controller.PASSWORD_CASE:
                            Toast.makeText(LoginTable.this, getResources().getString(R.string.passwordCase), Toast.LENGTH_SHORT).show();
                            break;
                        case LogInTable_Controller.PASSWORD_LENGTH:
                            Toast.makeText(LoginTable.this, getResources().getString(R.string.passwordLength), Toast.LENGTH_SHORT).show();
                            break;
                        case LogInTable_Controller.OK:
                            //Start
                            break;


                    }
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetValues();

            }
        });


    }


    /**
     * Method to clear fields
     */
    private void resetValues() {
        edtUser.setText("");
        edtPass.setText("");
    }
}
