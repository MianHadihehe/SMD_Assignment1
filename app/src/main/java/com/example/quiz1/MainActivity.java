package com.example.quiz1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView logoImage = findViewById(R.id.mainLogo);

        Animation translateAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.file);
        logoImage.startAnimation(translateAnimation);
        new Handler().postDelayed(
                new Runnable(){
                    @Override
                    public void run() {
                        Intent i = new Intent(MainActivity.this, homepage1.class);
                        startActivity(i);
                        finish();
                    }
                }, 5000
        );
    }

}