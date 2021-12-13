package com.siamsoft.sqlite_cms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Insert extends AppCompatActivity {

    EditText txtname, txtmobile;
    TextView tv;
    String name, mobile;

    UserFunction userFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);

        txtname = findViewById(R.id.et1);
        txtmobile = findViewById(R.id.et2);
        tv = findViewById(R.id.msg);

        userFunction = new UserFunction();

    }

    protected void onStart()
    {super.onStart();}

    public void submit_Click(View view)
    {

        if(!txtname.getText().toString().isEmpty()){
            if(!txtmobile.getText().toString().isEmpty()){
                name = txtname.getText().toString();
                mobile =txtmobile.getText().toString();

                userFunction.insertUserInfo(getApplicationContext(),name,mobile);

                clear();
                startActivity(new Intent(getApplicationContext(),ViewAll.class));

            }
            else {tv.setText("Please Enter Your Mobile Number");}

        }
        else {tv.setText("Please Enter Your Name");}


    }


    private void clear()
    {
        txtname.setText("");
        txtmobile.setText("");

        tv.setText("Suc");
    }

    public void btnShow(View view)
    {
        //userFunction.getAllInfo(getApplicationContext(),"07-11-2014","07-11-564");
        Intent intent = new Intent();
    }

}