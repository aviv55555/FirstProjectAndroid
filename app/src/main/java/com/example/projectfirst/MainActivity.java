package com.example.projectfirst;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView result;
    int num1 = 0;
    int num2;
    char operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result = findViewById(R.id.textViewResult);
        result.setText(""); //update
        //append concat for exist
        //getText get information from the .toString()
        //char ch = result.getText().toString().charAt(0);
    }

    public void numberFunc(View view) {
        Button button = (Button) view;
        result.append(button.getText().toString());
    }

    public void funcOperators(View view) {
        num1 = Integer.parseInt(result.getText().toString());
        result.setText("");
        Button button = (Button) view;
        operator = button.getText().toString().charAt(0);
    }

    public void funcEqual(View view) {
        num2 = Integer.parseInt(result.getText().toString());
        switch (operator)
        {
            case '+':
                result.setText(String.valueOf(num1 + num2));
                num1 = num1 + num2;
                break;
            case '-':
                result.setText(String.valueOf(num1 - num2));
                break;
            case '/':
                if(num2 == 0) {
                    new AlertDialog.Builder(this).setMessage("Calculate Failed! Cannot divide by zero!!") .setPositiveButton("OK", null).show();
                    result.setText("");
                }
                else
                    result.setText(String.valueOf(num1 / num2));
                break;
            case 'x':
                result.setText(String.valueOf(num1 * num2));
                break;
            case '^':
                result.setText(String.valueOf((int)Math.pow(num1 , num2)));
                break;
        }
    }

    public void funcXPowTwo(View view) {
        num1 = Integer.parseInt(result.getText().toString());
        result.setText(String.valueOf((int)Math.pow(num1 , 2)));
    }

    public void funcClearEverything(View view) {
        num1 = 0;
        num2 = 0;
        result.setText("");
    }

    public void funcOneEarse(View view) {
        String currentText = result.getText().toString();
        // Check if the string is empty
        if (currentText.isEmpty()) {
            return; // Do nothing if the string is empty
        }
        else
        {
            // Remove the last character by using substring
                String newText = currentText.substring(0, currentText.length() - 1);
                result.setText(newText); // Set the new text in the TextView
        }
    }

    public void funcInform(View view) {
        new AlertDialog.Builder(this).setMessage("This calculator creadted by Aviv Ovadia :)") .setPositiveButton("OK", null).show();
    }
}