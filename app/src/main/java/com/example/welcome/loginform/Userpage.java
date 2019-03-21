package com.example.welcome.loginform;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Userpage extends AppCompatActivity {
    TextView v;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userpage);
        v=findViewById(R.id.username);

        SharedPreferences sp=getSharedPreferences("myfile",Context.MODE_PRIVATE);
        String display=sp.getString("display","");
        v.setText(display);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //create an menu
        getMenuInflater().inflate(R.menu.menufile,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.logout){
            SharedPreferences sp=getSharedPreferences("yourfile",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.remove("state");

            editor.commit();

            Intent i=new Intent(Userpage.this,MainActivity.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }
}
