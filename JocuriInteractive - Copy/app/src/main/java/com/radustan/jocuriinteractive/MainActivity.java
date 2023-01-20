package com.radustan.jocuriinteractive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnJocuri;
    private Button btnDespreNoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgLogo = findViewById(R.id.imgLogo);

        Button btnJocuri =  findViewById(R.id.btnJocuri);
        btnJocuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }
        });

        Button btnSetari =  findViewById(R.id.btnSetari);
        btnSetari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSetari();
            }
        });

        Button btnDespreNoi =  findViewById(R.id.btnDespreNoi);
        btnSetari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSetari();  //TODO pagina pt despre noi
            }
        });

        ///fac butonul sa isi schimbe dimensiunile dupa rezolutia device-ului
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightbtn = displayMetrics.heightPixels;
        int widthbtn = displayMetrics.widthPixels;
        btnJocuri.getLayoutParams().width=widthbtn / (25/10);
        btnJocuri.getLayoutParams().height=heightbtn / 20;

        btnSetari.getLayoutParams().width=widthbtn / (25/10);
        btnSetari.getLayoutParams().height=heightbtn / 20;

        btnDespreNoi.getLayoutParams().width=widthbtn / (25/10);
        btnDespreNoi.getLayoutParams().height=heightbtn / 20;

        imgLogo.getLayoutParams().height=heightbtn / 2;
        imgLogo.getLayoutParams().width=heightbtn / 2;

    }

    public void openSetari() {
        Intent intent = new Intent(this, Setari.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void openMainActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void clickDespreNoi (View view){
        
        TextView txtHello = findViewById(R.id.txtMessage);
        txtHello.setText("Justice in Math");
    }
}