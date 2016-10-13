package com.example.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    //region Instance Variables
    public Button button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonEnter, buttonAdd, buttonSub, buttonMult,
    buttonDivide, buttonAC, buttonDec, buttonAns, button0;
    public ImageButton imageBack;
    public String[] numbers;
    public int signNum;
    public double third;
    public static final int ADD = 0;
    public static final int SUB = 1;
    public static final int DIV = 2;
    public static final int MULT = 3;
    public TextView screen;
    public int holder;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        calculate();
        checkPossible();
    }

    private void checkPossible() {
        if(numbers[holder].length()==0)
        {
            imageBack.setEnabled(false);
            buttonAdd.setEnabled(false);
            buttonSub.setEnabled(false);
            buttonMult.setEnabled(false);
            buttonDivide.setEnabled(false);
        }
        else{
            imageBack.setEnabled(true);
            buttonAdd.setEnabled(true);
            buttonSub.setEnabled(true);
            buttonMult.setEnabled(true);
            buttonDivide.setEnabled(true);

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

    }



    private void calculate() {
        holder = 0;
        screen.setText("");
        numbers = new String[2];
        numbers[holder]="";


    }

    @Override
    public void onClick(View view) {
        checkPossible();
        switch(view.getId()) {
//            case R.id.button_enter :         Calculator x = new Calculator(number1, number2, signNum); switch(signNum){
//                case ADD : ans = x.add(); screen.setText(ans); break;
//                case SUB : ans = x.sub(); break;
//                case MULT : ans = x.mul(); break;
//                case DIV : ans = x.div(); break;

            case R.id.button_back :
                numbers[holder] = numbers[holder].substring(0,numbers[holder].length()-1);
                screen.setText(numbers[holder]); checkPossible();
                break;

            case R.id.button_point : numbers[holder] += .0;
                numbers[holder] = numbers[holder].substring(0,numbers[holder].length()-1);
                numbers[holder] = numbers[holder].substring(0,numbers[holder].length()-2)+
                        numbers[holder].substring(numbers[holder].length()-1, numbers[holder].length());
            screen.setText(numbers[holder]);
                break;

            //region Number Buttons
            case R.id.button_zero : numbers[holder]+=0;
                screen.setText(numbers[holder]); checkPossible(); break;

            case R.id.button_one : numbers[holder]+=1;
                screen.setText(numbers[holder]); checkPossible(); break;

            case R.id.button_two : numbers[holder]+=2;
                screen.setText(numbers[holder]); checkPossible(); break;

            case R.id.button_three : numbers[holder]+=3;
                screen.setText(numbers[holder]); checkPossible(); break;

            case R.id.button_four : numbers[holder]+=4;
                screen.setText(numbers[holder]); checkPossible(); break;

            case R.id.button_five : numbers[holder]+=5;
                screen.setText(numbers[holder]); checkPossible(); break;

            case R.id.button_six : numbers[holder]+=6;
                screen.setText(numbers[holder]); checkPossible(); break;

            case R.id.button_seven : numbers[holder]+=7;
                screen.setText(numbers[holder]); checkPossible(); break;

            case R.id.button_eight : numbers[holder]+=8;
                screen.setText(numbers[holder]); checkPossible(); break;

            case R.id.button_nine : numbers[holder]+=9;
                screen.setText(numbers[holder]); checkPossible(); break;
            //endregion

            //region Sign Buttons
            case R.id.button_add : signNum = ADD;
                holder++;
                screen.setText("");
                numbers[holder] = ""; break;

            case R.id.button_subtract : signNum = SUB;
                holder++;
                screen.setText("");
                numbers[holder] = ""; break;

            case R.id.button_divide : signNum = DIV;
                holder++ ;
                screen.setText("");
                numbers[holder] = "";
                 break;


            case R.id.button_multiply : signNum = MULT;
                holder++ ;
                screen.setText("");
                numbers[holder] = ""; break;
            //endregion

            case R.id.button_enter :
                holder = 0;
                double first = Double.parseDouble(numbers[0]);
                double second = Double.parseDouble(numbers[1]);
                if(signNum ==ADD)
                {
                    third = first + second;
                    screen.setText(third+"");
                    numbers[holder] = third+"";

                }
                else if(signNum ==SUB) {
                    third = first - second;
                    screen.setText(third + "");
                    numbers[holder] = third+"";
                }
                else if (signNum == MULT) {
                    third = first * second;
                    screen.setText(third+"");
                    numbers[holder] = third+"";
                }
                else if (signNum == DIV) {
                    third = first / second;
                    screen.setText(third+"");
                    numbers[holder] = third+"";
                }
                    break;


            case R.id.button_ac : screen.setText("");
                holder =0;
                numbers[holder] ="";
                numbers[holder+1] =""; checkPossible(); break;
            case R.id.button_answer :
                numbers[holder] += third;
                screen.setText(numbers[holder]); checkPossible();
                break;


        }
    }
}
