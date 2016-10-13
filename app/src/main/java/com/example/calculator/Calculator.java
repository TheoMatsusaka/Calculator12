package com.example.calculator;

/**
 * Created by csaper6 on 10/7/16.
 */
public class Calculator {
    public double first,second;
    int sign;
    public Calculator(double num1, double num2, int sign1)
    {
        first = num1;
        second = num2;
        sign = sign1;
    }
    public String add()
    {

        String x = first + second + "";
        if(x.indexOf(".") != -1)
        {
            return x.substring(0, x.indexOf(".")+5);
        }
        return x;
    }
    public String sub()
    {

        String x = first - second + "";
        if(x.indexOf(".") != -1)
        {
            return x.substring(0, x.indexOf(".")+5);
        }
        return x;
    }
    public String mul()
    {

        String x = first * second + "";
        if(x.indexOf(".") != -1)
        {
            return x.substring(0, x.indexOf(".")+5);
        }
        return x;
    }
    public String div()
    {

        String x = first / second + "";
        if(x.indexOf(".") != -1)
        {
            return x.substring(0, x.indexOf(".")+5);
        }
        return x;
    }
}
