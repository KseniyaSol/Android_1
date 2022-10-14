package ru.gb.calc.model;

public class Calculator implements CalculatorModel {

    @Override
    public double calculate(double argOne, double argTwo, Operator operator) {
        switch (operator){
            case DIV:
                return argOne / argTwo;
            case MULT:
                return argOne * argTwo;
            case PLUS:
                return argOne + argTwo;
            case MINUS:
                return argOne - argTwo;
            case PROCENT:
                return argOne / 100 * argTwo;
            case RESULT:{
                argTwo = 0.0;
                return argOne;
            }
        }
        return 0.0;
    }
}
