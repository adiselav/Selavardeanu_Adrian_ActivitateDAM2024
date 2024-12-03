package com.adiselav.dam1099seminar4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Apartamente")
public class Apartament implements Parcelable{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String adresa;
    private int nrCamere;
    private int anConstructie;
    private float suprafata;
    private boolean balcon;

    public Apartament() {
        this.adresa = "Calea Dorobantilor";
        this.nrCamere = 1;
        this.anConstructie = 1960;
        this.suprafata = 20.0F;
        this.balcon = true;
    }

    public Apartament(String adresa, int nrCamere, int anConstructie, float suprafata, boolean balcon) {
        this.adresa = adresa;
        this.nrCamere = nrCamere;
        this.anConstructie = anConstructie;
        this.suprafata = suprafata;
        this.balcon = balcon;
    }

    protected Apartament(Parcel in) {
        id = in.readInt();
        adresa = in.readString();
        nrCamere = in.readInt();
        anConstructie = in.readInt();
        suprafata = in.readFloat();
        balcon = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(adresa);
        dest.writeInt(nrCamere);
        dest.writeInt(anConstructie);
        dest.writeFloat(suprafata);
        dest.writeByte((byte) (balcon ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //vector de obiecte:
    public static final Creator<Apartament> CREATOR = new Creator<Apartament>() {
        @Override
        public Apartament createFromParcel(Parcel in) {
            return new Apartament(in);
        }

        @Override
        public Apartament[] newArray(int size) {
            return new Apartament[size];
        }
    };
    //end

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getNrCamere() {
        return nrCamere;
    }

    public void setNrCamere(int nrCamere) {
        this.nrCamere = nrCamere;
    }

    public int getAnConstructie() {
        return anConstructie;
    }

    public void setAnConstructie(int anConstructie) {
        this.anConstructie = anConstructie;
    }

    public float getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(float suprafata) {
        this.suprafata = suprafata;
    }

    public boolean isBalcon() {
        return balcon;
    }

    public void setBalcon(boolean balcon) {
        this.balcon = balcon;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Apartament{");
        sb.append("adresa='").append(adresa).append('\'');
        sb.append(", nrCamere=").append(nrCamere);
        sb.append(", anConstructie=").append(anConstructie);
        sb.append(", suprafata=").append(suprafata);
        sb.append(", balcon=").append(balcon);
        sb.append('}');
        return sb.toString();
    }
}
