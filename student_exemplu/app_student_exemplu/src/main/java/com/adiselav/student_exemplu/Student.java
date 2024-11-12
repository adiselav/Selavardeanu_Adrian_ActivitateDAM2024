package com.adiselav.student_exemplu;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Student implements Parcelable {
    private String nume;
    private int varsta;
    private String specializare;
    private Date data;

    public Student() {
        this.nume = "Marian";
        this.varsta = 65;
        this.specializare = "CSIE";
        this.data = new Date(2024/11/12);
    }

    public Student(String nume, int varsta, String specializare, Date data) {
        this.nume = nume;
        this.varsta = varsta;
        this.specializare = specializare;
        this.data = data;
    }

    protected Student(Parcel in) {
        nume = in.readString();
        varsta = in.readInt();
        specializare = in.readString();
        data = (java.util.Date)in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeInt(varsta);
        dest.writeString(specializare);
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

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
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
        sb.append(", varsta=").append(varsta);
        sb.append(", specializare='").append(specializare).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
