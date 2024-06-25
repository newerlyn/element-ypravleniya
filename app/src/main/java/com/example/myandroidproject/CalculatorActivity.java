package com.example.myandroidproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private EditText result;
    private String operator;
    private String operand1;
    private String operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        result = findViewById(R.id.result);
    }

    public void onDigit(View view) {
        Button button = (Button) view;
        result.append(button.getText().toString());
    }

    public void onOperator(View view) {
        Button button = (Button) view;
        operand1 = result.getText().toString();
        operator = button.getText().toString();
        result.setText("");
    }

    public void onClear(View view) {
        result.setText("");
    }

    public void onEqual(View view) {
        operand2 = result.getText().toString();
        int resultValue = 0;

        switch (operator) {
            case "+":
                resultValue = Integer.parseInt(operand1) + Integer.parseInt(operand2);
                break;
            case "-":
                resultValue = Integer.parseInt(operand1) - Integer.parseInt(operand2);
                break;
            case "*":
                resultValue = Integer.parseInt(operand1) * Integer.parseInt(operand2);
                break;
            case "/":
                resultValue = Integer.parseInt(operand1) / Integer.parseInt(operand2);
                break;
        }

        result.setText(String.valueOf(resultValue));
    }
}
