package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Logger;

import static java.lang.System.exit;
public class RegistrActivity extends AppCompatActivity {

//Fonk kullandigimiz icin degiskenleri global tanimladik.

    EditText username;
    EditText ps;
    String kul,sifre1,sifre2;
    Button btn;
    EditText   psAgain;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = findViewById(R.id.txtKulAdi);
                kul = username.getText().toString();

                ps = findViewById(R.id.txtSifre);
                sifre1 = ps.getText().toString();

                psAgain = findViewById(R.id.txtSifreAgain);
                sifre2 = psAgain.getText().toString();

                Toast toast;
                if(sifre1.equals(sifre2))
                {
                    toast = Toast.makeText(getApplicationContext(), "Dogruu!! sifre2: " + sifre2 + " sifre1: " + sifre1, Toast.LENGTH_SHORT);
                    FileOutputStream fos = null;
                    String fileName= "UserData.txt";
                    try {
                        fos = openFileOutput(fileName,MODE_APPEND);
                        String kullaniciBilgiler = kul+" "+sifre1+" ";
                        fos.write(kullaniciBilgiler.getBytes());

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if(fos!=null){

                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }


                }

                else
                {
                    toast = Toast.makeText(getApplicationContext(), "Yanlış! sifre2: " + sifre2 + " sifre1: " + sifre1 + " birbirine eşit değil!", Toast.LENGTH_LONG);

                }
                toast.show();

            }
        });



    }




}