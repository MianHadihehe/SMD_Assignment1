package com.example.quiz1;

import android.content.Intent;
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

public class homepage2 extends AppCompatActivity {
    EditText etName, etEmail, etContact, etCountry, etAddress;
    Button btnNext;
    String senderName, senderEmail, senderContact, senderAddress, senderCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("here");
        init();
        loadData();
        System.out.println("here2");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etName.getText().toString().trim();
                String email=etEmail.getText().toString().trim();
                String contact=etContact.getText().toString();
                String country=etCountry.getText().toString().trim();
                String address=etAddress.getText().toString().trim();
                if(name.isEmpty() || email.isEmpty() || contact.isEmpty() || country.isEmpty() || address.isEmpty()){
                    Toast.makeText(homepage2.this,"All fields must be filled",Toast.LENGTH_SHORT).show();
                    return;
                }
//                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//                    Toast.makeText(homepage2.this,"Email format not correct",Toast.LENGTH_SHORT).show();
//                    return;
//                }
                Intent i = new Intent(homepage2.this,finalPage1.class);
                i.putExtra("receiver_username",name);
                i.putExtra("receiver_email",email);
                i.putExtra("receiver_contact",contact);
                i.putExtra("receiver_country",country);
                i.putExtra("receiver_address",address);
                i.putExtra("sender_username",senderName);
                i.putExtra("sender_email",senderEmail);
                i.putExtra("sender_contact",senderContact);
                i.putExtra("sender_country",senderCountry);
                i.putExtra("sender_address",senderAddress);
                System.out.println(senderName+" , "+senderEmail);
                startActivity(i);
            }
        });
    }
    public void init(){
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage2);
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
    public void loadData(){
        Intent i = getIntent();
        senderName = i.getStringExtra("username");
        senderEmail = i.getStringExtra("email");
        senderContact = i.getStringExtra("contact");
        senderAddress = i.getStringExtra("address");
        senderCountry = i.getStringExtra("country");
    }
}