package com.example.welcome.loginform;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity  extends AppCompatActivity{

    EditText userid;
    EditText passid;
    Button signid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        userid=findViewById(R.id.username);
        passid=findViewById(R.id.password);
        signid=findViewById(R.id.signup);

        signid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("myfile", Context.MODE_PRIVATE);//mode private is int

                SharedPreferences.Editor editor=sp.edit();
                String username=userid.getText().toString();
                String password=passid.getText().toString();
                editor.putString("user1",username);   //afaile banako userid ra pass that is key....passing key
                editor.putString("pass1",password);
                editor.commit();  //save the file


                Intent i=new Intent(SignupActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
