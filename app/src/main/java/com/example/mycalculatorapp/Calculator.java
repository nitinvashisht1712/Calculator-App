package com.example.mycalculatorapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator extends Activity implements View.OnClickListener {
     private enum OPERATOR {
         PLUS, MINUS, MULTIPLY, DIVIDE, EQUAL

     }

    TextView txtCalculations;
    TextView txtresult;
    //Instance Variables
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private int calculationResults;
    private  String calculationString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationResults = 0;
        calculationString = "";

        txtCalculations = findViewById(R.id.txtCalculations);
        txtresult = findViewById(R.id.txtresult);
        findViewById(R.id.btnequal).setOnClickListener(Calculator.this);
        findViewById(R.id.btn7).setOnClickListener(Calculator.this);
        findViewById(R.id.btn8).setOnClickListener(Calculator.this);
        findViewById(R.id.btn9).setOnClickListener(Calculator.this);
        findViewById(R.id.btnplus).setOnClickListener(Calculator.this);
        findViewById(R.id.btn4).setOnClickListener(Calculator.this);
        findViewById(R.id.btn5).setOnClickListener(Calculator.this);
        findViewById(R.id.btn6).setOnClickListener(Calculator.this);
        findViewById(R.id.btnminus).setOnClickListener(Calculator.this);
        findViewById(R.id.btn1).setOnClickListener(Calculator.this);
        findViewById(R.id.btn2).setOnClickListener(Calculator.this);
        findViewById(R.id.btn3).setOnClickListener(Calculator.this);
        findViewById(R.id.btnmultiply).setOnClickListener(Calculator.this);
        findViewById(R.id.btnclear).setOnClickListener(Calculator.this);
        findViewById(R.id.btn0).setOnClickListener(Calculator.this);
        findViewById(R.id.btndivide).setOnClickListener(Calculator.this);


    }


    @Override
    public void onClick(View view) {
          switch (view.getId()){
              case R.id.btnequal:
                  operatorIsTapped(OPERATOR.EQUAL);
              break;
              case R.id.btn7:
                  numberisTapped(7);
                  break;
              case R.id.btn8:
                  numberisTapped(8);
                  break;
              case R.id.btn9:
                  numberisTapped(9);
                  break;
              case R.id.btnplus:
                  operatorIsTapped(OPERATOR.PLUS);
                  calculationString = calculationString + " + ";
                  break;
              case R.id.btn4:
                  numberisTapped(4);
                  break;
              case R.id.btn5:
                  numberisTapped(5);
                  break;
              case R.id.btn6:
                  numberisTapped(6);
                  break;
              case R.id.btnminus:
                  operatorIsTapped(OPERATOR.MINUS);
                  calculationString = calculationString + " - ";
                  break;
              case R.id.btn1:
                  numberisTapped(1);
                  break;
              case R.id.btn2:
                  numberisTapped(2);
                  break;
              case R.id.btn3:
                  numberisTapped(3);
                  break;
              case R.id.btnmultiply:
                  operatorIsTapped(OPERATOR.MULTIPLY);
                  calculationString = calculationString + " * ";
                  break;
              case R.id.btnclear:
                  clearTapped();
                  break;
              case R.id.btn0:
                  numberisTapped(0);
                  break;
              case R.id.btndivide:
                  operatorIsTapped(OPERATOR.DIVIDE);
                  calculationString = calculationString + " / ";
                  break;
          }
          txtCalculations.setText(calculationString);
    }

    private void numberisTapped(int tappedNumber) {

        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtresult.setText(currentNumber);
        calculationString = currentNumber;
        txtCalculations.setText(calculationString);
    }
    private void operatorIsTapped(OPERATOR tappedOperator){

        if(currentOperator != null) {
            if (currentNumber != "") {
                stringNumberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {
                    case PLUS:
                        calculationResults = Integer.parseInt(stringNumberAtLeft) +
                                Integer.parseInt(stringNumberAtRight);
                        break;
                    case MINUS:
                        calculationResults = Integer.parseInt(stringNumberAtLeft) -
                                Integer.parseInt(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResults = Integer.parseInt(stringNumberAtLeft) *
                                Integer.parseInt(stringNumberAtRight);
                        break;
                    case DIVIDE:
                        calculationResults = Integer.parseInt(stringNumberAtLeft) /
                                Integer.parseInt(stringNumberAtRight);
                        break;

                }
                stringNumberAtLeft = String.valueOf(calculationResults);
                txtresult.setText(stringNumberAtLeft);
                calculationString = stringNumberAtLeft;
            }
        }
        else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";

        }
        currentOperator = tappedOperator;
    }

private void clearTapped(){
        stringNumberAtLeft = "";
        stringNumberAtRight = "";
        calculationResults = 0;
        currentNumber = "";
        currentOperator = null;
        txtresult.setText("0");
        calculationString = "0";


}
}