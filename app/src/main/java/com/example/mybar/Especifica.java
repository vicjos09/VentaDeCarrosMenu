package com.example.mybar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Especifica extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vistaespecifica);
        Bundle bundle = this.getIntent().getExtras();
        //ImageView iv = new ImageView(this);

        ImageView iv = (ImageView) findViewById(R.id.especifica);



        //Locate the controls
        TextView txtBrand = (TextView)findViewById(R.id.brand);
        TextView txtName = (TextView)findViewById(R.id.name);
        TextView txtModel = (TextView)findViewById(R.id.model);
        TextView txtPrice = (TextView)findViewById(R.id.price);
        TextView txtNumbeofCil = (TextView)findViewById(R.id.cilinder);

        if(bundle.getString("name").equals("Corvette"))
            iv.setImageResource(R.mipmap.carro1);
        if(bundle.getString("name").equals("RS5"))
            iv.setImageResource(R.mipmap.audi);
        if(bundle.getString("name").equals("AMG"))
            iv.setImageResource(R.mipmap.amg);
        if(bundle.getString("name").equals("M3"))
            iv.setImageResource(R.mipmap.mtres);
        if(bundle.getString("name").equals("aventador"))
            iv.setImageResource(R.mipmap.lambo);


        txtBrand.setText("Fabricante: "+bundle.getString("brand"));
        txtName.setText(bundle.getString("name"));
        txtModel.setText("Modelo: "+bundle.getString("model"));
        txtPrice.setText("$"+bundle.getString("price"));
        txtNumbeofCil.setText("Number of cilinders:"+bundle.getString("numberCil"));

    }
}
