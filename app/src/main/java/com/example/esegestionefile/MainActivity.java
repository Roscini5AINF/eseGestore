package com.example.esegestionefile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvOut;
    Button bLeggi;
    Button bScrivi;
    EditText edTxt;
    Gestore g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut=(TextView) findViewById(R.id.tvOut);
        bLeggi=(Button) findViewById(R.id.bLeggi);
        bScrivi=(Button) findViewById(R.id.bScrivi);
        edTxt=(EditText) findViewById(R.id.edTxt);
        g=new Gestore(getApplicationContext(), "filedaleggere.txt");

        bLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.leggiFile();
            }
        });

        bScrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                g.scriviFile(edTxt.getText().toString());
            }
        });


    }
}