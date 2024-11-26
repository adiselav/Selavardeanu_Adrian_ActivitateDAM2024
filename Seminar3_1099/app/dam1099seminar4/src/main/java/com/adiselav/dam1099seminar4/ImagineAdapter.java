package com.adiselav.dam1099seminar4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class ImagineAdapter extends BaseAdapter {
    private List<ImaginiDomeniu> imaginiList;
    private Context ctx;
    private int resursaLayout;

    public ImagineAdapter(List<ImaginiDomeniu> imaginiList, Context ctx, int resursaLayout) {
        this.imaginiList = imaginiList;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return imaginiList.size();
    }

    @Override
    public Object getItem(int position) {
        return imaginiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
//        View view = inflater.inflate(resursaLayout, parent,false);
        @SuppressLint("ViewHolder") View view = inflater.inflate(resursaLayout, parent,false);

        ImageView imageView = view.findViewById(R.id.imagineIV);

        ImaginiDomeniu imagine = (ImaginiDomeniu)getItem(position);

        imageView.setImageBitmap(imagine.getImagine());

        return view;
    }
}
