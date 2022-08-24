package com.axisoverseascareers.machar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class firstActivity extends AppCompatActivity {
    EditText place,longitude,latitude;
    Button btn;
    SQLdB sqLdB;
    String place1,longitude1,latitude1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        place=findViewById(R.id.place);
        longitude=findViewById(R.id.longitude);
        latitude=findViewById(R.id.latitude);
        btn=findViewById(R.id.upload);
        sqLdB =new SQLdB(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                           place1=  place.getText().toString();
                        longitude1=longitude.getText().toString();
                        latitude1=  latitude.getText().toString();






             Intent i = new Intent(firstActivity.this,secondpage.class);
                     i.putExtra("place1",place1);
                     i.putExtra("longitude1",longitude1);
                     i.putExtra("latitude1",latitude1);
                startActivity(i);
            }
        });

    }
}