package com.datasoft.admin.datasoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SignUpActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private EditText nameEditText, userEditText, passwordEditText;
    private RadioGroup radioGroup;
    private RadioButton avata0RadioButton, avata1RadioButton,
            avata2RadioButton, avata3RadioButton, avata4RadioButton;
    private String nameString, userString, passwordString, avataString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        userEditText = (EditText) findViewById(R.id.editText2);
        passwordEditText = (EditText) findViewById(R.id.editText3);
        radioGroup = (RadioGroup) findViewById(R.id.ragAvata);
        avata0RadioButton = (RadioButton) findViewById(R.id.radioButton);
        avata1RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        avata2RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        avata3RadioButton = (RadioButton) findViewById(R.id.radioButton4);
        avata4RadioButton = (RadioButton) findViewById(R.id.radioButton5);

        //Radio Controller
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton:
                        avataString = "0";
                        break;
                    case R.id.radioButton2:
                        avataString = "1";
                        break;
                    case R.id.radioButton3:
                        avataString = "2";
                        break;
                    case R.id.radioButton4:
                        avataString = "3";
                        break;
                    case R.id.radioButton5:
                        avataString = "4";
                        break;
                }
            }
        });

    }   //Main Method

    public void ClickSignUpSign(View view) {

        //Get value from Edit Text
        nameString = nameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (nameString.equals("")  ||  userString.equals("")  ||  passwordString.equals("")) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, 0, "มีช่องว่าง", "กรุณากรอกทุกช่อง");
        } else if (avata0RadioButton.isChecked()  ||
                avata1RadioButton.isChecked() ||
                avata2RadioButton.isChecked() ||
                avata3RadioButton.isChecked() ||
                avata4RadioButton.isChecked()) {
            //Have Check
        } else {
            //Un check
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, 1, "ยังไม่ได้เลือก Avata", "กรุณาเลือก Avata ด้วยครับ");
        }

    }   //clickSign

}   //Main Class
