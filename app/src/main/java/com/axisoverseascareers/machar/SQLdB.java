package com.axisoverseascareers.machar;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLdB extends SQLiteOpenHelper {

    private static int version = 5;
    private static String dbname = "mydb";
    ArrayList<String> place;

    public SQLdB(@Nullable Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //  String place="create table place (id integer primary key autoincrement,distance text,name text,address_1 text,address_2 text," +
        //    "pincode text,mobile text,countrycode text,stdcode text,telephone_1 text,telephone_2 text,comm_email text,alt_email text,website text,reservation_link text,tariff_min_rate text,tariff_max_rate text,place text,distric_id text,catogery_id text,classification_id text,id text,latitude text,longitude text,image text)";
        String medicine = "create table medycare(id integer primary key autoincrement,distance text,name text,address_1 text,address_2 text,pincode text,mobile text,countrycode text,stdcode text,telephone_1 text,telephone_2 text,comm_email text,alt_email text,website text,reservation_link text,tariff_min_rate text,tariff_max_rate text,place text,distric_id text,catogery_id text,classification_id text,id1 text,latitude text,longitude text,image text)";


        db.execSQL(medicine);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS medycare");


    }


    public void details(String distance, String name, String address, String address_2, String pincode,
                        String mobile, String country_code, String std_code, String telephone_1, String telephone_2,
                        String comm_email, String alt_email, String website, String reservation_link, String tariff_min_rate,
                        String tariff_max_link, String place, String distric_id, String category_id, String classiffication_id,
                        String id, String latitude, String longitude, String image) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("distance", distance);
        contentValues.put("name", name);
        contentValues.put("address_1", address);
        contentValues.put("address_2", address_2);
        contentValues.put("pincode", pincode);
        contentValues.put("mobile", mobile);
        contentValues.put("countrycode", country_code);
        contentValues.put("stdcode", std_code);
        contentValues.put("telephone_1", telephone_1);
        contentValues.put("telephone_2", telephone_2);
        contentValues.put("comm_email", comm_email);
        contentValues.put("alt_email", alt_email);
        contentValues.put("website", website);
        contentValues.put("reservation_link", reservation_link);
        contentValues.put("tariff_min_rate", tariff_min_rate);
        contentValues.put("tariff_max_rate", tariff_max_link);
        contentValues.put("place", place);
        contentValues.put("distric_id", distric_id);
        contentValues.put("catogery_id", category_id);
        contentValues.put("classification_id", classiffication_id);
        contentValues.put("id1", id);
        contentValues.put("latitude", latitude);
        contentValues.put("longitude", longitude);
        contentValues.put("image", image);


        db.insert("medycare", null, contentValues);

    }

    public ArrayList<Details> getplacedetails(String place, String latitude, String longitude) {
        ArrayList<Details> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from medycare  where place in("+place+") and latitude in("+latitude+") and longitude in("+longitude+")", null);


        res.moveToFirst();
        while (!res.isAfterLast()) {
            arrayList.add(new Details(res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10),
                    res.getString(11),
                    res.getString(12),
                    res.getString(13),
                    res.getString(14),
                    res.getString(15),
                    res.getString(16),
                    res.getString(17),
                    res.getString(18),
                    res.getString(19),
                    res.getString(20),
                    res.getString(21),
                    res.getString(22),
                    res.getString(23),
                    res.getString(24)


            ));
            res.moveToNext();

        }
        return arrayList;
    }


  public ArrayList<Details> display1(String place_name){
        ArrayList<Details> arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from place where place = place_name",null);
        res.moveToFirst();
        while (!res.isAfterLast()){
            arrayList.add(new Details(res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10),
                    res.getString(11),
                    res.getString(12),
                    res.getString(13),
                    res.getString(14),
                    res.getString(15),
                    res.getString(16),
                    res.getString(17),
                    res.getString(18),
                    res.getString(19),
                    res.getString(20),
                    res.getString(21),
                    res.getString(22),
                    res.getString(23),
                    res.getString(24)


            ));
            res.moveToNext();

        }
        return arrayList;
    }


    public ArrayList<Details> display() {
        ArrayList<Details> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from medycare", null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            arrayList.add(new Details(res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10),
                    res.getString(11),
                    res.getString(12),
                    res.getString(13),
                    res.getString(14),
                    res.getString(15),
                    res.getString(16),
                    res.getString(17),
                    res.getString(18),
                    res.getString(19),
                    res.getString(20),
                    res.getString(21),
                    res.getString(22),
                    res.getString(23),
                    res.getString(24)


            ));
            res.moveToNext();

        }
        return arrayList;
    }

    @SuppressLint("Range")
    public ArrayList<Detail1> getplaces() {
       ArrayList<Detail1> arrayList1=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
               Cursor res=db.rawQuery("select place from medycare",null);
                //res.moveToFirst();
                while (!res.isAfterLast()){

                    arrayList1.add(new Detail1(res.getString(res.getColumnIndex("place")))
                    );
                    res.moveToNext();
                }
                   //Log.w("placessssssssssssss", String.valueOf(arrayList1.get(0)));
                return arrayList1;

           }
}
