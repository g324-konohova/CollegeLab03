package com.itproger.collegelab03;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spFrom;
    Spinner spTo;
    Button btnConvert;
    EditText input;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spFrom = findViewById(R.id.spFrom);
        spTo = findViewById(R.id.spTo);
        btnConvert = findViewById(R.id.btnConvert);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        // Создаем объекты Chisla
        Chisla mm = new Chisla("mm", 1);
        Chisla cm = new Chisla("cm", 10);
        Chisla m = new Chisla("m", 1000);
        Chisla km = new Chisla("km", 1000000);

        // Добавляем их в список
        ArrayList<Chisla> lengths = new ArrayList<>(Arrays.asList(mm, cm, m, km));

        // Устанавливаем адаптеры для спиннеров
        ArrayAdapter<Chisla> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lengths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spFrom.setAdapter(adapter);
        spTo.setAdapter(adapter);

        // Устанавливаем действие на кнопку
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertLength();
            }
        });
    }

    // Метод для конвертации
    private void convertLength() {
        try {
            Chisla from = (Chisla) spFrom.getSelectedItem();
            Chisla to = (Chisla) spTo.getSelectedItem();
            float inputValue = Float.parseFloat(input.getText().toString());
            float resultValue = (inputValue * from.coef) / to.coef;
            output.setText(String.valueOf(resultValue));
        } catch (Exception e) {

            output.setText("Ошибка ввода");
        }
    }

    // Класс Chisla
    class Chisla {
        String name;
        float coef;

        Chisla(String name, float coef) {
            this.name = name;
            this.coef = coef;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
