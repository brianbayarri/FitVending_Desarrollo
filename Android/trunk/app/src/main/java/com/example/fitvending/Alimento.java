package com.example.fitvending;

public class Alimento {

    private String id;
    private String nombre;
    private String porcion;
    private String calorias;

    public Alimento(String id, String nombre, String porcion, String calorias) {
        this.id = id;
        this.nombre = nombre;
        this.porcion = porcion;
        this.calorias = calorias;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcion() {
        return porcion;
    }

    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }
}
