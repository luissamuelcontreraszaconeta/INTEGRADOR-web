package com.example.Integrador_web.Model;

public class Usuario {
    private int idUsuario;
    private int idtipoUsuario;
    private String nombreCompleto;
    private String nombreUsuario;
    private String correo;
    private String contrasena;
    private String fecharegistro;
    private String ultimoacceso;
    private boolean activo;
    private String dni;

    public Usuario(int idUsuario, String nombreCompleto, String nombreUsuario, String correo, String contrasena, String fecharegistro, String ultimoacceso, boolean activo, String dni) {
        this.idUsuario = idUsuario;
        this.idtipoUsuario = idtipoUsuario;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fecharegistro = fecharegistro;
        this.ultimoacceso = ultimoacceso;
        this.activo = activo;
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Usuario() {
    }

    public Usuario(String nombreCompleto, String nombreUsuario, String correo, String contrasena, String fecharegistro, String ultimoacceso, boolean activo) {
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fecharegistro = fecharegistro;
        this.ultimoacceso = ultimoacceso;
        this.activo = activo;
    }

//    public Usuario(int idUsuario, String nombreCompleto, String nombreUsuario, String correo, String contrasena, String fecharegistro, String ultimoacceso, boolean activo) {
//        this.idUsuario = idUsuario;
//        this.nombreCompleto = nombreCompleto;
//        this.nombreUsuario = nombreUsuario;
//        this.correo = correo;
//        this.contrasena = contrasena;
//        this.fecharegistro = fecharegistro;
//        this.ultimoacceso = ultimoacceso;
//        this.activo = activo;
//    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdtipoUsuario() {
        return idtipoUsuario;
    }

    public void setIdtipoUsuario(int idtipoUsuario) {
        this.idtipoUsuario = idtipoUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUltimoacceso() {
        return ultimoacceso;
    }

    public void setUltimoacceso(String ultimoacceso) {
        this.ultimoacceso = ultimoacceso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

