package ru.gb.calc.ui;

import java.text.DecimalFormat;

import ru.gb.calc.model.CalculatorModel;
import ru.gb.calc.model.Operator;

public class CalculatorPresenter {

    private final CalculatorView view;
    private final CalculatorModel model;

    private final DecimalFormat formatter = new DecimalFormat("#.##");
    private final DecimalFormat formatterPoint = new DecimalFormat("#.");

    private double argOne;
    private Double argTwo;
    private Operator selectedOperator;
    private boolean pointPressed = false;

    public CalculatorPresenter(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
    }

    public void onDigitClick(int digit) {

        if (argTwo == null){
            if (pointPressed) {
                argOne = argOne + 0.1 * digit;
                view.ShowResult(String.valueOf(argOne));
                pointPressed = false;
            }else {
                argOne = argOne * 10 + digit;
                showFormatted(argOne);
            }

        }else {
            if (pointPressed) {
                argTwo = argTwo + 0.1 * digit;
                view.ShowResult(String.valueOf(argTwo));
                pointPressed = false;
            }else {
                pointPressed = false;
                argTwo = argTwo * 10 + digit;
                showFormatted(argTwo);
            }
        }
    }

    public void onOperatorClick(Operator operator) {

        if (argTwo == null) argTwo = 0.0;
        if (selectedOperator != null){
            argOne = model.calculate(argOne, argTwo, selectedOperator);
            if (pointPressed) view.ShowResult(String.valueOf(argOne));
            else showFormatted(argOne);
        }
        argTwo = 0.0;
        selectedOperator = operator;
    }

    public void onPointClick() {
        pointPressed = true;

        if (argTwo == null) view.ShowResult(formatterPoint.format(argOne));
        else view.ShowResult(formatterPoint.format(argTwo));
    }

    private void showFormatted(double value){
        view.ShowResult(formatter.format(value));
    }

    public void onClearClick() {
        argOne = 0;
        argTwo = null;
        showFormatted(argOne);
    }
}
