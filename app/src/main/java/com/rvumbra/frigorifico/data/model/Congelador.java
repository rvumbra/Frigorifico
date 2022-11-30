package com.rvumbra.frigorifico.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Congelador implements Serializable, Parcelable {
    private String nombre;
    private String cantidad;

    public Congelador(){}
    public Congelador(String nombre, String cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    protected Congelador(Parcel in) {
        nombre = in.readString();
        cantidad = in.readString();
    }

    public static final Creator<Congelador> CREATOR = new Creator<Congelador>() {
        @Override
        public Congelador createFromParcel(Parcel in) {
            return new Congelador(in);
        }

        @Override
        public Congelador[] newArray(int size) {
            return new Congelador[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Congelador that = (Congelador) o;

        return nombre.equals(that.nombre);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * El parcelable se genera solo, pero si tienes tipos de datos personalizados, debes incluirlos
     * a mano ya que si no es un String, entero o cualquier tipo de dato básico, no lo incluirá solo
     * y hay que meterlo a mano.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(cantidad);
    }
}
