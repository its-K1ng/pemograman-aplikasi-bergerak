package edu.uph.m23si1.aplikasipertama;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KalkulatorActivity extends AppCompatActivity {
    EditText number1, number2;
    Button btnAdd, btnMultiply, btnDivide;
    TextView result;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        btnAdd = findViewById(R.id.btnAdd);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        result = findViewById(R.id.result);

        btnAdd.setOnClickListener(view -> calculate('+'));
        btnMultiply.setOnClickListener(view -> calculate('*'));
        btnDivide.setOnClickListener(view -> calculate('/'));
    }

    private void calculate(char operator) {
        String input1 = number1.getText().toString();
        String input2 = number2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            result.setText("Masukkan kedua angka!");
            return;
        }

        double num1 = Double.parseDouble((input1));
        double num2 = Double.parseDouble((input2));
        double hasil = 0;

        switch (operator) {
            case '+':
                hasil = num1 + num2;
                break;
            case '*':
                hasil = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    result.setText("Tidak bisa dibagi 0!");
                    return;
                }
                hasil = num1 / num2;
                break;
        }

        result.setText(String.valueOf(hasil));
    }
}