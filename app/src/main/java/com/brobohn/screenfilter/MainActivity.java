package com.brobohn.screenfilter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_filterOn;
    Button btn_filterOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_filterOn = (Button) findViewById(R.id.btn_on);
        btn_filterOff = (Button) findViewById(R.id.btn_off);

    }

    public void filterOn(View view) {

        Intent i = new Intent(MainActivity.this, MainService.class);
        startService(i);

    }


    public void filterOff(View view) {
        Intent i=new Intent(MainActivity.this, MainService.class);
        stopService(i);
    }
}
