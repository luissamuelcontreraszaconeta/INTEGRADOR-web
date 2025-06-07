package com.example.Integrador_web.Model;

public class Publicaciones {
    private int id_publicacion;
    private int id_tema;
    private int id_usuario;
    private String titulo;
    private String contenido;
    private String fecha_publicacion;
    private String nombreUsuario;


    public Publicaciones() {
    }

    public Publicaciones(int id_publicacion, int id_tema, int id_usuario, String titulo, String contenido, String fecha_publicacion) {
        this.id_publicacion = id_publicacion;
        this.id_tema = id_tema;
        this.id_usuario = id_usuario;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getId_publicacion() {
        return id_publicacion;
    }

    public void setId_publicacion(int id_publicacion) {
        this.id_publicacion = id_publicacion;
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
