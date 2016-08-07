package com.datasoft.admin.datasoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //เอาเมาส์มาชี้แล้วคลิกจะไปที่ from

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText5);

    }   //Main Method

    public void clickSighIn(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (userString.equals("")  ||  passwordString.equals("")) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, 3, "Have Space", "Please Fill All Every Blank");

        } else {

        }

    }   //clickSignIn


    public void clickSignUpMain(View view) {
        //ไปทำ onClick->clickSignUpMain ก่อน
        //เคลื่อนย้าย MainActivity -> SignUpActivity
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

}   //Main Class
