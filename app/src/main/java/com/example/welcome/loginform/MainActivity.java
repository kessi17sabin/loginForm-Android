package com.example.welcome.loginform;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText userid;
    EditText passid;
    Button loginid;
    Button signid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userid=findViewById(R.id.username);
        passid=findViewById(R.id.password);
        loginid=findViewById(R.id.login);
        signid=findViewById(R.id.signup);


        //adding text listner
        userid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               loginid.setEnabled(!userid.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        loginid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = userid.getText().toString();
                String password = passid.getText().toString();
                SharedPreferences sp = getSharedPreferences("myfile", Context.MODE_PRIVATE);
                String myuser = sp.getString("user1", null);
                String mypass = sp.getString("pass1", null);

                if (myuser.equals(username) && mypass.equals(password)) {
                    Toast.makeText(MainActivity.this, "login successfull", Toast.LENGTH_SHORT).show();
                    //to compare the file for session
                    SharedPreferences sp1=getSharedPreferences("yourfile",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1=sp1.edit();
                    editor1.putBoolean("state",true);
                    editor1.commit();

                    //to show the file
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("display",myuser);
                    editor.commit();

                    Intent i=new Intent(MainActivity.this,Userpage.class);

                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "login failed", Toast.LENGTH_SHORT).show();

                }
            }
        });


        signid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sp=getSharedPreferences("yourfile",Context.MODE_PRIVATE);
        boolean state=sp.getBoolean("state",false);
        if (state){
            Intent i=new Intent(MainActivity.this,Userpage.class);
            startActivity(i);
        }
    }
}


//oncreat():