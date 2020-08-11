package com.example.login_hardcode.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_hardcode.R;
import com.example.login_hardcode.util.Util;

public class ShowLoginActivity extends AppCompatActivity {

    private Intent intent;

    private Bundle bundle;

    private TextView textLogin;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textLogin = findViewById(R.id.text_message_login);

        intent = getIntent();

        bundle = intent.getExtras();

        String userId = bundle.getString(Util.USER);
        String password = bundle.getString(Util.PASSWORD);

        showMessageLogin(userId, password);
    }

    private void showMessageLogin(String userId, String password) {

        if(userId.equals(Util.IDUSER) && password.equals(encryptPassword(userId))){

            textLogin.setText(Util.LOGINOK);

        }else {

            textLogin.setText(Util.ERROR);

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home) {

            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public String encryptPassword(String password){

        String word = "";

        for(int i = password.length() - 1; i >=0; i-- ){

            word = word + password.charAt(i);
        }

        return word;
    }
}