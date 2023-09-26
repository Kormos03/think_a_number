    package com.example.think_a_number;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

    public class MainActivity extends AppCompatActivity {
    private Button buttonUp;
    private TextView textView;
    private Button buttonDown;
    private Button buttonSubmit;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private int number;
    private int randomNumber;
    private int life;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = number + 1;
                textView.setText(String.valueOf(number));
                if (number < 0)
                {
                    Toast.makeText(MainActivity.this, "0 és 10 között van a szám", Toast.LENGTH_SHORT).show();
                } else if (number > 10)
                {
                    Toast.makeText(MainActivity.this, "0 és 10 között van a szám", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = number - 1;
                textView.setText(String.valueOf(number));
            }
        });
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(number < randomNumber)
            {
                Toast.makeText(MainActivity.this, "Feljebb kell tippelni", Toast.LENGTH_SHORT).show();
            } else if (number > randomNumber) {
                Toast.makeText(MainActivity.this, "Lejjebb kell tippelni", Toast.LENGTH_SHORT).show();
            }
            else if (number == randomNumber)
            {
                alertDialog.setTitle("Nyertél").create().show();
            }

                if(number != randomNumber && life == 3)
                {
                    imageView3.setImageResource(R.drawable.heart1);
                    life = life - 1;
                } else if (number != randomNumber && life == 2)
                {
                    imageView2.setImageResource(R.drawable.heart1);
                    life = life - 1;
                }
                else if (number != randomNumber && life == 1)
                {
                    imageView1.setImageResource(R.drawable.heart1);
                    life = life - 1;
                    alertDialog.setTitle("Vesztettél").create().show();
                }
                else if (number != randomNumber && life <= 0)
                {
                }
            }
        });
    }
    public void init()
    {
        buttonUp = findViewById(R.id.buttonUp);
        textView = findViewById(R.id.textView);
        buttonDown = findViewById(R.id.buttonDown);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        Random random = new Random();
        randomNumber = random.nextInt(11);
        life = 3;
        alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Nyertél :)").setMessage("Restart?").setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        })
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    Reset();
                    }
                })
                .setCancelable(false)
                .create();
    }
    public void Reset()
    {
        imageView3.setImageResource(R.drawable.heart2);
        imageView2.setImageResource(R.drawable.heart2);
        imageView1.setImageResource(R.drawable.heart2);
        life = 3;
        Random random = new Random();
        randomNumber = random.nextInt(11);
        number = 0;
        textView.setText(String.valueOf(number));

    }
}