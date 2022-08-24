package com.axisoverseascareers.machar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String details="http://machart.in/api/list.php?lat=LATITUDE&lon=LONGITUDE";

   SQLdB sqLdB;

    public void postvideo() {
        Log.w("enter" ,"oojoijkojkoijko");

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.GET, details, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Log.w("responsesiiiiiPOST", response);
                try {
                    JSONArray jsonArray=new JSONArray(response);
                      for (int i=0;i<jsonArray.length();i++){
                          JSONObject jsonObject = jsonArray.getJSONObject(i);
                          sqLdB.details(jsonObject.getString("distance"),
                                        jsonObject.getString("name"),
                                        jsonObject.getString("address_1"),
                                        jsonObject.getString("address_2"),
                                        jsonObject.getString("pincode"),
                                        jsonObject.getString("mobile"),
                                        jsonObject.getString("country_code"),
                                        jsonObject.getString("std_code"),
                                        jsonObject.getString("telephone_1"),
                                        jsonObject.getString("telephone_2"),
                                        jsonObject.getString("comm_email"),
                                        jsonObject.getString("alt_email"),
                                        jsonObject.getString("website"),
                                        jsonObject.getString("reservation_link"),
                                        jsonObject.getString("tariff_min_rate"),
                                        jsonObject.getString("tariff_max_rate"),
                                        jsonObject.getString("place"),
                                        jsonObject.getString("district_id"),
                                        jsonObject.getString("category_id"),
                                        jsonObject.getString("classification_id"),
                                        jsonObject.getString("id"),
                                        jsonObject.getString("latitude"),
                                        jsonObject.getString("longitude"),
                                        jsonObject.getString("image")



                          );
                      }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> Map=new HashMap<>();



                // Map.put("link",link);
                // Map.put("folder",folder_name);

                return Map;

            }
        };

        queue.add(request);

    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        sqLdB=new SQLdB(this);

       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
           getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
       }
       postvideo();
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent i = new Intent(MainActivity.this, firstActivity.class);
               startActivity(i);
               finish();

           }

       }, 10000);


    }
}