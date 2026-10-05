package com.dsa.calculator;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Esto sirve para crear las variables q usaremos.
    TextView display;
    double firstNumber = 0.0;
    String pendingOperation = "";
    boolean newNumber = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Asignamos el display del XML
        display = findViewById(R.id.display);

        //Mira estado de si DEG o RAD
        ToggleButton toggleAngle = findViewById(R.id.toggleAngle);

        //Guardar y enseñar los numeros al darle a cada boton.
        findViewById(R.id.button0).setOnClickListener(v -> addNumber("0"));
        findViewById(R.id.button1).setOnClickListener(v -> addNumber("1"));
        findViewById(R.id.button2).setOnClickListener(v -> addNumber("2"));
        findViewById(R.id.button3).setOnClickListener(v -> addNumber("3"));
        findViewById(R.id.button4).setOnClickListener(v -> addNumber("4"));
        findViewById(R.id.button5).setOnClickListener(v -> addNumber("5"));
        findViewById(R.id.button6).setOnClickListener(v -> addNumber("6"));
        findViewById(R.id.button7).setOnClickListener(v -> addNumber("7"));
        findViewById(R.id.button8).setOnClickListener(v -> addNumber("8"));
        findViewById(R.id.button9).setOnClickListener(v -> addNumber("9"));

        // Al pulsar el boton C, el display vuelve al 0 y se borra operacion guardada.
        findViewById(R.id.buttonClear).setOnClickListener(v -> {
            display.setText("0");
            firstNumber = 0.0;
            pendingOperation = "";
            newNumber = true;
        });

        //Esto hace que al pulsar +, guarda el numero marcado, la operacion y pone en true para saber
        //que empieza un nuevo numero.
        findViewById(R.id.buttonSum).setOnClickListener(v -> {
            firstNumber = Double.parseDouble(display.getText().toString());
            pendingOperation = "+";
            newNumber = true;
        });
        findViewById(R.id.buttonSubstract).setOnClickListener(v -> {
            firstNumber = Double.parseDouble(display.getText().toString());
            pendingOperation = "-";
            newNumber = true;
        });
        findViewById(R.id.buttonMultiply).setOnClickListener(v -> {
            firstNumber = Double.parseDouble(display.getText().toString());
            pendingOperation = "x";
            newNumber = true;
        });
        findViewById(R.id.buttonDivide).setOnClickListener(v -> {
            firstNumber = Double.parseDouble(display.getText().toString());
            pendingOperation = "/";
            newNumber = true;
        });

        // Aqui guardamos el segundo numero y realizamos la operacionq q toca.
        findViewById(R.id.buttonEqual).setOnClickListener(v -> {

            double secondNumber = Double.parseDouble(display.getText().toString());

            if (pendingOperation.equals("+")) {
                double result = firstNumber + secondNumber;
                display.setText(String.valueOf(result));
            }

            if (pendingOperation.equals("-")) {
                double result = firstNumber - secondNumber;
                display.setText(String.valueOf(result));
            }

            if (pendingOperation.equals("x")) {
                double result = firstNumber * secondNumber;
                display.setText(String.valueOf(result));
            }

            if (pendingOperation.equals("/")) {
                if (secondNumber != 0.0) {
                    double result = firstNumber / secondNumber;
                    display.setText(String.valueOf(result));
                } else {
                    display.setText("Math Error");
                }
            }

            newNumber = true;
        });

        //Sirve para marcar que hacer al pusar sin, cos, tan
        findViewById(R.id.buttonSin).setOnClickListener(v -> {

            double number = Double.parseDouble(display.getText().toString());

            double angle;

            if (toggleAngle.isChecked()) {
                angle = number;
            } else {
                angle = Math.toRadians(number);
            }

            double result = Math.sin(angle);
            display.setText(String.valueOf(result));

            newNumber = true;
        });
        findViewById(R.id.buttonCos).setOnClickListener(v -> {

            double number = Double.parseDouble(display.getText().toString());

            double angle;

            if (toggleAngle.isChecked()) {
                angle = number;
            } else {
                angle = Math.toRadians(number);
            }

            double result = Math.cos(angle);
            display.setText(String.valueOf(result));

            newNumber = true;
        });
        findViewById(R.id.buttonTan).setOnClickListener(v -> {

            double number = Double.parseDouble(display.getText().toString());

            double angle;

            if (toggleAngle.isChecked()) {
                angle = number;
            } else {
                angle = Math.toRadians(number);
            }

            double result = Math.tan(angle);
            display.setText(String.valueOf(result));

            newNumber = true;
        });
    }



    //Métodos
    private void addNumber(String number) {

        if (display.getText().toString().equals("0") || newNumber) {
            display.setText(number);
            newNumber = false;
        } else {
            display.setText(display.getText().toString() + number);
        }
    }


}
