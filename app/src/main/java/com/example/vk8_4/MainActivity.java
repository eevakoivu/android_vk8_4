package com.example.vk8_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Context context = null;
    TextView text = null;
    TextView text2 = null;
    SeekBar seekbar = null;
    Spinner spinner = null;
    int value = 0;
    int choice = 0;

    String[] bottles = {"Pepsi Max 0,5l 1,8e", "Pepsi Max 1,5l 2,2e", "Coca-Cola Zero 0,5l 2,0e",
            "Coca-Cola Zero 1,5l 2,5e", "Fanta Zero 0,5l 1,95e"};

    BottleDispenser bottledispenser = BottleDispenser.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        text = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter array = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bottles);

        array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(array);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                text2.setText(String.valueOf(i));
                value = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getApplicationContext(),bottles[i],Toast.LENGTH_LONG).show();
        choice = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addMoney(View v){
        bottledispenser.addMoney(text, value);
    }

    public void buyBottle(View v){
        bottledispenser.buyBottle(text, choice);
    }

    public void returnMoney(View v){
        bottledispenser.returnMoney(text);
    }



}

