package com.example.jenniferhott_leitsch.jhott_leitsch_lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String errMessageLogin = "Incorrect Login/Password";

    public enum LogInSuccess{
        login(1),
        password(2),
        success(0);

        private int intValue;

        LogInSuccess(int value){
            intValue = value;
        }

        public int getIntValue(){
            return intValue;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textLogin = (TextView) findViewById(R.id.idLoginText);
        final TextView textPassword = (TextView) findViewById(R.id.idPasswordTxt);
        Button btnLogin = (Button) findViewById(R.id.btn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toastError = null;

                switch (CheckLogin(textLogin.getText().toString(),textPassword.getText().toString())){
                    case login:
                    case password:
                        toastError.makeText(getApplicationContext(),errMessageLogin, toastError.LENGTH_SHORT).show();
                        textLogin.requestFocus();
                        break;


                        //toastError.makeText(getApplicationContext(),errMessagePassword, toastError.LENGTH_SHORT).show();
                        //textPassword.requestFocus();
                        //break;
                    default:
                        startActivity(new Intent(MainActivity.this, MainClassList.class));
                        break;
                }
            }
        });

    }

    LogInSuccess CheckLogin(String textLogin, String textPassword){
        String holdLogin = "Jenn";
        String holdPass = "password";

        if(!(holdLogin.equals(textLogin))){
           return LogInSuccess.login;
       }
        if (!(holdPass.equals(textPassword))){
            return LogInSuccess.password;
        }

        return LogInSuccess.success;
    }
}
