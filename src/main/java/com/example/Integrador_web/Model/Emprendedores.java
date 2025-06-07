package com.example.Integrador_web.Model;

public class Emprendedores {
    private int id_empresa;
    private int id_usuario;
    private String nombre_empresa;
    private String telefono;
    private String descripcion;
    private String sitio_web;

    public Emprendedores(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Emprendedores(int id_empresa, int id_usuario, String nombre_empresa, String telefono, String descripcion, String sitio_web) {
        this.id_empresa = id_empresa;
        this.id_usuario = id_usuario;
        this.nombre_empresa = nombre_empresa;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.sitio_web = sitio_web;
    }

    public Emprendedores(String nombre_empresa, String telefono, String descripcion, String sitio_web) {
        this.nombre_empresa = nombre_empresa;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.sitio_web = sitio_web;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSitio_web() {
        return sitio_web;
    }

    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }
}
