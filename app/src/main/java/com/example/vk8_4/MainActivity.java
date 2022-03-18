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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Context context = null;
    TextView text = null;
    TextView text2 = null;
    SeekBar seekbar = null;
    Spinner spinner = null;
    int value = 0;
    int choice = 0;
    ArrayList<String> bottlelist = null;

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
        spinner();

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

    public void spinner(){

        bottlelist = new ArrayList<String>(); //luodaan lista pulloille

        bottlelist = bottledispenser.createArraylist();

        //data spinneriin
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bottlelist);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        choice = i; //mikä ostetaan tai poistetaan
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void addMoney(View v){
        bottledispenser.addMoney(text, value);
        seekbar.setProgress(0);
    }

    public void buyBottle(View v){
        if(bottlelist.isEmpty()){
            text.setText("Bottledispenser is empty.");
        }
        else{
            bottledispenser.buyBottle(text, choice);
            if(bottlelist.size() > 0){ //tyhjällä listalla ei uutta spinneriä
                spinner();
            }
        }
    }

    public void returnMoney(View v){
        bottledispenser.returnMoney(text);
        seekbar.setProgress(0);
    }



}

