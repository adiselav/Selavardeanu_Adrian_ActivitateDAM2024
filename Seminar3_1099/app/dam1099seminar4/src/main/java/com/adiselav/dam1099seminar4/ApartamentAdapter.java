package com.adiselav.dam1099seminar4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class ApartamentAdapter extends BaseAdapter {

    private List<Apartament> apartamentList = null;
    private Context ctx;
    private int resursaLayout;

    public ApartamentAdapter(List<Apartament> apartamentList, Context ctx, int resursaLayout)
    {
        this.apartamentList = apartamentList;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return apartamentList.size();
    }

    @Override
    public Object getItem(int i) {
        return apartamentList.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout,parent,false);

        TextView adresaAp=v.findViewById(R.id.adresaApartament);
        TextView camereAp=v.findViewById(R.id.camereApartament);
        TextView anAp=v.findViewById(R.id.constructieApartament);
        TextView suprafataAp=v.findViewById(R.id.suprafataApartament);
//      CheckBox balconAp=v.findViewById(R.id.balconApartament);
        TextView apBalcon=v.findViewById(R.id.apartamentBalcon);

        Apartament apartament = (Apartament)getItem(position);

        adresaAp.setText(apartament.getAdresa());
        camereAp.setText(String.valueOf(apartament.getNrCamere()));
        anAp.setText(String.valueOf(apartament.getAnConstructie()));
        suprafataAp.setText(String.valueOf(apartament.getSuprafata()));
//      balconAp.setChecked(apartament.isBalcon());
        apBalcon.setText("Balcon: "+String.valueOf(apartament.isBalcon()));

        return v;
    }
}
