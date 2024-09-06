package com.example.quiz1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class finalPage1 extends AppCompatActivity {
    String senderName, senderEmail, senderContact, senderAddress, senderCountry, receiverName, receiverEmail, receiverContact, receiverAddress, receiverCountry;
    TextView tvSenderName, tvSenderCountry, tvSenderAddress, tvSenderInfo, tvReceiverName, tvReceiverCountry, tvReceiverAddress, tvReceiverInfo;
    FloatingActionButton btnFloat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final_page1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnFloat=findViewById(R.id.btnFloat);
        loadResources();
        printResources();
        btnFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(finalPage1.this,homepage1.class);
                startActivity(i);
                finish();
            }
        });
    }
    public void loadResources(){
        tvSenderName=findViewById(R.id.tvSenderName);
        tvSenderAddress=findViewById(R.id.tvSenderAddress);
        tvSenderCountry=findViewById(R.id.tvSenderCountry);
        tvSenderInfo=findViewById(R.id.tvSenderInfo);
        tvReceiverName=findViewById(R.id.tvReceiverName);
        tvReceiverCountry=findViewById(R.id.tvReceiverCountry);
        tvReceiverAddress=findViewById(R.id.tvReceiverAddress);
        tvReceiverInfo=findViewById(R.id.tvReceiverInfo);
        Intent i = getIntent();
        senderName = i.getStringExtra("sender_username");
        senderEmail = i.getStringExtra("sender_email");
        senderContact = i.getStringExtra("sender_contact");
        senderCountry = i.getStringExtra("sender_country");
        senderAddress = i.getStringExtra("sender_address");
        receiverName = i.getStringExtra("receiver_username");
        receiverEmail = i.getStringExtra("receiver_email");
        receiverContact = i.getStringExtra("receiver_contact");
        receiverAddress = i.getStringExtra("receiver_address");
        receiverCountry = i.getStringExtra("receiver_country");
    }
    public void printResources(){
        tvSenderName.setText(senderName);
        tvSenderInfo.setText(senderContact);
        tvSenderCountry.setText(senderCountry);
        tvSenderAddress.setText(senderAddress);
        tvReceiverName.setText(receiverName);
        tvReceiverInfo.setText(receiverContact);
        tvReceiverAddress.setText(receiverAddress);
        tvReceiverCountry.setText(receiverCountry);
    }
    }