package com.example.imc;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre, fechaNac;
    private int edad, peso;
    private float altura;
    public Persona(String nombre,String fechaNac,int edad,int peso,float altura){
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    @Override public String toString(){
        return "Persona: "+nombre+", "+fechaNac+", edad: "+edad+" altura: "+altura+", peso: "+peso;
    }
}
