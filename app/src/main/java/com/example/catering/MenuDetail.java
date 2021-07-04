package com.example.catering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.jar.JarFile;

public class MenuDetail extends AppCompatActivity {

    EditText edtAlamat, edtTanggal, edtJam, edtJumlah;
    Button btnConfirm;
    DatabaseReference database;
    String Alamat, Tanggal, Jam, Jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        edtAlamat = findViewById(R.id.edAlamat);
        edtTanggal = findViewById(R.id.edTanggal);
        edtJam = findViewById(R.id.edJam);
        edtJumlah = findViewById(R.id.edJumlah);
        btnConfirm = findViewById(R.id.btConfirm);

        database = FirebaseDatabase.getInstance().getReference();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(edtAlamat.getText().toString().isEmpty()) && !(edtJam.getText().toString().isEmpty())
                        && !(edtTanggal.getText().toString().isEmpty()) && !(edtJumlah.getText().toString().isEmpty())) {
                    Alamat = edtAlamat.getText().toString();
                    Tanggal = edtTanggal.getText().toString();
                    Jam = edtJam.getText().toString();
                    Jumlah = edtJumlah.getText().toString();

                    confirmMenu(new Pesanan(Alamat, Tanggal, Jam, Jumlah));

                    Intent i = new Intent(getApplicationContext(), MainMenu.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MenuDetail.this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void confirmMenu(Pesanan psn) {
        database.child("Pesanan").push().setValue(psn).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MenuDetail.this, "Data sukses ditambahkan", Toast.LENGTH_SHORT).show();

            }
        });
    }
}