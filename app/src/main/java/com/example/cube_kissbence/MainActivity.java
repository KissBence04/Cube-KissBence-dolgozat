package com.example.cube_kissbence;

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
    private Button btnDobas;
    private ImageView ivgep, ivember;
    private int emberP,gepP;
    private TextView twEmber, twGep;
    private AlertDialog alertDialog;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnDobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random Er = new Random();
                    int Evalasztas = Er.nextInt(6) + 1;
                    switch (Evalasztas) {
                        case 1:
                            ivember.setImageResource(R.drawable.kocka1);
                            break;
                        case 2:
                            ivember.setImageResource(R.drawable.kocka2);
                            break;
                        case 3:
                            ivember.setImageResource(R.drawable.kocka3);
                            break;
                        case 4:
                            ivember.setImageResource(R.drawable.kocka4);
                            break;
                        case 5:
                            ivember.setImageResource(R.drawable.kocka5);
                            break;
                        case 6:
                            ivember.setImageResource(R.drawable.kocka6);
                            break;
                    }
                    Random Gr = new Random();
                    int Gvalasztas = Gr.nextInt(6) + 1;
                    switch (Gvalasztas) {
                        case 1:
                            ivgep.setImageResource(R.drawable.kocka1);
                            break;
                        case 2:
                            ivgep.setImageResource(R.drawable.kocka2);
                            break;
                        case 3:
                            ivgep.setImageResource(R.drawable.kocka3);
                            break;
                        case 4:
                            ivgep.setImageResource(R.drawable.kocka4);
                            break;
                        case 5:
                            ivgep.setImageResource(R.drawable.kocka5);
                            break;
                        case 6:
                            ivgep.setImageResource(R.drawable.kocka6);
                            break;
                    }
                    if (Evalasztas > Gvalasztas) {
                        emberP++;
                        twEmber.setText("Ember: " + emberP);
                    } else if (Gvalasztas > Evalasztas) {
                        gepP++;
                        twGep.setText("Gép: " + gepP);
                    }
                    if((emberP==3)||(gepP==3))
                    {
                        alertDialog.show();
                    }

            }
        });
    }


    private void init()
    {
        btnDobas=(Button)findViewById(R.id.btndobas);
        ivember=(ImageView)findViewById(R.id.IVember);
        ivgep=(ImageView)findViewById(R.id.IVgep);
        twEmber=(TextView)findViewById(R.id.twJatekos);
        twGep=(TextView)findViewById(R.id.twGep);


        alertDialogBuilder=new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setMessage("Ki akarsz lépni az alkalmazásból?");

        alertDialogBuilder.setPositiveButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Nem zártad be az alkalmazást",Toast.LENGTH_SHORT).show();
                if((emberP>=4)||(gepP>=4))
                {
                    finish();
                }
            }
        });

        alertDialogBuilder.setNegativeButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alertDialogBuilder.setNeutralButton("Mégse", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        //Kilépés a dialogboxból
        alertDialogBuilder.setCancelable(false);
        //AlertDialog értékadás
        alertDialog=alertDialogBuilder.create();
    }
}
