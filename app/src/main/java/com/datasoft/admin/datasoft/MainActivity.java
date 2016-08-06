package com.datasoft.admin.datasoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //เอาเมาส์มาชี้แล้วคลิกจะไปที่ from
    }   //Main Method

    public void clickSignUpMain(View view) {
        //ไปทำ onClick->clickSignUpMain ก่อน
        //เคลื่อนย้าย MainActivity -> SignUpActivity
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

}   //Main Class
