package com.adiselav.formular;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Student implements Parcelable {
    private String nume;
    private String gen;
    private String facultate;
    private Boolean restanta;
    private float venit;
    private Date data;

    public Student() {
    }

    public Student(String nume, String gen, String facultate, Boolean restanta, float venit, Date data) {
        this.nume = nume;
        this.gen = gen;
        this.facultate = facultate;
        this.restanta = restanta;
        this.venit = venit;
        this.data = data;
    }

    protected Student(Parcel in) {
        nume = in.readString();
        gen = in.readString();
        facultate = in.readString();
        byte tmpRestanta = in.readByte();
        restanta = tmpRestanta == 0 ? null : tmpRestanta == 1;
        venit = in.readFloat();
        data = (java.util.Date)in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeString(gen);
        dest.writeString(facultate);
        dest.writeByte((byte) (restanta == null ? 0 : restanta ? 1 : 2));
        dest.writeFloat(venit);
        dest.writeSerializable(data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getFacultate() {
        return facultate;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }

    public Boolean getRestanta() {
        return restanta;
    }

    public void setRestanta(Boolean restanta) {
        this.restanta = restanta;
    }

    public float getVenit() {
        return venit;
    }

    public void setVenit(float venit) {
        this.venit = venit;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("nume='").append(nume).append('\'');
        sb.append(", gen='").append(gen).append('\'');
        sb.append(", facultate='").append(facultate).append('\'');
        sb.append(", restanta=").append(restanta);
        sb.append(", venit=").append(venit);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}


