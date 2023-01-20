package com.radustan.jocuriinteractive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnCautaSaInveti = findViewById(R.id.btnCautaSaInveti);
        Button btnFormeGeometrice = findViewById(R.id.btnFormeGeometrice);
        Button btnBanii = findViewById(R.id.btnBanii);
        Button btnVBcorect = findViewById(R.id.brnVBcorect);
        Button btnHarta = findViewById(R.id.btnHarta);


        btnFormeGeometrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFormeGeometrice();
            }
        });


        ///fac butonul sa isi schimbe dimensiunile dupa rezolutia device-ului
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightbtn = displayMetrics.heightPixels;
        int widthbtn = displayMetrics.widthPixels;
        btnCautaSaInveti.getLayoutParams().width=widthbtn / (25/10);
        btnCautaSaInveti.getLayoutParams().height=heightbtn / 20;

        btnFormeGeometrice.getLayoutParams().width=widthbtn / (25/10);
        btnFormeGeometrice.getLayoutParams().height=heightbtn / 20;

        btnBanii.getLayoutParams().width=widthbtn / (25/10);
        btnBanii.getLayoutParams().height=heightbtn / 20;

        btnVBcorect.getLayoutParams().width=widthbtn / (25/10);
        btnVBcorect.getLayoutParams().height=heightbtn / 20;

        btnHarta.getLayoutParams().width=widthbtn / (25/10);
        btnHarta.getLayoutParams().height=heightbtn / 20;


    }

    public void openFormeGeometrice() {
        Intent intent = new Intent(this, activity_quiz1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}


//TODO: https://www.youtube.com/watch?v=4ZxsvXMeSkM&ab_channel=How%27sTheCode