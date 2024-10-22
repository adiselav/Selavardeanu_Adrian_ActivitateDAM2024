package com.adiselav.dam1099seminar4;

public class Apartament {
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
