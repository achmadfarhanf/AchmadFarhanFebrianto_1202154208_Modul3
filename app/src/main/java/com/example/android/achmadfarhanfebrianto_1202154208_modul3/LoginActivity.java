package com.example.android.achmadfarhanfebrianto_1202154208_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText mUsername;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.pass);
    }

    public void Login(View view) {   Intent intent = new Intent(this, MainActivity.class);//Method onclick

        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        //Jika if berhasil dimasukan maka akan melanjutkan activity
        if ((username.equals("EAD")) && (password.equals("MOBILE")) ) {//Username EAD dan Password MOBILE
            startActivity(intent);//untuk menjalankan activity
            Toast toast = Toast.makeText(this, "Selamat Anda Sudah Berhasil Masuk", Toast.LENGTH_LONG);
            toast.show();
        //Jika yang dimasukan salah maka akan muncul toast seperti dibawah ini
        } else {
            Toast toast = Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_LONG);
            toast.show();}
    }

}

