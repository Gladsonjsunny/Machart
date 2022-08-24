package com.axisoverseascareers.machar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class thirdplaces extends AppCompatActivity {
    SQLdB sqLdB;
    ListView listView;
    ArrayAdapter<Detail1> arr;
    ArrayList<Detail1> arrayList;
    TextView name,address,phone,website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdplaces);
        sqLdB=new SQLdB(this);
        arrayList=new ArrayList<>();
        arrayList=sqLdB.getplaces();
        Log.w("placesssssssss", String.valueOf(arrayList.get(0)));
        listView=findViewById(R.id.list_item);

        arr = new ArrayAdapter<Detail1>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, arrayList);
        listView.setAdapter(arr);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String place_name=parent.getItemAtPosition(position).toString();
                sqLdB.display1(place_name);

                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                ViewGroup viewGroup = view.findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.alert_box, viewGroup, false);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                name=dialogView.findViewById(R.id.name);
                address=dialogView.findViewById(R.id.address);
                phone=dialogView.findViewById(R.id.telephone);
                website=dialogView.findViewById(R.id.wesite);
                name.setText(sqLdB.display1(place_name).get(0).getName());
                address.setText(sqLdB.display1(place_name).get(0).getAddress());
                phone.setText(sqLdB.display1(place_name).get(0).getTelephone_1());
                website.setText(sqLdB.display1(place_name).get(0).getWebsite());




            }
        });

    }
}