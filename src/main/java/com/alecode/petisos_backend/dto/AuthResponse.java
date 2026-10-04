package com.alecode.petisos_backend.dto;

public class AuthResponse {
    private boolean exito;
    private String mensaje;
    private String email;
    private String rol;

    public AuthResponse(boolean exito, String mensaje, String email, String rol) {
        this.exito = exito;
        this.mensaje = mensaje;
        this.email = email;
        this.rol = rol;
    }

    public boolean isExito() { return exito; }
    public String getMensaje() { return mensaje; }
    public String getEmail() { return email; }
    public String getRol() { return rol; }
}