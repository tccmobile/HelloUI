package com.example.helloui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView helloText;
    ToggleButton showButton;
    CheckBox boldBox;
    CheckBox italicBox;
    SeekBar alphaBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloText = (TextView)findViewById(R.id.helloText);
        showButton = (ToggleButton)findViewById(R.id.showButton);
        boldBox = (CheckBox)findViewById(R.id.boldBox);
        italicBox = (CheckBox)findViewById(R.id.italicBox);
        alphaBar = (SeekBar)findViewById(R.id.alphaBar);

        alphaBar.setMax(100);
        alphaBar.setProgress(100);

        showButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    helloText.setVisibility(View.VISIBLE);
                } else {
                    helloText.setVisibility(View.INVISIBLE);
                }
            }
        });

        boldBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boldBox.isChecked() && italicBox.isChecked()) {
                    helloText.setTypeface(null, Typeface.BOLD_ITALIC);
                } else if (!boldBox.isChecked() && italicBox.isChecked()){
                    helloText.setTypeface(null,Typeface.ITALIC);
                } else if (boldBox.isChecked() && !italicBox.isChecked()){
                    helloText.setTypeface(null,Typeface.BOLD);
                } else {
                    helloText.setTypeface(null,Typeface.NORMAL);
                }
            }
        });


        italicBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (boldBox.isChecked() && italicBox.isChecked()) {
                    helloText.setTypeface(null, Typeface.BOLD_ITALIC);
                } else if (!boldBox.isChecked() && italicBox.isChecked()){
                    helloText.setTypeface(null,Typeface.ITALIC);
                } else if (boldBox.isChecked() && !italicBox.isChecked()){
                    helloText.setTypeface(null,Typeface.BOLD);
                } else {
                    helloText.setTypeface(null,Typeface.NORMAL);
                }
            }
        });

        alphaBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int position, boolean b) {
                helloText.setAlpha(position/100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
