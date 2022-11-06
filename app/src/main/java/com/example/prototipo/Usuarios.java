package com.example.prototipo;

public class Usuarios {

    String email;
    String contrasena;
    String telefono;

    public Usuarios(String email, String contrasena, String telefono){
        this.contrasena = contrasena;
        this.email = email;
        this.telefono = telefono;
    }


    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

}
