package com.example.catering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername,edtPassword;
    Button btnLogin,btnDaftar;
    String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edUser);
        edtPassword = findViewById(R.id.edPassword);
        btnDaftar = findViewById(R.id.btRegister);
        btnLogin = findViewById(R.id.btLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle b = getIntent().getExtras();
                username = b.getString("b");
                password = b.getString("c");

                if (edtUsername.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Username or Password Cannot be Empty", Toast.LENGTH_LONG).show();
                } else if (edtUsername.getText().toString().equals(username) && edtPassword.getText().toString().equals(password)) {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), MainMenu.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view1) {
                Intent i = new Intent(getApplicationContext(), Daftar.class);
                startActivity(i);
            }
        });
    }
}