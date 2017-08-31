package com.uniquindio.electiva_iii.navegacion.vo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Created by andres on 29/08/17.
 */

public class Estudiante implements Parcelable{

    private Date fechaNacimiento;
    private  String nombreCompleto;
    private boolean esHijoUnico;
    private float [] notas;
    private List<Estudiante> amigos;

    /**
     ​* Constructor por defecto
     ​*/
    public Estudiante(Date fechaNacimiento, String nombreCompleto, boolean esHijoUnico, float[] notas) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombreCompleto = nombreCompleto;
        this.esHijoUnico = esHijoUnico;
        this.notas = notas;
        this.amigos = new ArrayList<>();
    }

    protected Estudiante(Parcel in) {
        fechaNacimiento = (Date) in.readSerializable ();
        nombreCompleto = in.readString ();
        esHijoUnico = in.readByte () != 0;
        notas = in.createFloatArray ();
        amigos = in.createTypedArrayList ( Estudiante.CREATOR );
    }

    public static final Creator<Estudiante> CREATOR = new Creator<Estudiante> () {
        @Override
        public Estudiante createFromParcel(Parcel in) {
            return new Estudiante ( in );
        }

        @Override
        public Estudiante[] newArray(int size) {
            return new Estudiante[size];
        }
    };

    @Override
    public String toString() {
        return "Estudiante​{" +
                "fechaNacimiento=" + fechaNacimiento +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", esHijoUnico=" + esHijoUnico +
                ", notas=" + Arrays.toString(notas) +
                ", amigos=" + amigos +
                '}';
    }

    public List<Estudiante> getAmigos() {
        return amigos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable ( fechaNacimiento );
        parcel.writeString ( nombreCompleto );
        parcel.writeByte ( (byte) (esHijoUnico ? 1 : 0) );
        parcel.writeFloatArray ( notas );
        parcel.writeTypedList ( amigos );
    }
}