package dev.eunicemercedes.profileCustomer;

import java.util.ArrayList;

public class Customer {
    private String email;
    private String password;
    private String nombre;
    private String telefono;
    private String foto;
    private ArrayList<Transaccion> transacciones;

    public Customer() {
        this.email = "";
        this.password = "";
        this.nombre = "";
        this.telefono = "";
        this.foto = null;
    }

    public Customer(String email, String password, String nombre, String telefono, String foto) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.telefono = telefono;
        this.foto = foto;
    }

    void agregarTransaccion(Transaccion transaccion) {

    }

    ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    String transacciones() {
        return "";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    double getBalance() {
        return 0;
    }

    boolean validateCustomer(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    String getEmail() {
        return email;
    }

    String getPassword() {
        return password;
    }


    String getNombre() {
        return nombre;
    }


    String getTelefono() {
        return telefono;
    }

    String getFoto() {
        return foto;
    }

}
