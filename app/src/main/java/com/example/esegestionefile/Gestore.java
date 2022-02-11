package com.example.esegestionefile;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Gestore {
    Context c;
    String nomeFile;

    public Gestore(Context c, String nomeFile){
        this.nomeFile=nomeFile;
        this.c=c;
    }

    public StringBuilder leggiFile(){
        String str="";
        StringBuilder stb=new StringBuilder(1200);
        try {
            BufferedReader br= new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile)));
            while((str=br.readLine()) != null){
                stb.append(str + "/n");
            }
            Toast.makeText(c.getApplicationContext(), "file letto con successo", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(c.getApplicationContext(), "file non trovato", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(c.getApplicationContext(), "errore in lettura", Toast.LENGTH_SHORT).show();
        }
        return stb;
    }

    public void scriviFile(String txt){
        FileOutputStream fileO;
        try {
            fileO = c.openFileOutput(nomeFile, Context.MODE_PRIVATE);
            fileO.write(txt.getBytes());
            fileO.close();
            Toast.makeText(c.getApplicationContext(), "scrittura avvenuta con successo", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(c.getApplicationContext(), "file non trovato", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(c.getApplicationContext(), "errore in scrittura", Toast.LENGTH_SHORT).show();
        }
    }
}
