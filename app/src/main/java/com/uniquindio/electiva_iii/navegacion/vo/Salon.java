package com.uniquindio.electiva_iii.navegacion.vo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by andres on 31/08/17.
 */

public class Salon implements Parcelable {

    private int numeroSalon;
    private int numeroSillas;
    private List<Estudiante> estudiante;


    public Salon(int numeroSalon, int numeroSillas, List<Estudiante> estudiante) {
        this.numeroSalon = numeroSalon;
        this.numeroSillas = numeroSillas;
        this.estudiante = estudiante;
    }

    public Salon(int numeroSalon, int numeroSillas) {
        this.numeroSalon = numeroSalon;
        this.numeroSillas = numeroSillas;
        this.estudiante = new ArrayList<> (  );
    }

    protected Salon(Parcel in) {
        numeroSalon = in.readInt ();
        numeroSillas = in.readInt ();
        estudiante = in.createTypedArrayList ( Estudiante.CREATOR );
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt ( numeroSalon );
        dest.writeInt ( numeroSillas );
        dest.writeTypedList ( estudiante );
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Salon> CREATOR = new Creator<Salon> () {
        @Override
        public Salon createFromParcel(Parcel in) {
            return new Salon ( in );
        }

        @Override
        public Salon[] newArray(int size) {
            return new Salon[size];
        }
    };

    @Override
    public String toString() {
        return "Salon{" +
                "numeroSalon=" + numeroSalon +
                ", numeroSillas=" + numeroSillas +
                ", estudiante=" + estudiante +
                '}';
    }
}
