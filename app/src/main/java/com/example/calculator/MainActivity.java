//region Code
package com.example.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //region Instance Variables
    public Button button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonEnter, buttonAdd, buttonSub, buttonMult,
            buttonDivide, buttonAC, buttonDec, buttonAns, button0, buttonSin, buttonCos, buttonTan, buttonLog, buttonLn;
    public ImageButton imageBack, imageBG;
    public String[] numbers;
    public ArrayList<Integer> backgrounds;
    public int signNum, bGPosition, holder;
    public double third, first, second;
    public static final int ADD = 0;
    public static final int SUB = 1;
    public static final int DIV = 2;
    public static final int MULT = 3;
    public TextView screen;
    public LinearLayout background, l1,l2,l3,l4, l5, lF;
    public boolean possible;

    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        calculate();
        checkPossible();
        makeList();
        buttonAns.setEnabled(false);
    }

    private void makeList() {
    }

    //region Methods
    private void checkPossible() {
       if (numbers[0].length()==0) {
           possible = false;
            imageBack.setEnabled(false);
            buttonAdd.setEnabled(false);
            buttonSub.setEnabled(false);
            buttonMult.setEnabled(false);
            buttonDivide.setEnabled(false);
            buttonSin.setEnabled(false);
            buttonCos.setEnabled(false);
            buttonTan.setEnabled(false);
            buttonLog.setEnabled(false);
            buttonLn.setEnabled(false);
            buttonEnter.setEnabled(false);
        }
        else if(numbers[holder].indexOf("N")>=0){
           possible = false;
            buttonAdd.setEnabled(false);
            buttonSub.setEnabled(false);
            buttonMult.setEnabled(false);
            buttonDivide.setEnabled(false);
            buttonSin.setEnabled(false);
            buttonCos.setEnabled(false);
            buttonTan.setEnabled(false);
            buttonLog.setEnabled(false);
            buttonLn.setEnabled(false);
            buttonEnter.setEnabled(false);
        }
        else {
           possible = true;
            imageBack.setEnabled(true);
            buttonAdd.setEnabled(true);
            buttonSub.setEnabled(true);
            buttonMult.setEnabled(true);
            buttonDivide.setEnabled(true);
            buttonSin.setEnabled(true);
            buttonCos.setEnabled(true);
            buttonTan.setEnabled(true);
            buttonLog.setEnabled(true);
            buttonLn.setEnabled(true);
            buttonEnter.setEnabled(true);
        }
    }

    private void setListeners() {
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMult.setOnClickListener(this);
        buttonEnter.setOnClickListener(this);
        buttonDec.setOnClickListener(this);
        buttonAns.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        imageBack.setOnClickListener(this);
        buttonSin.setOnClickListener(this);
        buttonCos.setOnClickListener(this);
        buttonTan.setOnClickListener(this);
        buttonLog.setOnClickListener(this);
        buttonLn.setOnClickListener(this);
        imageBG.setOnClickListener(this);


    }

    private void wireWidgets() {
        button1 = (Button) findViewById(R.id.button_one);
        button2 = (Button) findViewById(R.id.button_two);
        button3 = (Button) findViewById(R.id.button_three);
        button4 = (Button) findViewById(R.id.button_four);
        button5 = (Button) findViewById(R.id.button_five);
        button6 = (Button) findViewById(R.id.button_six);
        button7 = (Button) findViewById(R.id.button_seven);
        button8 = (Button) findViewById(R.id.button_eight);
        button9 = (Button) findViewById(R.id.button_nine);
        buttonAdd = (Button) findViewById(R.id.button_add);
        buttonSub = (Button) findViewById(R.id.button_subtract);
        buttonMult = (Button) findViewById(R.id.button_multiply);
        buttonEnter = (Button) findViewById(R.id.button_enter);
        buttonDec = (Button) findViewById(R.id.button_point);
        buttonAns = (Button) findViewById(R.id.button_answer);
        buttonAC = (Button) findViewById(R.id.button_ac);
        buttonDivide = (Button) findViewById(R.id.button_divide);
        imageBack = (ImageButton) findViewById(R.id.button_back);
        screen = (TextView) findViewById(R.id.screen);
        button0 = (Button) findViewById(R.id.button_zero);
        buttonSin = (Button) findViewById(R.id.button_sin);
        buttonCos = (Button) findViewById(R.id.button_cos);
        buttonTan = (Button) findViewById(R.id.button_tan);
        buttonLog = (Button) findViewById(R.id.button_log);
        buttonLn = (Button) findViewById(R.id.button_ln);
        imageBG = (ImageButton) findViewById(R.id.imageButton_background);
        background = (LinearLayout) findViewById(R.id.layor_background);
        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        l3 = (LinearLayout) findViewById(R.id.l3);
        l4 = (LinearLayout) findViewById(R.id.l4);
        l5 = (LinearLayout) findViewById(R.id.l5);
        imageBG.setVisibility(View.GONE);
        lF = (LinearLayout) findViewById(R.id.filler_layout);

    }

    private void calculate() {
        holder = 0;
        screen.setText("");
        numbers = new String[2];
        numbers[0] = "";
        numbers[1] = "";


    }

    private void setFirst() {
        if(numbers[0].length()==0){
            numbers[0]= third+"";
        }
    }

    private void makeToast(){
        if(numbers[holder].length()==0) {
            Toast.makeText(MainActivity.this, "There is nothing to delete", Toast.LENGTH_SHORT).show();

        }
    }

    //endregion

    @Override
    public void onClick(View view) {
        checkPossible();
        switch (view.getId()) {

            case R.id.button_back:
                setFirst();
                makeToast();
                if(numbers[holder].length()==0)
                    break;
                numbers[holder] = numbers[holder].substring(0, numbers[holder].length() - 1);
                screen.setText(numbers[holder]);
                checkPossible();
                break;

            case R.id.button_point:
                if(numbers[holder].indexOf(".")>=0)
                    break;
                numbers[holder] += .0;
                numbers[holder] = numbers[holder].substring(0, numbers[holder].length() - 1);
                numbers[holder] = numbers[holder].substring(0, numbers[holder].length() - 2) +
                        numbers[holder].substring(numbers[holder].length() - 1, numbers[holder].length());
                screen.setText(numbers[holder]);
                imageBack.setEnabled(true);
                break;

            case R.id.imageButton_background:
                break;


            //region Number Buttons
            case R.id.button_zero:
                numbers[holder] += 0;
                screen.setText(numbers[holder]);
                checkPossible();
                break;

            case R.id.button_one:
                numbers[holder] += 1;
                screen.setText(numbers[holder]);
                checkPossible();
                break;

            case R.id.button_two:
                numbers[holder] += 2;
                screen.setText(numbers[holder]);
                checkPossible();
                break;

            case R.id.button_three:
                numbers[holder] += 3;
                screen.setText(numbers[holder]);
                checkPossible();
                break;

            case R.id.button_four:
                numbers[holder] += 4;
                screen.setText(numbers[holder]);
                checkPossible();
                break;

            case R.id.button_five:
                numbers[holder] += 5;
                screen.setText(numbers[holder]);
                checkPossible();
                break;

            case R.id.button_six:
                numbers[holder] += 6;
                screen.setText(numbers[holder]);
                checkPossible();
                break;

            case R.id.button_seven:
                numbers[holder] += 7;
                screen.setText(numbers[holder]);
                checkPossible();
                break;

            case R.id.button_eight:
                numbers[holder] += 8;
                screen.setText(numbers[holder]);
                checkPossible();
                break;

            case R.id.button_nine:
                numbers[holder] += 9;
                screen.setText(numbers[holder]);
                checkPossible();
                break;
            //endregion

            //region Sign Buttons
            case R.id.button_add:
                setFirst();
                checkPossible();
                signNum = ADD;
                holder = 1;
                screen.setText("");
                numbers[holder] = "";
                break;

            case R.id.button_subtract:
                setFirst();
                checkPossible();
                signNum = SUB;
                holder = 1;
                screen.setText("");
                numbers[holder] = "";
                break;

            case R.id.button_divide:
                setFirst();
                checkPossible();
                signNum = DIV;
                holder = 1;
                screen.setText("");
                numbers[holder] = "";
                break;


            case R.id.button_multiply:
                setFirst();
                checkPossible();
                signNum = MULT;
                holder = 1;
                screen.setText("");
                numbers[holder] = "";
                break;
            //endregion

            //region Enter Button
            case R.id.button_enter:
                setFirst();
                checkPossible();
                buttonAns.setEnabled(true);
                holder = 0;
                if(numbers[0].length()!=0)
                first = Double.parseDouble(numbers[0]);
                if(numbers[1].length()!=0)
                second = Double.parseDouble(numbers[1]);
                else{second =0;}
                if (signNum == ADD) {
                    third = first + second;
                    screen.setText(third + "");
                    numbers[holder] ="";

                } else if (signNum == SUB) {
                    third = first - second;
                    screen.setText(third + "");
                    numbers[holder] = "";
                } else if (signNum == MULT) {
                    third = first * second;
                    screen.setText(third + "");
                    numbers[holder] ="";
                } else if (signNum == DIV) {
                    third = first / second;
                    screen.setText(third + "");
                    numbers[holder] ="";
                }
                else{
                    third = first;
                    screen.setText(third+"");
                    numbers[holder]="";
                }

                break;
            //endregion


            case R.id.button_ac:
                screen.setText("");
                holder = 0;
                numbers[0] = "";
                numbers[1] = "";
                checkPossible();
                break;

            case R.id.button_answer:
                if(numbers[holder].indexOf(third+"")>=0)
                    break;
                numbers[holder] += third;
                screen.setText(numbers[holder]);
                checkPossible();
                break;

            //region Trigonometric Buttons
            case R.id.button_sin:
                setFirst();
                holder = 0;
                double fird = Double.parseDouble(numbers[0]);
                third = Math.sin(fird);
                screen.setText(third + "");
                numbers[holder] = third + "";
                checkPossible();
                break;

            case R.id.button_cos:
                setFirst();
                holder = 0;
                double dird = Double.parseDouble(numbers[0]);
                third = Math.cos(dird);
                screen.setText(third + "");
                numbers[holder] = third + "";
                checkPossible();
                break;

            case R.id.button_tan:
                setFirst();
                checkPossible();
                holder = 0;
                double gird = Double.parseDouble(numbers[0]);
                third = Math.tan(gird);
                screen.setText(third + "");
                numbers[holder] = third + "";
                checkPossible();
                break;
            //endregion

            //region Log and Ln Buttons
            case R.id.button_log:
                setFirst();
                holder = 0;
                double qird = Double.parseDouble(numbers[0]);
                third = Math.log10(qird);
                screen.setText(third + "");
                numbers[holder] = third + "";
                checkPossible();
                break;

            case R.id.button_ln:
                setFirst();
                holder = 0;
                double jird = Double.parseDouble(numbers[0]);
                third = Math.log(jird);
                screen.setText(third + "");
                numbers[holder] = third + "";
                checkPossible();
                break;
            //endregion
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //at this point, the layouts have proper width & height values.
        //if you've wired your linearlayout, you can access the width & height
        button0.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        button1.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        button2.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        button3.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        button4.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        button5.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        button6.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        button7.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        button8.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        button9.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonTan.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonCos.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonSin.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonLog.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonLn.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        imageBack.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonMult.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonDivide.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonDec.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonAdd.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonSub.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonAns.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        buttonEnter.setLayoutParams(new LinearLayout.LayoutParams(2*background.getWidth()/5, background.getHeight()/5));
        buttonAC.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()/5, background.getHeight()/5));
        l1.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth(), background.getHeight()/7));
        l2.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth(), background.getHeight()/7));
        l3.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth(), background.getHeight()/7));
        l4.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth(), background.getHeight()/7));
        l5.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth(), background.getHeight()/7));
        screen.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth()*9/10, background.getHeight()/8));
        lF.setLayoutParams(new LinearLayout.LayoutParams(background.getWidth(), background.getHeight()/7));

//        http://stackoverflow.com/questions/11293932/programmatically-change-the-width-of-the-button-in-android
    }

}

//endregion
