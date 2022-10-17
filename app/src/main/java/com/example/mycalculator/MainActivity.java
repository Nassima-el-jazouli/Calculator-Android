package com.example.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ecran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ecran = findViewById(R.id.Ecran);
        ecran.setShowSoftInputOnFocus(false);
        ecran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.ecran).equals(ecran.getText().toString()))
                {
                    ecran.setText("");
                }
            }
        });
    }

    public void updateText(String strToAdd)
    {
        String oldStr = ecran.getText().toString();
        int cursorPos = ecran.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.ecran).equals(ecran.getText().toString()))
        {
            ecran.setText(strToAdd);
            ecran.setSelection(cursorPos + 1);
        }
        else
        {
            ecran.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            ecran.setSelection(cursorPos + 1);
        }
    }

    public void btn0(View view){
        updateText("0");
    }
    public void btn1(View view){
        updateText("1");
    }
    public void btn2(View view){
        updateText("2");
    }
    public void btn3(View view){
        updateText("3");
    }
    public void btn4(View view){
        updateText("4");
    }
    public void btn5(View view){
        updateText("5");
    }
    public void btn6(View view){
        updateText("6");
    }
    public void btn7(View view){
        updateText("7");
    }
    public void btn8(View view){
        updateText("8");
    }
    public void btn9(View view){
        updateText("9");
    }



    public void btnaddition(View view){
        updateText("+");
    }
    public void btnsoustraction(View view){
        updateText("-");
    }
    public void btnproduit(View view){
        updateText("*");
    }
    public void btndivision(View view){
        updateText("/");
    }



    public void btnclear(View view){
        ecran.setText("");
    }
    public void btnegal(View view){
        String userExp = ecran.getText().toString();
        //userExp.replaceAll("x", "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        ecran.setText(result);
        ecran.setSelection(result.length());
    }



    public void btnconsinus(View view){
        Editable valeur = ecran.getText();
        if (valeur.equals(""))
        {
            ecran.setText("Error");
        }
        else
        {
            double degrees = Double.parseDouble(String.valueOf(ecran.getText()));
            if (degrees<0 || degrees>360)
            {
                ecran.setText("Error");
            }
            else
            {
                double radians = Math.toRadians(degrees);
                double cosValue = Math.cos(radians);
                ecran.setText(Double.toString(cosValue));
            }
        }
    }
    public void btnsinus(View view){
        Editable valeur = ecran.getText();
        if (valeur.equals(""))
        {
            ecran.setText("Error");
        }
        else
        {
            double degrees = Double.parseDouble(String.valueOf(ecran.getText()));
            if (degrees<0 || degrees>360)
            {
                ecran.setText("Error");
            }
            else
            {
                double radians = Math.toRadians(degrees);
                double sinValue = Math.sin(radians);
                ecran.setText(Double.toString(sinValue));
            }
        }
    }
    public void btntangence(View view){
        Editable valeur = ecran.getText();
        if (valeur.equals(""))
        {
            ecran.setText("Error");
        }
        else
        {
            double degrees = Double.parseDouble(String.valueOf(ecran.getText()));
            if (degrees<0 || degrees>360)
            {
                ecran.setText("Error");
            }
            else
            {
                double radians = Math.toRadians(degrees);
                double tanValue = Math.tan(radians);
                ecran.setText(Double.toString(tanValue));
            }
        }
    }
    public void btninverse(View view){
        Editable valeur = ecran.getText();
        double result = 1/Double.parseDouble(String.valueOf(valeur));
        ecran.setText(Double.toString(result));
    }




}