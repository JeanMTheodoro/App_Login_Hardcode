package com.example.login_hardcode.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login_hardcode.R;
import com.example.login_hardcode.util.Util;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUser;

    private EditText editTextPassword;

    private Button buttonLogin;

    private Intent intent;

    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intializeComponents();

        buttonLogin.setOnClickListener(this);
    }

    private void intializeComponents() {

        editTextUser = findViewById(R.id.edittex_login_number_usuario);

        editTextPassword = findViewById(R.id.edittext_login_number_password);

        buttonLogin = findViewById(R.id.button_login);
    }

    @Override
    public void onClick(View view) {

        if(isForm()){

            String user = editTextUser.getText().toString();
            String password = editTextPassword.getText().toString();
            openActivity(user, password);

        }else {

            Toast.makeText(getApplicationContext(),R.string.menssage_warning, Toast.LENGTH_LONG).show();
        }
    }

    private void openActivity(String idUser, String password) {

        intent = new Intent(LoginActivity.this, ShowLoginActivity.class);
        bundle = new Bundle();
        bundle.putString(Util.USER, idUser);
        bundle.putString(Util.PASSWORD, password);
        intent.putExtras(bundle);
        startActivity(intent);
    }



    private boolean isForm() {
        boolean formValidade = false;

        if (!TextUtils.isEmpty(editTextUser.getText().toString()) && !TextUtils.isEmpty(editTextPassword.getText().toString()))
            formValidade = true;

        return formValidade;
    }
}