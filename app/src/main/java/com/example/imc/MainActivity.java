package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText nombre, fechaNac, edad, altura, peso;
    private Button calcularIMC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.nombre);
        fechaNac = findViewById(R.id.fechaNac);
        edad = findViewById(R.id.edad);
        altura = findViewById(R.id.altura);
        peso = findViewById(R.id.peso);
        calcularIMC = findViewById(R.id.calcularIMC);
        calcularIMC.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                Persona persona = new Persona(nombre.getText().toString(),fechaNac.getText().toString(),Integer.parseInt(edad.getText().toString()),
                        Integer.parseInt(peso.getText().toString()),Float.parseFloat(altura.getText().toString()));
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("persona",persona);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}