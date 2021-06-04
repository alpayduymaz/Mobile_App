package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {
    //AutoCompleteTextView autoCompleteTextView;

    // fonks
    private Spinner mySpinner;
    private  CustomSpinnerAdapter mAdepter;
    private  Menus mMenu;
    //buttons
    private void init(){
        mySpinner=findViewById(R.id.spinner);
        mAdepter = new CustomSpinnerAdapter(Menus.getData(this),this);
        mySpinner.setAdapter(mAdepter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // loginden gelen veri alınıyor
        Intent gelenbilgi = getIntent();
        String userName = gelenbilgi.getStringExtra("userName");
        Toast toast = Toast.makeText(getApplicationContext(),"Welcome "+userName, Toast.LENGTH_LONG);
        toast.show();

        init();// menü ekleniyor
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                changeFragment(parent,i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                changeFragment(parent,0);
            }
        });


    }



    private void changeActivity(String activityName){
        if(activityName == "map") {
            Intent i = new Intent(this, MainActivity2.class);//Burası butona eklenecek
            startActivity(i);
        }
        if(activityName == "exchange") {
            Intent i = new Intent(this, dovizActivity.class);//Burası butona eklenecek
            startActivity(i);
        }
    }
    private void changeFragment(AdapterView<?> parent,int pos){
        mMenu = (Menus) parent.getItemAtPosition(pos);
        System.out.println(mMenu.getIconName());//Switch case ile yapılcak
        if(mMenu.getIconName()=="MAIN SCREEN"){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            MainScreen mainScreen = new MainScreen();
            transaction.replace(R.id.fragment_container,mainScreen);
            transaction.commit();
        }

        if(mMenu.getIconName()=="BREAKFAST"){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            BreakfastScreen breakFastscreen = new BreakfastScreen();

            transaction.replace(R.id.fragment_container,breakFastscreen);
            transaction.commit();
        }
        if(mMenu.getIconName()=="PLACES TO GO")
            changeActivity("map");

        if(mMenu.getIconName()=="FOREIGN CURRENCY")
            changeActivity("exchange");





        /**/


    }
}