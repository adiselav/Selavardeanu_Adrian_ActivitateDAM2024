package com.adiselav.tramvai;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tramvaie")
public class Tramvai implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String model;
    private boolean bidirectional;

    public Tramvai(int id, String model, boolean bidirectional) {
        this.id = id;
        this.model = model;
        this.bidirectional = bidirectional;
    }

    public Tramvai() {
    }

    protected Tramvai(Parcel in) {
        id = in.readInt();
        model = in.readString();
        bidirectional = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(model);
        dest.writeByte((byte) (bidirectional ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tramvai> CREATOR = new Creator<Tramvai>() {
        @Override
        public Tramvai createFromParcel(Parcel in) {
            return new Tramvai(in);
        }

        @Override
        public Tramvai[] newArray(int size) {
            return new Tramvai[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isBidirectional() {
        return bidirectional;
    }

    public void setBidirectional(boolean bidirectional) {
        this.bidirectional = bidirectional;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tramvai{");
        sb.append("id=").append(id);
        sb.append(", model='").append(model).append('\'');
        sb.append(", bidirectional=").append(bidirectional);
        sb.append('}');
        return sb.toString();
    }
}


