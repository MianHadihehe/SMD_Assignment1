package com.example.quiz1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class homepage1 extends AppCompatActivity {
    EditText etName, etEmail, etContact, etCountry, etAddress;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etName.getText().toString().trim();
                String email=etEmail.getText().toString().trim();
                String contact=etContact.getText().toString();
                String country=etCountry.getText().toString().trim();
                String address=etAddress.getText().toString().trim();
                if(name.isEmpty() || email.isEmpty() || contact.isEmpty() || country.isEmpty() || address.isEmpty()){
                    Toast.makeText(homepage1.this,"All fields must be filled",Toast.LENGTH_SHORT).show();
                    return;
                }
//                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//                    Toast.makeText(homepage1.this,"Email format not correct",Toast.LENGTH_SHORT).show();
//                    return;
//                }
                Intent i = new Intent(homepage1.this,homepage2.class);
                i.putExtra("username",name);
                i.putExtra("email",email);
                i.putExtra("contact",contact);
                i.putExtra("country",country);
                i.putExtra("address",address);
                startActivity(i);
            }
        });
    }
    public void  init(){
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etContact=findViewById(R.id.etContact);
        etCountry=findViewById(R.id.etCountry);
        etAddress=findViewById(R.id.etAddress);
        btnNext=findViewById(R.id.btnNext);
    }
}