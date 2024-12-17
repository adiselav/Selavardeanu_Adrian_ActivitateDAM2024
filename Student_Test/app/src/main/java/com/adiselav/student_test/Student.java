package com.adiselav.student_test;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "studenti")
public class Student implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nume;
    private int varsta;
    private boolean integralist;

    public Student(String nume, int varsta, boolean integralist) {
        this.nume = nume;
        this.varsta = varsta;
        this.integralist = integralist;
    }

    public Student() {
    }

    protected Student(Parcel in) {
        id = in.readInt();
        nume = in.readString();
        varsta = in.readInt();
        integralist = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nume);
        dest.writeInt(varsta);
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

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

    public boolean isIntegralist() {
        return integralist;
    }

    public void setIntegralist(boolean integralist) {
        this.integralist = integralist;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", nume='").append(nume).append('\'');
        sb.append(", varsta=").append(varsta);
        sb.append(", integralist=").append(integralist);
        sb.append('}');
        return sb.toString();
    }
}
