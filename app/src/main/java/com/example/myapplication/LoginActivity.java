package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.System.exit;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText usernameText = findViewById(R.id.editTextPersonName);
        EditText passwordText = findViewById(R.id.editTextPassword);
        CardView card_view = findViewById(R.id.CardView);
        TextView registerText = findViewById(R.id.registerText);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = "";
                try {  //read file
                    InputStream is = openFileInput("UserData.txt");
                    int size =  is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    txt = new String(buffer);
                    String strArray[] = txt.split(" ");

                    for(int i=0; i < strArray.length; i++) { //read user array and control
                        if(usernameText.getText().toString().toLowerCase().equals(strArray[i].toLowerCase()) && passwordText.getText().toString().equals(strArray[i+1])) {
                                Toast toast = Toast.makeText(getApplicationContext(),"Giriş Başarılı", Toast.LENGTH_SHORT);
                                toast.show();
                                Intent ii = new Intent(LoginActivity.this,MainActivity.class); //go to menu
                                ii.putExtra("userName",strArray[i]); //data transfer to the menu screen
                                startActivity(ii);
                                finish();
                                exit(1);
                        }
                    }

                    usernameText.setText("");
                    passwordText.setText("");
                    Toast toast = Toast.makeText(getApplicationContext(),"Giriş Bilgilerinizi Kontrol Ediniz", Toast.LENGTH_SHORT);
                    toast.show();
                }
                catch (IOException ex){
                    Toast toast=Toast. makeText(getApplicationContext(),"Hata", Toast. LENGTH_SHORT);
                    toast.show();
                    finish();
                }
            }
        });
        registerText.setOnClickListener(new View.OnClickListener() {  //go to registeractivity
              @Override
              public void onClick(View v) {
                  Intent i = new Intent(LoginActivity.this,RegistrActivity.class);
                  startActivity(i);
              }
        });
    }
}