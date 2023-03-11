package com.example.newcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String old_Num = "";
    String op = "+";
    boolean Op = true;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        edit = findViewById(R.id.editTextText);
    }

    public void numberEvent(View view){
        if(Op) {
            edit.setText("");
        }
        Op = false;
        String number = edit.getText().toString();
        switch(view.getId()){
            case R.id.num_zero:
                number += "0";
                break;
            case R.id.num_one:
                number += "1";
                break;
            case R.id.num_two:
                number += "2";
                break;
            case R.id.num_three:
                number += "3";
                break;
            case R.id.num_four:
                number += "4";
                break;
            case R.id.num_five:
                number += "5";
                break;
            case R.id.num_six:
                number += "6";
                break;
            case R.id.num_seven:
                number += "7";
                break;
            case R.id.num_eight:
                number += "8";
                break;
            case R.id.num_nine:
                number += "9";
                break;
            case R.id.sy_Negate:
                number = "-"+number;
                break;
            case R.id.num_dec:
                number = ".";
                break;
        }
        edit.setText(number);

    }
    public void operatorEvent(View view){
        Op = true;
        old_Num = edit.getText().toString();
        switch (view.getId()){
            case R.id.sy_add:
                op = "+";
                break;
            case R.id.sy_subtract:
                op = "-";
                break;
            case R.id.sy_multiply:
                op = "x";
                break;
            case R.id.sy_divide:
                op = "/";
                break;
            case R.id.sy_Equals:
                op = "=";
                break;
        }
        edit.setText(op);

    }
    public void equalsEvent(View view){
        String new_Num = edit.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(old_Num) + Double.parseDouble(new_Num);
                break;
            case "-":
                result = Double.parseDouble(old_Num) - Double.parseDouble(new_Num);
                break;
            case "x":
                result = Double.parseDouble(old_Num) * Double.parseDouble(new_Num);
                break;
            case "/":
                result = Double.parseDouble(old_Num) / Double.parseDouble(new_Num);
        }
        edit.setText(result+"");
    }
    public void deleteEvent(View view){
        edit.setText("0");
        Op = true;
    }
}