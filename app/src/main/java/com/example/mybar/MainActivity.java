package com.example.mybar;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.mybar.db.Data;
import com.example.mybar.db.DbHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Carro> listaCar=new ArrayList<>();
    int flag=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper=new DbHelper(MainActivity.this);
        SQLiteDatabase es= dbHelper.getWritableDatabase();
        dbHelper.onUpgrade(es,1,2);

        dbHelper.insertData(new Data("1","Ford","Corvette","2019","8","70000","1"));
        dbHelper.insertData(new Data("2","Audi","RS5","2023","6","500000","2"));
        dbHelper.insertData(new Data("3","Mercedes","AMG","2018","8","60000","3"));
        dbHelper.insertData(new Data("4","BMW","M3","2022","6","400000","4"));
        dbHelper.insertData(new Data("5","Lamborghini","aventador","2011","4","300000","5"));

        if (es!=null){
            Log.i("DATABASE___________________________________", "Insertada");
        }else {
            Log.i("DATABASE", "No creada");
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaCar.add(dbHelper.searchCar("1")) ;
        listaCar.add(dbHelper.searchCar("2")) ;
        listaCar.add(dbHelper.searchCar("3")) ;
        listaCar.add(dbHelper.searchCar("4")) ;
        listaCar.add(dbHelper.searchCar("5")) ;

        Log.i(" DATABASE________Cilindros_____________ "+listaCar.get(1).getNumberOfCylinder(), "Data1");

        AdaptadorC adaptador = new AdaptadorC(this);
        ListView lv1 = findViewById(R.id.list1);
        lv1.setAdapter(adaptador);
        lv1.setAdapter(adaptador);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this,listaCar.get(i).getName(), Toast.LENGTH_LONG).show();
                flag=i;

            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.locaciones:

                   Toast.makeText(MainActivity.this,"Open Google Maps", Toast.LENGTH_LONG).show();
                   return true;

            case R.id.action_settings:

                if (flag==-1){

                    Toast.makeText(MainActivity.this,"Selecciona un Carro", Toast.LENGTH_LONG).show();

                }else {

                    Log.i("ActionBar", "D");
                    Intent intent = new Intent(MainActivity.this, Especifica.class);
                    intent.putExtra("Key", listaCar.get(flag).getCarID());
                    intent.putExtra("name", listaCar.get(flag).getName());
                    intent.putExtra("brand", listaCar.get(flag).getBrand());
                    intent.putExtra("model", listaCar.get(flag).getModel());
                    intent.putExtra("numberCil", listaCar.get(flag).getNumberOfCylinder());
                    intent.putExtra("price", listaCar.get(flag).getPrice());
                    intent.putExtra("class", this.getClass());
                    //We create the information to pass between activities
                    Bundle b = new Bundle();
                    b.putString("Name", listaCar.get(flag).getName()); // a parameter is added to the Intent
                    // for this the name of the parameter and the value are required
                    b.putInt("Key", Integer.valueOf(listaCar.get(flag).getCarID()));
                    b.putString("name", listaCar.get(flag).getName());
                    b.putString("brand", listaCar.get(flag).getBrand());
                    b.putString("model", listaCar.get(flag).getModel());
                    b.putString("numberCil", listaCar.get(flag).getNumberOfCylinder());
                    b.putString("price", listaCar.get(flag).getPrice());
                    //We add the information to the intent
                    intent.putExtras(b);
                    startActivity(intent);

                }

                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }
    class AdaptadorC extends ArrayAdapter<Carro> {

        AppCompatActivity appCompatActivity;

        AdaptadorC(AppCompatActivity context) {
            super(context, R.layout.carro, listaCar);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.carro, null);

            TextView textView1 = item.findViewById(R.id.textView);
            textView1.setText("Model: "+listaCar.get(position).getModel());
            TextView carId= item.findViewById(R.id.textView4);
            carId.setText("Name "+listaCar.get(position).getName());
            TextView brand= item.findViewById(R.id.textView3);
            brand.setText("BRAND: "+listaCar.get(position).getBrand());
            TextView name= item.findViewById(R.id.textView5);
            name.setText("ID: "+listaCar.get(position).getCarID());

            ImageView imageView1 = item.findViewById(R.id.imageView);

            if (listaCar.get(position).getName().equals("Corvette"))

                imageView1.setImageResource(R.mipmap.carro1);

            if (listaCar.get(position).getName().equals("RS5"))

                imageView1.setImageResource(R.mipmap.audi);

            if (listaCar.get(position).getName().equals("AMG"))

                imageView1.setImageResource(R.mipmap.amg);

            if (listaCar.get(position).getName().equals("M3"))

                imageView1.setImageResource(R.mipmap.mtres);

            if (listaCar.get(position).getName().equals("aventador"))

                imageView1.setImageResource(R.mipmap.lambo);

            return(item);
        }
    }
}
