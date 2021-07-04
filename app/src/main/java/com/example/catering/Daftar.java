package com.example.catering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Daftar extends AppCompatActivity {

    EditText edtNama, edtUsername, edtEmail, edtPassword;

    FloatingActionButton fab;

    String name,username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        edtNama = findViewById(R.id.edNama);
        edtUsername = findViewById(R.id.edUser);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPassword);
        fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = edtNama.getText().toString();
                username = edtUsername.getText().toString();
                password = edtPassword.getText().toString();

                if (edtNama.getText().toString().isEmpty() ||
                        edtUsername.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty())
                {
                    Snackbar.make(view, "Data cannot be empty!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                        Toast.makeText(getApplicationContext(), "Registered Successfully!",
                                Toast.LENGTH_LONG).show();

                        Bundle b = new Bundle();
                        b.putString("a", name.trim());
                        b.putString("b", username.trim());
                        b.putString("c", password.trim());

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtras(b);
                        startActivity(i);
                }
            }
        });
    }
}