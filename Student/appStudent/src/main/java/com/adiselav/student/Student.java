package com.adiselav.student;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Student implements Parcelable {
//start of class
private String nume;
private int varsta;
private float venit;
private String facultate;
private Date data;
private boolean integralist;

    public Student() {
        this.nume = "Leontin";
        this.varsta = 20;
        this.venit = 999.99f;
        this.facultate = "Cybernetic";
        this.data = new Date("10/12/2018");
        this.integralist = true;
    }

    public Student(String nume, int varsta, float venit, String facultate, Date data, boolean integralist) {
        this.nume = nume;
        this.varsta = varsta;
        this.venit = venit;
        this.facultate = facultate;
        this.data = data;
        this.integralist = integralist;
    }

    protected Student(Parcel in) {
        nume = in.readString();
        varsta = in.readInt();
        venit = in.readFloat();
        facultate = in.readString();
        data = (java.util.Date)in.readSerializable();
        integralist = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeInt(varsta);
        dest.writeFloat(venit);
        dest.writeString(facultate);
        dest.writeSerializable(data);
        dest.writeByte((byte) (integralist ? 1 : 0));
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

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public float getVenit() {
        return venit;
    }

    public void setVenit(float venit) {
        this.venit = venit;
    }

    public String getFacultate() {
        return facultate;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isIntegralist() {
        return integralist;
    }

    public void setIntegralist(boolean integralist) {
        this.integralist = integralist;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("nume='").append(nume).append('\'');
        sb.append(", varsta=").append(varsta);
        sb.append(", venit=").append(venit);
        sb.append(", facultate='").append(facultate).append('\'');
        sb.append(", data=").append(data);
        sb.append(", integralist=").append(integralist);
        sb.append('}');
        return sb.toString();
    }

    //end of class
}
