package com.datasoft.admin.datasoft;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

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

    //Create Inner Class
    private class SynchronizeUser extends AsyncTask<Void, Void, String> {

        //Explicit โยนข้อมูลระหว่าง class
        private Context context;
        private String myUserString, myPasswordString, truePasswordString, nameString;
        private static final String urlJSON = "http://swiftcodingthai.com/6aug/get_user_datasoft.php";
        private boolean statusABoolean = true;

        //Alt + insert = Constructor
        public SynchronizeUser(Context context,
                               String myUserString,
                               String myPasswordString) {
            this.context = context;
            this.myUserString = myUserString;
            this.myPasswordString = myPasswordString;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                e.printStackTrace();
                return null;
                //Exception = error ที่ยอมรับได้
            }

            //return null;
        }   //doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("7AugV1", "JSON ==> " + s);

            try {

                JSONArray jsonArray = new JSONArray(s);
                for (int i=0;i<jsonArray.length();i+=1) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (myUserString.equals(jsonObject.getString("User"))) {

                        truePasswordString = jsonObject.getString("Password");
                        nameString = jsonObject.getString("Name");
                        statusABoolean = false;

                    }   //if
                }   //for

                if (statusABoolean) {
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(context, 4, "ไม่มี User นี้", "ไม่มี " + myUserString + "ใน ฐานข้อมูล");
                } else if (passwordString.equals(truePasswordString)) {
                    //Password True
                    Toast.makeText(context, "Welcome " + nameString, Toast.LENGTH_SHORT).show();
                } else {
                    //Password False
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(context, 4, "Password False", "Please Try Again Password False");
                }

            } catch (Exception e) {
                //เมื่อไหร่ที่ error ให้ทำการ print error
                e.printStackTrace();
            }

        }   //onPost

    }   //SynUser Class


    public void clickSighIn(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (userString.equals("")  ||  passwordString.equals("")) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, 3, "Have Space", "Please Fill All Every Blank");
        } else {

            //Call SynUser
            SynchronizeUser synchronizeUser = new SynchronizeUser(this, userString, passwordString);
            synchronizeUser.execute();

        }

    }   //clickSignIn


    public void clickSignUpMain(View view) {
        //ไปทำ onClick->clickSignUpMain ก่อน
        //เคลื่อนย้าย MainActivity -> SignUpActivity
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

}   //Main Class
