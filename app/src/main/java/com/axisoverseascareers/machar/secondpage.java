package com.axisoverseascareers.machar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class secondpage extends AppCompatActivity {
    SQLdB sqLdB;
    TextView textView,viewplaces;
    String p1,lat1,log1;
    ArrayList<Details> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);

        sqLdB=new SQLdB(this);

           Intent i =getIntent();
            p1=i.getStringExtra("place1");
            lat1=i.getStringExtra("longitude1");
            log1=i.getStringExtra("latitude1");
        Log.w("place",p1);
        Log.w("longitude1",lat1);
        Log.w("latitude1", log1);

        arrayList = new ArrayList<>();
        arrayList= sqLdB.getplacedetails(p1,log1,lat1);

        textView=findViewById(R.id.display);
        viewplaces=findViewById(R.id.viewplaces);
         if (arrayList.size() >0) {
             textView.setText(sqLdB.display().get(0).getName() + "\n" + sqLdB.display().get(0).getAddress() + "\n" + sqLdB.display().get(0).getAddress1() + "\n" + sqLdB.display().get(0).getPincode() + "\n" + sqLdB.display().get(0).getMobile() + "\n" + sqLdB.display().get(0).getComm_email() + "\n" + sqLdB.display().get(0).getTelephone_1() + "\n" + sqLdB.display().get(0).getWebsite() + "\n"

             );
         }



          viewplaces.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent i =new Intent(secondpage.this,thirdplaces.class);
                  startActivity(i);
              }
          });

    }
}