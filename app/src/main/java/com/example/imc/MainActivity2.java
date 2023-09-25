package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView dato, res, nombreIMC, recetas;
    private ImageView imagen;
    private String clasificacion[] = {"Delgadez severa","Delgadez moderada","Delgadez leve","Normal","Preobesidad",
            "Obesidad leve","Obesidad media","Obesidad mórbida"};
    private String cuidados[] = {"Comer frijoles, guisantes, nueces sin sal y semillas","Comer mariscos, carnes magras, aves y huevos",
            "Comer granos integrales, avena, pan integral y arroz integral","verduras en rodajas o zanahorias pequeñas con humus",
            "Comer pan blanco, arroz y pasta elaborados con granos refinados","Comer verduras de hojas oscuras como col o col rizada",
            "Tomar leche y productos lácteos descremados o bajos en grasa.",
            "Tomar leche de soya, almendra, arroz u otras bebidas no lácteas con vitamina D y calcio agregados"};

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dato = findViewById(R.id.dato);
        res = findViewById(R.id.res);
        nombreIMC = findViewById(R.id.nombreIMC);
        recetas = findViewById(R.id.recetas);
        imagen = findViewById(R.id.imagen);
        Bundle objeto_enviado = getIntent().getExtras();
        Persona persona = null;
        if(objeto_enviado!=null){
            persona = (Persona) objeto_enviado.getSerializable("persona");
            double imc = indice(persona.getPeso(),persona.getAltura());
            nombreIMC.setText(nombreIMC.getText()+persona.getNombre());
            dato.setText(dato.getText()+"\n"+imc);
            res.setText(res.getText()+"\nUsted tiene: "+tipo(imc));
            resIMG(imc);
        }
    }
    public double indice(double peso, double altura){
        return peso/Math.pow(2,altura);
    }
    public String tipo(double imc){
        if(imc<16){
            recomendaciones(0);
            return clasificacion[0];
        } else if(imc>=16 && imc<17){
            recomendaciones(1);
            return clasificacion[1];
        } else if(imc>=17 && imc<18.5){
            recomendaciones(2);
            return clasificacion[2];
        } else if(imc>=18.5 && imc<25){
            recomendaciones(3);
            return clasificacion[3];
        } else if(imc>=25 && imc<30){
            recomendaciones(4);
            return clasificacion[4];
        } else if(imc>=30 && imc<35){
            recomendaciones(5);
            return clasificacion[5];
        } else if(imc>=35 && imc<40){
            recomendaciones(6);
            return clasificacion[6];
        } else if(imc>=40){
            recomendaciones(7);
            return clasificacion[7];
        } else {
            return null;
        }
    }
    public void recomendaciones(int tipo){
        switch (tipo){
            case 0:
                recetas.setText(recetas.getText()+"\n"+cuidados[0]);
                break;
            case 1:
                recetas.setText(recetas.getText()+"\n"+cuidados[1]);
                break;
            case 2:
                recetas.setText(recetas.getText()+"\n"+cuidados[2]);
                break;
            case 3:
                recetas.setText(recetas.getText()+"\n"+cuidados[3]);
                break;
            case 4:
                recetas.setText(recetas.getText()+"\n"+cuidados[4]);
                break;
            case 5:
                recetas.setText(recetas.getText()+"\n"+cuidados[5]);
                break;
            case 6:
                recetas.setText(recetas.getText()+"\n"+cuidados[6]);
                break;
            case 7:
                recetas.setText(recetas.getText()+"\n"+cuidados[7]);
                break;
        }
    }
    public void resIMG(double imc){
        if(imc<18.5){
            imagen.setImageResource(R.drawable.delgado);
        } else if(imc>=18.5 && imc<30){
            imagen.setImageResource(R.drawable.normal);
        } else if(imc>=30){
            imagen.setImageResource(R.drawable.obeso);
        }
    }
}