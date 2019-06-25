package com.example.fitvending.entidades;

public class Usuario {
    private String nombreUsuario;
    private String  password;
    private double altura;
    private int edad;
    private double peso;
    private int moneda;
    private String sexo;
    private int conectado;

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getConectado() {
        return conectado;
    }

    public void setConectado(int conectado) {
        this.conectado = conectado;
    }

    public String getSexo() {
        return sexo;
    }

    public double getAltura() {
        return altura;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public int getMoneda() {
        return moneda;
    }

    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public String getPassword() {
        return password;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

}
