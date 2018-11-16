package dev.eunicemercedes.profileCustomer;

import java.util.Date;

public class Transaccion {

    Date fecha;
    TipoTransaccion tipoTransaccion;
    String concepto;
    Double valor;
    String foto;

    public Transaccion(Date fecha, TipoTransaccion tipoTransaccion, String concepto) {
        this.fecha = fecha;
        this.tipoTransaccion = tipoTransaccion;
        this.concepto = concepto;
    }

    public Transaccion(Date fecha, TipoTransaccion tipoTransaccion, String concepto, Double valor) {
        this.fecha = fecha;
        this.tipoTransaccion = tipoTransaccion;
        this.concepto = concepto;
        this.valor = valor;
    }

    Date getFecha() {
        return fecha;
    }

    TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    String getConcepto() {
        return concepto;
    }

    Double getValor() {
        return valor;
    }

    void setValor(Double valor) {
        this.valor = valor;
    }

    String getFoto() {
        return foto;
    }

    void setFoto(String foto) {
        this.foto = foto;
    }
}

class TipoTransaccion {
    String nombre;

    public TipoTransaccion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
