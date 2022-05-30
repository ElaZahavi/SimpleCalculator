package com.example.thebestcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPoint, btnC, btnMinus, btnPlus, btnDivide, btnMulti, btnEqual;
    private TextView textResult;

    private String operator;

    private double value1 = 0;
    private double value2 = 0;

    private boolean divide, multi, plus, minus, equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPoint = findViewById(R.id.btnPoint);
        btnC = findViewById(R.id.btnC);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnDivide = findViewById(R.id.btnDivide);
        btnMulti = findViewById(R.id.btnMulti);
        btnEqual = findViewById(R.id.btnEqual);
        textResult = findViewById(R.id.textResult);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnEqual.setOnClickListener(this);

        btnEqual.setEnabled(false);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btn0:
                if(equal){
                    textResult.setText("0");
                    equal = false;
                } else {
                  textResult.setText(textResult.getText() + "0");
                }
                break;

            case R.id.btn1:
                if(equal){
                    textResult.setText("1");
                    equal = false;
                } else {
                    textResult.setText(textResult.getText() + "1");
                }
                break;

            case R.id.btn2:
                if(equal){
                    textResult.setText("2");
                    equal = false;
                } else {
                    textResult.setText(textResult.getText() + "2");
                }
                break;

            case R.id.btn3:
                if(equal){
                    textResult.setText("3");
                    equal = false;
                } else {
                    textResult.setText(textResult.getText() + "3");
                }
                break;

            case R.id.btn4:
                if(equal){
                    textResult.setText("4");
                    equal = false;
                } else {
                    textResult.setText(textResult.getText() + "4");
                }
                break;

            case R.id.btn5:
                if(equal){
                    textResult.setText("5");
                    equal = false;
                } else {
                    textResult.setText(textResult.getText() + "5");
                }
                break;

            case R.id.btn6:
                if(equal){
                    textResult.setText("6");
                    equal = false;
                } else {
                    textResult.setText(textResult.getText() + "6");
                }
                break;

            case R.id.btn7:
                if(equal){
                    textResult.setText("7");
                    equal = false;
                } else {
                    textResult.setText(textResult.getText() + "7");
                }
                break;

            case R.id.btn8:
                if(equal){
                    textResult.setText("8");
                    equal = false;
                } else {
                    textResult.setText(textResult.getText() + "8");
                }
                break;

            case R.id.btn9:
                if(equal){
                    textResult.setText("9");
                    equal = false;
                } else {
                    textResult.setText(textResult.getText() + "9");
                }
                break;

            case R.id.btnPoint:
                if(!equal && textResult.length() > 0){
                    textResult.setText(textResult.getText() + ".");
                    btnPoint.setEnabled(false);
                }
                break;

            case R.id.btnC:
                cleanVars();
                btnPoint.setEnabled(true);
                equal = false;
                textResult.setText(null);
                break;

            case R.id.btnDivide:
                if(textResult.length() > 0 && !multi && !plus && !minus && !equal){
                    value1 = Double.parseDouble(textResult.getText().toString());
                    lockOperators();
                    btnEqual.setEnabled(true);
                    operator = "/";
                    textResult.setText(null);
                    divide = true;
                }
                break;

            case R.id.btnMulti:
                if(textResult.length() > 0 && !divide && !plus && !minus && !equal){
                    value1 = Double.parseDouble(textResult.getText().toString());
                    lockOperators();
                    btnEqual.setEnabled(true);
                    operator = "*";
                    textResult.setText(null);
                    multi = true;
                }
                break;

            case R.id.btnPlus:
                if(textResult.length() > 0 && !multi && !divide && !minus && !equal){
                    value1 = Double.parseDouble(textResult.getText().toString());
                    lockOperators();
                    btnEqual.setEnabled(true);
                    operator = "+";
                    textResult.setText(null);
                    plus = true;
                }
                break;

            case R.id.btnMinus:
                if(textResult.length() > 0 && !multi && !plus && !divide && !equal){
                    value1 = Double.parseDouble(textResult.getText().toString());
                    lockOperators();
                    btnEqual.setEnabled(true);
                    operator = "-";
                    textResult.setText(null);
                    minus = true;
                }
                break;

            case R.id.btnEqual:
                if(textResult.length() > 0 && (plus || minus || divide || multi)){
                    value2 = Double.parseDouble(textResult.getText().toString());
                    try {
                        textResult.setText(value1 + " " + operator + " " + value2 + " = " + calculate());
                        btnEqual.setEnabled(false);
                        equal = true;
                        cleanVars();
                        unlockOperators();
                    } catch (MathErrorException e) {
                        textResult.setText(e.getMessage());
                        btnEqual.setEnabled(false);
                        equal = true;
                        cleanVars();
                        unlockOperators();
                    }
                }
                break;
        }
    }

    private double calculate() throws MathErrorException {
        double sum = 0;
        if(plus == true){
            sum = value1 + value2;
            return sum;
        } else if(multi == true){
            sum = value1 * value2;
            return sum;
        } else if(minus == true){
            sum = value1 - value2;
            return sum;
        } else{
            if(value2 == 0){
                throw new MathErrorException();
            } else{
                sum = value1 / value2;
                return sum;
            }
        }
    }

    private void cleanVars(){
        divide = false;
        multi = false;
        plus = false;
        minus = false;
        value1 = 0;
        value2 = 0;
    }

    private void lockOperators(){
        btnMinus.setEnabled(false);
        btnPlus.setEnabled(false);
        btnDivide.setEnabled(false);
        btnMulti.setEnabled(false);
        btnPoint.setEnabled(true);
    }

    private void unlockOperators(){
        btnMinus.setEnabled(true);
        btnPlus.setEnabled(true);
        btnDivide.setEnabled(true);
        btnMulti.setEnabled(true);
        btnPoint.setEnabled(true);
    }
}
