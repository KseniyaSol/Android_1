package ru.gb.calc.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import ru.gb.calc.R;
import ru.gb.calc.model.Calculator;
import ru.gb.calc.model.Operator;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView{

    private TextView resultField;
    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultField = findViewById(R.id.input_field);
        presenter = new CalculatorPresenter(this, new Calculator());
        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);
        digits.put(R.id.key_0, 0);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDigitClick(digits.get(view.getId()));
            }
        };

        findViewById(R.id.key_1).setOnClickListener(digitClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitClickListener);
        findViewById(R.id.key_0).setOnClickListener(digitClickListener);

        Map<Integer, Operator> operators = new HashMap<>();
        operators.put(R.id.key_plus, Operator.PLUS);
        operators.put(R.id.key_minus, Operator.MINUS);
        operators.put(R.id.key_mult, Operator.MULT);
        operators.put(R.id.key_div, Operator.DIV);
        operators.put(R.id.key_procent, Operator.PROCENT);
        operators.put(R.id.key_result, Operator.RESULT);

        View.OnClickListener operatorClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOperatorClick(operators.get(view.getId()));
            }
        };

        findViewById(R.id.key_plus).setOnClickListener(operatorClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operatorClickListener);
        findViewById(R.id.key_mult).setOnClickListener(operatorClickListener);
        findViewById(R.id.key_div).setOnClickListener(operatorClickListener);
        findViewById(R.id.key_procent).setOnClickListener(operatorClickListener);
        findViewById(R.id.key_result).setOnClickListener(operatorClickListener);

        findViewById(R.id.key_point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onPointClick();
            }
        });

        findViewById(R.id.key_c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onClearClick();
            }
        });
    }

    @Override
    public void ShowResult(String result) {
        resultField.setText(result);
    }
}